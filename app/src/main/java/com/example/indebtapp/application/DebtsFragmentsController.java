package com.example.indebtapp.application;

import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.domain.SortByDate;
import com.example.indebtapp.repository.DebtRepository;
import com.example.indebtapp.repository.Repositories;

import java.util.ArrayList;

public class DebtsFragmentsController {

    /**
     * Gets the list according to US1
     * @return the fucking list
     */
    public ArrayList<Debt> getDebtList() {
        Repositories repositories = Repositories.getInstance();
        DebtRepository debtRepository = repositories.getDebtRepository();
        ArrayList<Debt> debtslist = debtRepository.getDebtList();
        debtslist.sort(new SortByDate());
        DebtRepository.unpaidFirst(debtslist);
        return debtslist;
    }

    public ArrayList<Debt> searchByContext(ArrayList<Debt> list, String context) {
        return DebtRepository.searchByEntityOrContext(list, context);
    }

    public ArrayList<Debt> filterByPaid(ArrayList<Debt> list) {
        return DebtRepository.filterByStatus(list, true);
    }

    public ArrayList<Debt> filterByUnPaid(ArrayList<Debt> list) {
        return DebtRepository.filterByStatus(list, false);
    }

    public ArrayList<Debt> filterByPositiveAmount(ArrayList<Debt> list) {
        return DebtRepository.filterByAmountPositivity(list, 1);
    }

    public ArrayList<Debt> filterByNegativeAmount(ArrayList<Debt> list) {
        return DebtRepository.filterByAmountPositivity(list, -1);
    }

    public double getTotalBalance(ArrayList<Debt> list){
        return DebtRepository.calculateBalance(list);
    }
}
