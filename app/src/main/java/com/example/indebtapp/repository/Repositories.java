package com.example.indebtapp.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    private DebtRepository debtRepository = new DebtRepository();

    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public DebtRepository getDebtRepository() {
        return debtRepository;
    }

    public void setDebtRepository(DebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }
}
