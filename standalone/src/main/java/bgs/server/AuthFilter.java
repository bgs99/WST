package bgs.server;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import static jakarta.ws.rs.core.SecurityContext.BASIC_AUTH;
import jakarta.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import static java.util.logging.Level.INFO;
import lombok.extern.java.Log;

@Log
@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(final ContainerRequestContext requestContext) {
        final Method method = resourceInfo.getResourceMethod();

        // Assume no annotation == allow all
        if (!method.isAnnotationPresent(RolesAllowed.class)) {
            return;
        }

        final MultivaluedMap<String, String> headers = requestContext.getHeaders();

        final List<String> authorization = headers.get(AUTHORIZATION);

        if (authorization == null || authorization.isEmpty()) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Authentication required").build());
            return;
        }

        final String encodedUserPassword = authorization.get(0).replaceFirst(BASIC_AUTH + " ", "");

        String usernameAndPassword = new String(Base64.getDecoder().decode(encodedUserPassword.getBytes()));

        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        log.log(INFO, "Provided auth: {0}, {1}", new Object[]{username, password});

        final RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
        final Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));

        final String role = getRole(username, password);

        if (role == null || !rolesSet.contains(role)) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("You cannot access this resource").build());
            return;
        }
    }

    private String getRole(final String username, final String password) {
        if (username.equals("user") && password.equals("pass")) {
            return "ADMIN";
        }
        return null;
    }
}
