package bgs.server;

public class Subscription {
    private int id;
    private String name;
    private double rate;
    private double throughput;
    private Boolean hasTv;

    public Subscription() {
    }

    public Subscription(int id, String name, double rate, double throughput, boolean hasTv) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.throughput = throughput;
        this.hasTv = hasTv;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public double getThroughput() {
        return throughput;
    }

    public boolean isHasTv() {
        return hasTv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    @Override
    public String toString() {
        return "Subscription{id = " + this.id
            + ", name = " + this.name
            + ", rate = " + this.rate + " roubles"
            + ", throughput = " + this.throughput + " Mbps"
            + ", has tv = " + (this.hasTv ? "Yes" : "No")
            + "}";
    }
}
