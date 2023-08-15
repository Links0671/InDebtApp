package com.example.indebtapp.domain;

import androidx.annotation.NonNull;

import java.util.Date;

public class Debt {
    /**
     * The entity the user is in debt or is in debt to the user
     */
    private String entity;
    /**
     * The amount of the debt
     * positive if the entity ows the user
     * negative if the user ows the entity
     */
    private double amount;
    /**
     * The why of the debt
     */
    private String context;
    /**
     * The birth time of the debt
     */
    private final Date creationDate;
    /**
     * If the debt was paid
     */
    private boolean isPaid;

    public Debt(String entity, double amount, String context) {
        this.entity = entity;
        this.amount = amount;
        this.context = context;
        this.isPaid = false;
        this.creationDate = new Date();
    }

    public Debt(String entity, double amount, String context, boolean isPaid) {
        this.entity = entity;
        this.amount = amount;
        this.context = context;
        this.isPaid = isPaid;
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
}
