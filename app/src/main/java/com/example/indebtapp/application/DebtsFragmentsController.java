package com.example.indebtapp.application;

import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.repository.DebtRepository;
import com.example.indebtapp.repository.Repositories;

import java.util.ArrayList;

public class DebtsFragmentsController {
    public ArrayList<Debt> getDebtList() {
        Repositories repositories = Repositories.getInstance();
        DebtRepository debtRepository = repositories.getDebtRepository();
        return debtRepository.getDebtList();
    }


}
