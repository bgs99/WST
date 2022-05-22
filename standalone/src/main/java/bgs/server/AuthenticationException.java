package bgs.server;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "bgs.server.SubscriptionServiceFault")
public class AuthenticationException extends Exception {

    private final static String MESSAGE = "You cannot access this method";

    private final SubscriptionServiceFault fault;

    public AuthenticationException(SubscriptionServiceFault fault) {
        super(MESSAGE);
        this.fault = fault;
    }

    public AuthenticationException(
            SubscriptionServiceFault fault,
            Throwable cause) {
        super(MESSAGE, cause);
        this.fault = fault;
    }

    public SubscriptionServiceFault getFaultInfo() {
        return fault;
    }
}
