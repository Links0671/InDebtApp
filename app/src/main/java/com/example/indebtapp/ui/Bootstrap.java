package com.example.indebtapp.ui;

import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.repository.DebtRepository;
import com.example.indebtapp.repository.Repositories;

public class Bootstrap implements Runnable {

    public void run() {
        addDebts();
    }

    private void addDebts() {
        Repositories repositories = Repositories.getInstance();
        DebtRepository debtRepository = repositories.getDebtRepository();
        debtRepository.addDebt(new Debt("Kingpin", -1.2, "coffee"));
        debtRepository.addDebt(new Debt("Mafia", 5, "drugs"));
        debtRepository.addDebt(new Debt("Neighbour", -10, "babysitter"));
        debtRepository.addDebt(new Debt("Kingpin", 6, "groceries"));
        debtRepository.addDebt(new Debt("Boss", 50, "unpaid job"));
        debtRepository.addDebt(new Debt("Mom", -750, "rent"));
    }
}
