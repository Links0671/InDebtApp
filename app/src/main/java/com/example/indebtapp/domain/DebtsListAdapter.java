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

    private Context context;
    private ArrayList<Debt> array;

    public DebtsListAdapter(@NonNull Context context, int resource,ArrayList<Debt> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.array = new ArrayList<>(arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null) {
            LayoutInflater i = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = i.inflate(R.layout.list_item_debt, parent, false);
        }
        if(array.size() > 0){
            Debt debt = getItem(position);

            CheckBox paid = convertView.findViewById(R.id.paidCheckBox);
            assert debt != null;
            paid.setActivated(debt.isPaid());

            TextView entity = convertView.findViewById(R.id.entity);
            entity.setText(debt.getEntity());

            TextView context = convertView.findViewById(R.id.context);
            context.setText(debt.getContext());

            TextView amount = convertView.findViewById(R.id.amount);
            String text = debt.getAmount() + "€";
            amount.setText(text);
        }
        return convertView;
    }
}
