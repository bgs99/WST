package bgs.server;

public class SubscriptionServiceFault {
    private static final String DEFAULT_MESSAGE = "Invalid subscription ID";
    
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static SubscriptionServiceFault defaultInstance() {
        SubscriptionServiceFault fault = new SubscriptionServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
