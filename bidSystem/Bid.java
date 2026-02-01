/**
 * Represents a single bid in the auction.
 */
public class Bid {
    private String user;
    private int amount;
    
    public Bid(String user, int amount) {
        this.user = user;
        this.amount = amount;
    }
    
    public String getUser() {
        return user;
    }
    
    public int getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return user + " (" + amount + ")";
    }
}
