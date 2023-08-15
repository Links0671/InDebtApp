package com.example.indebtapp.ui;

import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.repository.DebtRepository;
import com.example.indebtapp.repository.Repositories;

public class Bootstrap implements Runnable {
    final boolean serialization = false;
    public void run() {
        if (serialization) {
            loadDebts();
        } else {
            addDebts();
        }
    }

    private void loadDebts() {
    }

    private void addDebts() {
        Repositories repositories = Repositories.getInstance();
        DebtRepository debtRepository = repositories.getDebtRepository();
        debtRepository.addDebt(new Debt("Kingpin", -1.2, "1"));
        debtRepository.addDebt(new Debt("Mafia", 5, "5", true));
        debtRepository.addDebt(new Debt("Neighbour", -10, "2"));
        debtRepository.addDebt(new Debt("Kingpin", 6, "3"));
        debtRepository.addDebt(new Debt("Boss", 50, "6", true));
        debtRepository.addDebt(new Debt("Mom", -750, "4"));
    }
}
