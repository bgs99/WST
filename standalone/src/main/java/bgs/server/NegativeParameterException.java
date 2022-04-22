package bgs.server;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "bgs.server.SubscriptionServiceFault")
public class NegativeParameterException extends Exception {

    private final SubscriptionServiceFault fault;

    public NegativeParameterException(String message, SubscriptionServiceFault fault) {
        super(message);
        this.fault = fault;
    }

    public NegativeParameterException(
            String message,
            SubscriptionServiceFault fault,
            Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public SubscriptionServiceFault getFaultInfo() {
        return fault;
    }
}
