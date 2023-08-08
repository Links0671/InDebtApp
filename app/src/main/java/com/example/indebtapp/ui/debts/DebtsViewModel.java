package com.example.indebtapp.ui.debts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DebtsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DebtsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Debts:");
    }

    public LiveData<String> getText() {
        return mText;
    }
}