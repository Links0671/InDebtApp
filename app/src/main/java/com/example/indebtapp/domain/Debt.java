package com.example.indebtapp.domain;

import java.util.Date;

public class Debt {
    private String entity;
    private double amount;
    private String context;
    private final Date creationDate;
    private boolean isPaid;

    public Debt(String entity, double amount, String context) {
        this.entity = entity;
        this.amount = amount;
        this.context = context;
        this.isPaid = false;
        this.creationDate = new Date();
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public String toString() {
        return String.format("paid=%b | entity=%s | context=%s | amount=%d$", isPaid, entity, context, amount);
    }
}
