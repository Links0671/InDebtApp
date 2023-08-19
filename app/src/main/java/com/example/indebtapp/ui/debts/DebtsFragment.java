package com.example.indebtapp.ui.debts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

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

import java.util.ArrayList;

public class DebtsFragment extends Fragment {
    private FragmentDebtsBinding binding;
    private ListView debtListView;
    private final DebtsFragmentsController controller = new DebtsFragmentsController();
    private ArrayList<Debt> debtArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity main = (MainActivity) this.getActivity();
        DebtsViewModel debtsViewModel = new ViewModelProvider(this).get(DebtsViewModel.class);

        binding = FragmentDebtsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initSearchWidgets(root);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Debt List Stuff
        debtArrayList = controller.getDebtList();
        DebtsListAdapter debtsListAdapter = new DebtsListAdapter(getActivity(), debtArrayList);
        debtListView = (ListView) view.findViewById(R.id.debtsList);
        debtListView.setAdapter(debtsListAdapter);
        debtListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(), "You clicked debt n:" + debtArrayList.get(i).getContext(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSearchWidgets(View view){
        SearchView searchView = (SearchView) view.findViewById(R.id.debtsSearchBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Debt> filteredList = controller.searchByContext(debtArrayList, s);
                DebtsListAdapter debtsListAdapter = new DebtsListAdapter(getActivity(), filteredList);
                debtListView.setAdapter(debtsListAdapter);
                return false;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
