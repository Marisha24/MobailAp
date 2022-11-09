package com.example.task_1_2.form;

public class Category {
    int id;
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
