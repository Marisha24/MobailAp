package com.example.task_1_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.task_1_2.adapter.CategoryAdapter;
import com.example.task_1_2.form.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Кофе"));
        categoryList.add(new Category(2,"Салаты"));
        categoryList.add(new Category(3,"Гарнир"));
        categoryList.add(new Category(4,"Прочее"));

        setCategoryRecycle(categoryList);
    }

    public void btnContactClick (View view) {
        Intent intent = new Intent(this, EmailActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnLikeClick (View view) {
        Intent intent = new Intent(this, LikeActivity.class);
        startActivity(intent);
        finish();
    }

    private void setCategoryRecycle(List<Category> categoryList) {
   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
     categoryRecycler = findViewById(R.id.categoryRecycler);
     categoryRecycler.setLayoutManager(layoutManager);
      categoryAdapter = new CategoryAdapter(this, categoryList);
     categoryRecycler.setAdapter(categoryAdapter);
    }
}