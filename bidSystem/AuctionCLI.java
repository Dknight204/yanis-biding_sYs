import java.util.Scanner;

/**
 * Command-line interface for the auction system.
 */
public class AuctionCLI {
    private AuctionManager auction;
    private Scanner scanner;
    
    public AuctionCLI() {
        auction = new AuctionManager();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Process a single command line.
     * 
     * @param commandLine The command line to process
     */
    public void processCommand(String commandLine) {
        commandLine = commandLine.trim();
        if (commandLine.isEmpty()) {
            return;
        }
        
        String[] parts = commandLine.split("\\s+");
        String command = parts[0].toUpperCase();
        
        switch (command) {
            case "BID":
                handleBidCommand(parts);
                break;
            case "WITHDRAW":
                handleWithdrawCommand();
                break;
            case "CURRENT":
                handleCurrentCommand();
                break;
            case "HELP":
                showHelp();
                break;
            case "EXIT":
                System.out.println("Exiting auction system.");
                System.exit(0);
                break;
            default:
                System.out.println("Error: Unknown command '" + command + "'. Type HELP for available commands.");
                break;
        }
    }
    
    /**
     * Handle the BID command.
     */
    private void handleBidCommand(String[] parts) {
        if (parts.length != 3) {
            System.out.println("Error: BID command requires user and amount.");
            return;
        }
        
        String user = parts[1];
        int amount;
        try {
            amount = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Amount must be a number.");
            return;
        }
        
        AuctionManager.Result result = auction.placeBid(user, amount);
        System.out.println(result.getMessage());
        if (result.isSuccess()) {
            System.out.println(auction.getStackDisplay());
        }
    }
    
    /**
     * Handle the WITHDRAW command.
     */
    private void handleWithdrawCommand() {
        AuctionManager.Result result = auction.withdraw();
        System.out.println(result.getMessage());
        if (result.isSuccess()) {
            System.out.println(auction.getStackDisplay());
        }
    }
    
    /**
     * Handle the CURRENT command.
     */
    private void handleCurrentCommand() {
        AuctionManager.Result result = auction.getCurrentWinner();
        System.out.println(result.getMessage());
    }
    
    /**
     * Display available commands.
     */
    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("  BID <user> <amount>  - Place a new bid");
        System.out.println("  WITHDRAW             - Withdraw current highest bid");
        System.out.println("  CURRENT              - Show current winner");
        System.out.println("  HELP                 - Show this help message");
        System.out.println("  EXIT                 - Exit the auction system");
    }
    
    /**
     * Run the interactive auction CLI.
     */
    public void run() {
        System.out.println("=== High-Stakes Auctioneer System ===");
        System.out.println("Type HELP for available commands or EXIT to quit.");
        System.out.println();
        
        while (true) {
            try {
                System.out.print("> ");
                String commandLine = scanner.nextLine();
                processCommand(commandLine);
            } catch (Exception e) {
                System.out.println("\nExiting auction system.");
                break;
            }
        }
        
        scanner.close();
    }
}
