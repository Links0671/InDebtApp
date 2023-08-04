package com.example.indebtapp.repository;

import android.util.Pair;

import com.example.indebtapp.domain.Debt;

import java.util.*;

public class DebtRepository {
    private List<Debt> debtList = new ArrayList<Debt>();

    public boolean addDebt(Debt debt){
        if (!debtList.contains(debt)){
            debtList.add(debt);
            return true;
        } else {
            return false;
        }
    }

    public List<Debt> getDebtList(){
        return new ArrayList<Debt>(debtList);
    }

    public double calculateBalance(){
        int balance = 0;
        for (Debt debt : debtList) {
            balance += debt.getAmount();
        }
        return balance;
    }

    public void unpaidFirst(List<Debt> debtList){
        Debt temp;
        for (int i = debtList.size() - 1; i > 1; i--) {
            if (!debtList.get(i).isPaid()) {
                for (int j = i; j > 1; j--) {
                    temp = debtList.get(j);
                    debtList.set(j, debtList.get(j-1));
                    debtList.set(j - 1, temp);
                }
            }
        }
    }
}
