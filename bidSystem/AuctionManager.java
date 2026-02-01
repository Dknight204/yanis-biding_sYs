import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Manages the auction using a stack-based approach.
 */
public class AuctionManager {
    private Stack<Bid> bidStack;
    
    public AuctionManager() {
        bidStack = new Stack<>();
    }
    
    /**
     * Place a new bid.
     * 
     * @param user The bidder's name
     * @param amount The bid amount
     * @return Result object containing success status and message
     */
    public Result placeBid(String user, int amount) {
        if (bidStack.isEmpty()) {
            // First bid, always valid
            bidStack.push(new Bid(user, amount));
            return new Result(true, "Current: " + user + " (" + amount + ")");
        }
        
        int currentMax = bidStack.peek().getAmount();
        if (amount <= currentMax) {
            return new Result(false, "Error: Too low.");
        }
        
        bidStack.push(new Bid(user, amount));
        return new Result(true, "Current: " + user + " (" + amount + ")");
    }
    
    /**
     * Withdraw the current highest bid.
     * 
     * @return Result object containing success status and message
     */
    public Result withdraw() {
        if (bidStack.isEmpty()) {
            return new Result(false, "Error: No bids to withdraw.");
        }
        
        Bid currentBid = bidStack.pop();
        StringBuilder message = new StringBuilder();
        message.append(currentBid.getUser()).append(" retracted.\n");
        
        if (!bidStack.isEmpty()) {
            Bid previousBid = bidStack.peek();
            message.append("Reverted to ").append(previousBid.getUser()).append(" (")
                   .append(previousBid.getAmount()).append(").");
        } else {
            message.append("No previous bids available.");
        }
        
        return new Result(true, message.toString());
    }
    
    /**
     * Get the current highest bidder.
     * 
     * @return Result object containing success status and message
     */
    public Result getCurrentWinner() {
        if (bidStack.isEmpty()) {
            return new Result(false, "Error: No current bids.");
        }
        
        Bid currentBid = bidStack.peek();
        return new Result(true, "Current: " + currentBid.getUser() + " (" + currentBid.getAmount() + ")");
    }
    
    /**
     * Display the current stack for debugging.
     * 
     * @return String representation of the stack
     */
    public String getStackDisplay() {
        if (bidStack.isEmpty()) {
            return "Stack: []";
        }
        
        List<String> amounts = new ArrayList<>();
        for (Bid bid : bidStack) {
            amounts.add(String.valueOf(bid.getAmount()));
        }
        
        return "Stack: [" + String.join(", ", amounts) + "]";
    }
    
    /**
     * Helper class to return operation results.
     */
    public static class Result {
        private boolean success;
        private String message;
        
        public Result(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
        
        public boolean isSuccess() {
            return success;
        }
        
        public String getMessage() {
            return message;
        }
    }
}