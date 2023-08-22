package com.example.indebtapp.repository;

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

    public ArrayList<Debt> getDebtList(){
        return new ArrayList<Debt>(debtList);
    }

    /**
     * calculates the sum of amounts
     * @return i wander what it returns
     */
    public double calculateBalance(){
        int balance = 0;
        for (Debt debt : debtList) {
            balance += debt.getAmount();
        }
        return balance;
    }

    /**
     * puts the unpaid first
     * @param debtList a debt list
     */
    public static void unpaidFirst(List<Debt> debtList){
        Debt temp;
        int count = 0;
        for (int i = debtList.size() - 1; i > 0; i--){
            if (debtList.get(i).isPaid()) {
                for (int j = i; j < debtList.size()-1-count; j++) {
                    temp = debtList.get(j);
                    debtList.set(j, debtList.get(j + 1));
                    debtList.set(j + 1, temp);
                }
                count++;
            }
        }
    }

    public static ArrayList<Debt> filterByAmountPositivity(ArrayList<Debt> list, int balancePositivity){
        ArrayList<Debt> filteredList = new ArrayList<Debt>();
        for (Debt debt: list) {
            if (debt.getAmount() * balancePositivity >= 0) {
                filteredList.add(debt);
            }
        }
        return filteredList;
    }

    public static ArrayList<Debt> filterByStatus(ArrayList<Debt> list, Boolean status){
        ArrayList<Debt> filteredList = new ArrayList<Debt>();
        for (Debt debt: list) {
            if (debt.isPaid() == status) {
                filteredList.add(debt);
            }
        }
        return filteredList;
    }

    public static ArrayList<Debt> searchByEntityOrContext(ArrayList<Debt> list, String context){
        ArrayList<Debt> filteredList = new ArrayList<Debt>();
        for (Debt debt: list) {
            if (debt.getContext().toLowerCase().contains(context.toLowerCase()) || debt.getEntity().toLowerCase().contains(context.toLowerCase())) {
                filteredList.add(debt);
            }
        }
        return filteredList;
    }
}
