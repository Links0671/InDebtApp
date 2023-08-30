package com.example.indebtapp.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.indebtapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that adapts the debt list into the List View
 */
public class DebtsListAdapter extends ArrayAdapter<Debt> {

    public DebtsListAdapter(@NonNull Context context, ArrayList<Debt> arrayList) {
        super(context, R.layout.list_item_debt, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Debt debt = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_debt, parent, false);
        }

        assert debt != null;
        CheckBox paid = convertView.findViewById(R.id.paidCheckBox);
        TextView entity = convertView.findViewById(R.id.entity);
        TextView context = convertView.findViewById(R.id.context);
        TextView amount = convertView.findViewById(R.id.amount);

        paid.setChecked(debt.isPaid());
        entity.setText(debt.getEntity());
        context.setText(debt.getContext());
        String text = debt.getAmount() + "€";
        amount.setText(text);
        return convertView;
    }
}
