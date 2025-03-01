package com.krnelx.transactionloyaltyprogram.service;

import com.krnelx.transactionloyaltyprogram.model.UserAccount;
import com.krnelx.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TransactionService {

    private static final Logger logger = LogManager.getLogger(TransactionService.class);

    public void earnPoints(UserAccount user, int points) {
        Objects.requireNonNull(user, "User account cannot be null");

        user.addPoints(points);
        String message = String.format("%d points added for user %s", points, user.getName());
        TransactionHistory.addTransaction("+" + points + " " + message);
        logger.info(message);
    }

    public void spendPoints(UserAccount user, int points) {
        Objects.requireNonNull(user, "User account cannot be null");

        if (user.getBonusPoints() < points) {
            logger.warn("Attempt to spend {} points by user {} failed due to insufficient balance", points, user.getName());
            throw new InsufficientPointsException("Not enough bonus points!");
        }

        user.subtractPoints(points);
        String message = String.format("%d points spent by user %s", points, user.getName());
        TransactionHistory.addTransaction("-" + points + " " + message);
        logger.info(message);
    }

    public int checkBalance(UserAccount user) {
        Objects.requireNonNull(user, "User account cannot be null");
        return user.getBonusPoints();
    }
}
