package com.example.task_1_2;

import static android.os.Build.ID;
import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.task_1_2.DB.DBHelper;

public class LikeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnRead, btnClear, btnApdate;
    EditText etRecipe, etTechnology, etID, etOutput;
    SimpleCursorAdapter userAdapter;
    DBHelper dbHelper;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView);
//        listView.setOnClickListener(this);

//        btnApdate = (Button) findViewById(R.id.btnApdate);
//        btnApdate.setOnClickListener(this);

        etRecipe = (EditText) findViewById(R.id.etRecipe);
        etTechnology = (EditText) findViewById(R.id.etTechnology);
      //  etOutput = (EditText) findViewById(R.id.textView);
//        etID = (EditText) findViewById(R.id.etID);
        dbHelper = new DBHelper(this);
    }
    public void btnContactClick (View view) {
        Intent intent = new Intent(this, EmailActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnMainClick (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @SuppressLint("RestrictedApi")
    public void onClick(View v) {
        String recipe = etRecipe.getText().toString();
        String technology = etTechnology.getText().toString();
     //   String _id = etID.getText().toString();
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        switch (v.getId()) {

            case R.id.btnAdd:
                contentValues.put(DBHelper.RESIPE_NAME, recipe);
                contentValues.put(DBHelper.TECHNOLOGY,technology);

                database.insert(DBHelper.TABLE_RESIPE, null, contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_RESIPE, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int recipeIndex = cursor.getColumnIndex(DBHelper.RESIPE_NAME);
                    int technologyIndex = cursor.getColumnIndex(DBHelper.TECHNOLOGY);
                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", recipe = " + cursor.getString(recipeIndex) +
                                ", technology = " + cursor.getString(technologyIndex));
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");


//                userAdapter = new SimpleCursorAdapter(this, R.id.textView,
//                        cursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
//                userList.setAdapter(userAdapter);


                cursor.close();
                break;
//            case R.id.btnApdate:
//
//                Log.d(LOG_TAG, "--- Update mytable: ---");
//                // подготовим значения для обновления
//
//                contentValues.put(DBHelper.RESIPE_NAME, recipe);
//                contentValues.put(DBHelper.TECHNOLOGY,technology);
//                contentValues.put(DBHelper.KEY_ID,_id);
//                database.update(DBHelper.TABLE_RESIPE, contentValues,  ID + " =?",_id, null);
////                cv.put("name", name);
////                cv.put("email", email);
//                // обновляем по id
//                int updCount = Log.d.update("mytable", cv, "id = ?",
//                        new String[] { id });
//                Log.d(LOG_TAG, "updated rows count = " + updCount);
//                break;

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_RESIPE, null, null);
                break;
        }
        dbHelper.close();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

