package com.example.indebtapp.domain;

import java.util.Comparator;

public class SortByDate implements Comparator<Debt> {

    @Override
    public int compare(Debt debt1, Debt debt2) {
        if(debt1.getCreationDate().after(debt2.getCreationDate())){
            return 1;
        } else if (debt1.getCreationDate().before(debt2.getCreationDate())) {
            return -1;
        } else return 0;
    }
}
