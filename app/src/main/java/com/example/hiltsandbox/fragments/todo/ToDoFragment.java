package com.example.hiltsandbox.fragments.todo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hiltsandbox.R;
import com.example.hiltsandbox.adapter.ToDoAdapter;
import com.example.hiltsandbox.databinding.FragmentToDoBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ToDoFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "ToDoFragment";

    @Inject
    ToDoAdapter toDoAdapter;

    private ToDoViewModel toDoViewModel;

    private FragmentToDoBinding toDoViewBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        toDoViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do, container, false);

        return toDoViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUi();

        setUpRecyclerView();

        setUpViewModel();
    }

    @Override
    public void onClick(View v) {
        int itemView = v.getId();
        if (itemView == R.id.toDoFloatingActionButton) {
            toDoViewModel.sendToDoListRequest();
        }
    }

    private void initUi() {
        toDoViewBinding.toDoFloatingActionButton.setOnClickListener(this);
    }

    private void setUpRecyclerView() {
        toDoViewBinding.toDoRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        toDoViewBinding.toDoRecyclerView.setAdapter(toDoAdapter);
    }

    private void setUpViewModel() {
        toDoViewModel = new ViewModelProvider(this).get(ToDoViewModel.class);

        toDoViewModel.getTodoList().observe(getViewLifecycleOwner(), toDoList -> {
            if (toDoList == null) {
                return;
            }

            Log.d(TAG, "onChanged: New Todo List received");
            toDoAdapter.setToDoList(toDoList);
            toDoAdapter.notifyDataSetChanged();
        });
    }
}
