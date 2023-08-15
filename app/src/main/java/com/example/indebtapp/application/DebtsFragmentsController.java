package com.example.indebtapp.application;

import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.domain.SortByAmount;
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
        debtRepository.unpaidFirst(debtslist);
        return debtslist;
    }
}
