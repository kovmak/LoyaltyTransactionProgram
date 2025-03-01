# Loyalty Transaction Program

## **Overview**
This project implements a simple loyalty program for a supermarket, allowing users to accumulate and redeem bonus points. It provides transaction handling and logging functionalities, demonstrating key software engineering principles for managing transactions in Java.

## **Technologies Used**
- **Java 21** – Primary programming language for development.
- **Log4j 2** – Logging framework for tracking system events.
- **Maven** – Tool for dependency management and project building.

## **Key Features**
- **Points Accumulation** – Users can earn bonus points through purchases.
- **Points Redemption** – Users can spend points if they have a sufficient balance.
- **Transaction Logging** – All operations are logged for transparency.
- **Error Handling** – Proper handling of insufficient balance errors.
- **Transaction History** – A record of all point transactions (earned/spent).

## **How It Works**
1. **Earning Points:**
   - Calling `earnPoints` in `TransactionService` logs the addition of points to a user’s account.

2. **Spending Points:**
   - The system verifies the balance before deducting points.
   - If the balance is insufficient, an error is logged.

3. **Transaction History:**
   - Every transaction (earning or spending points) is recorded in the system logs.

## **Contributions**
We welcome contributions! Feel free to fork the repository, add improvements, fix issues, and submit a pull request.

## **License**
This project is distributed under the MIT License. See the [LICENSE](LICENSE) file for more details.
