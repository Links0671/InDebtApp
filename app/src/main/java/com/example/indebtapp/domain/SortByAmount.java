package com.example.indebtapp.domain;

import java.util.Comparator;

public class SortByAmount implements Comparator<Debt> {

    @Override
    public int compare(Debt debt1, Debt debt2) {
        if(debt1.getAmount() > debt2.getAmount()){
            return 1;
        } else if (debt1.getAmount() < debt2.getAmount()) {
            return -1;
        } else return 0;
    }
}
