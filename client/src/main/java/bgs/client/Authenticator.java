package bgs.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import jakarta.ws.rs.core.MultivaluedMap;
import static jakarta.ws.rs.core.SecurityContext.BASIC_AUTH;
import java.io.IOException;
import java.util.Base64;

public class Authenticator implements ClientRequestFilter {
        private final String user;
        private final String password;

        public Authenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        public void filter(ClientRequestContext requestContext) throws IOException {
            MultivaluedMap<String, Object> headers = requestContext.getHeaders();
            final String basicAuthentication = getBasicAuthentication();
            headers.add(AUTHORIZATION, basicAuthentication);
        }

        private String getBasicAuthentication() {
            final String token = this.user + ":" + this.password;
            return String.format("%s %s", BASIC_AUTH, new String(Base64.getEncoder().encode(token.getBytes())));
        }
    }