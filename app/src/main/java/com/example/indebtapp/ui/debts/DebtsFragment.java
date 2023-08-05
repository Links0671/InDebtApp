package com.example.indebtapp.ui.debts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.indebtapp.MainActivity;
import com.example.indebtapp.databinding.FragmentDebtsBinding;
import com.example.indebtapp.ui.home.HomeViewModel;

public class DebtsFragment extends Fragment {
    private FragmentDebtsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MainActivity main = (MainActivity) getActivity();
        DebtsViewModel debtsViewModel =
                new ViewModelProvider(this).get(DebtsViewModel.class);

        binding = FragmentDebtsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.testText;
        debtsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
