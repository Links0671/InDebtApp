package com.example.indebtapp.ui.debts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.indebtapp.MainActivity;
import com.example.indebtapp.R;
import com.example.indebtapp.application.DebtsFragmentsController;
import com.example.indebtapp.databinding.FragmentDebtsBinding;
import com.example.indebtapp.domain.Debt;
import com.example.indebtapp.domain.DebtsListAdapter;
import com.example.indebtapp.repository.DebtRepository;
import com.example.indebtapp.repository.Repositories;
import com.example.indebtapp.ui.home.HomeViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class DebtsFragment extends Fragment {
    private FragmentDebtsBinding binding;
    private ListView debtListView;
    private final DebtsFragmentsController controller = new DebtsFragmentsController();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity main = (MainActivity) this.getActivity();
        DebtsViewModel debtsViewModel = new ViewModelProvider(this).get(DebtsViewModel.class);

        binding = FragmentDebtsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.text;
        debtsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Debt> debtArrayList = controller.getDebtList();
        DebtsListAdapter debtsListAdapter = new DebtsListAdapter(getActivity(), debtArrayList);
        debtListView = (ListView) view.findViewById(R.id.debtsList);
        debtListView.setAdapter(debtsListAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
