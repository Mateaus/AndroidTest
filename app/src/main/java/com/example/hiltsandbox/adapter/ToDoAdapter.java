package com.example.hiltsandbox.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiltsandbox.R;
import com.example.hiltsandbox.databinding.ToDoRowBinding;
import com.example.hiltsandbox.model.ToDo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDo> toDoList;

    public ToDoAdapter() {
        toDoList = new ArrayList<>();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.to_do_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ToDo toDo = toDoList.get(position);

        String userId = "UserId: " + toDo.getUserId();
        String id = "Id: " + toDo.getId();
        String title = "Title: " + toDo.getTitle();
        String completed = "Completed: " + toDo.isCompleted();

        holder.toDoRowViewBinding.userIdTextView.setText(userId);
        holder.toDoRowViewBinding.idTextView.setText(id);
        holder.toDoRowViewBinding.titleTextView.setText(title);
        holder.toDoRowViewBinding.completedTextView.setText(completed);
    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ToDoRowBinding toDoRowViewBinding;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.toDoRowViewBinding = DataBindingUtil.bind(itemView);
        }
    }
}
