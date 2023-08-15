package com.example.indebtapp.domain;

import java.util.Comparator;

/**
 * Sorts debts by amounts
 * smol to bigger
 */
public class SortByAmount implements Comparator<Debt> {

    @Override
    public int compare(Debt debt1, Debt debt2) {
        return Double.compare(debt1.getAmount(), debt2.getAmount());
    }
}
