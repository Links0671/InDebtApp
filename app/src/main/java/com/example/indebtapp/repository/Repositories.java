package com.example.indebtapp.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();

    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }
}
