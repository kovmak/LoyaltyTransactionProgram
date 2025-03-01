package com.krnelx.transactionloyaltyprogram;

import com.krnelx.transactionloyaltyprogram.model.UserAccount;
import com.krnelx.transactionloyaltyprogram.service.TransactionService;
import com.krnelx.transactionloyaltyprogram.service.TransactionHistory;
import com.krnelx.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoyaltyProgram {

    private static final Logger logger = LogManager.getLogger(LoyaltyProgram.class);

    public static void main(String[] args) {
        UserAccount user = new UserAccount(1, "Maksym", 110);
        TransactionService service = new TransactionService();

        logger.info("Initial balance: {} points", service.checkBalance(user));

        service.earnPoints(user, 10);
        logger.info("After earning points, balance: {} points", service.checkBalance(user));

        service.spendPoints(user, 30);
        logger.info("After spending points, balance: {} points", service.checkBalance(user));

        try {
            service.spendPoints(user, 110);
        } catch (InsufficientPointsException e) {
            logger.error("Transaction failed: Not enough bonus points. User balance: {} points", service.checkBalance(user));
        }

        logger.info("Final balance: {} points", service.checkBalance(user));

        TransactionHistory.printHistory();
    }
}
