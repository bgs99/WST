package bgs.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@NoArgsConstructor()
@AllArgsConstructor()
public class  Subscription {
    private int id;
    private String name;
    private double rate;
    private double throughput;
    private Boolean hasTv;

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
