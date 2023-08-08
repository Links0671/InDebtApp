package com.example.indebtapp.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.indebtapp.R;

import java.util.ArrayList;
import java.util.List;

public class DebtsListAdapter extends ArrayAdapter<Debt> {

    public DebtsListAdapter(@NonNull Context context, ArrayList<Debt> arrayList) {
        super(context, R.layout.list_item_debt, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent){
        View currentItemView = view;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_debt, parent, false);
        }

        Debt debt = getItem(position);

        CheckBox paid = currentItemView.findViewById(R.id.paidCheckBox);
        assert debt != null;
        paid.setActivated(debt.isPaid());

        TextView entity = currentItemView.findViewById(R.id.entity);
        entity.setText(debt.getEntity());

        TextView context = currentItemView.findViewById(R.id.context);
        context.setText(debt.getContext());

        TextView amount = currentItemView.findViewById(R.id.amount);
        String text = debt.getAmount() + "€";
        amount.setText(text);

        return currentItemView;
    }
}
