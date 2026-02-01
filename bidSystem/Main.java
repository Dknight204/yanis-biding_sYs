/**
 * Main class to execute the auction system.
 * Run this class to start the interactive auction CLI.
 */
public class Main {
    
    /**
     * Main entry point for the auction system.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting High-Stakes Auctioneer System...");
        System.out.println();
        
        // Create and run the auction CLI
        AuctionCLI cli = new AuctionCLI();
        cli.run();
    }
}
