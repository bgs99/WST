package bgs.server;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NegativeParameterExceptionMapper implements ExceptionMapper<NegativeParameterException> {
    @Override
    public Response toResponse(NegativeParameterException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
