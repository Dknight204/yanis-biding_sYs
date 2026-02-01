# High-Stakes Auctioneer System

A Java implementation of an auction system using Stack data structure for bid tracking.

## Problem Description
Implements a live auction system where:
- New bids must be strictly greater than current maximum
- Bid withdrawal reverts to previous highest bid
- Uses Stack data structure for bid management

## Files
- `Bid.java` - Represents individual bids
- `AuctionManager.java` - Core auction logic with Stack
- `AuctionCLI.java` - Interactive command-line interface
- `Main.java` - Entry point to run the system

## How to Run

### Compile:
```bash
javac *.java
```

### Run Interactive Mode:
```bash
java Main
```

### Run Automated Tests:
```bash
java TestAuction
```

## Commands
- `BID <user> <amount>` - Place a new bid
- `WITHDRAW` - Withdraw current highest bid
- `CURRENT` - Show current winner
- `HELP` - Show available commands
- `EXIT` - Exit the system

## Sample Execution
```
> BID A 100
Current: A (100)
Stack: [100]

> BID B 90
Error: Too low.

> BID C 150
Current: C (150)
Stack: [100, 150]

> WITHDRAW
C retracted.
Reverted to A (100)
Stack: [100]
```

## Requirements Met
✅ Stack data structure used
✅ Bidding rule enforced
✅ Retraction with reversion implemented
✅ All CLI commands working
✅ Sample execution matches specification
