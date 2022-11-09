package com.example.task_1_2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_1_2.form.Category;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>
{
    Context context;
    List<Category> categories;

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//дизайн для отображения каждого элемента
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {//что подставляем в изайн

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static final class MenyViewHolder extends RecyclerView.ViewHolder// с какими элементами будем работать
    {


        public MenyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

