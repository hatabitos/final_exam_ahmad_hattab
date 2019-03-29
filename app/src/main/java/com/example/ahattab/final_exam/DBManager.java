package com.example.ahattab.final_exam;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    public DBManager(Context context) {
        super(context, Food.TABLE_NAME, null, DATABASE_VERSION);
    }

    public Food addFood(Food f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Food.COLUMN_FOODNAME, f.getFoodName());
        values.put(Food.COLUMN_QUANTITY, f.getQuantity());
        values.put(Food.COLUMN_CALORIES, f.getCalories());
        values.put(Food.COLUMN_DATE,f.getFirstDate());


        db.insert(Food.TABLE_NAME, null, values);

        return f;

    }

//    public List<Food> getFood(){
//        SQLiteDatabase db = getReadableDatabase();
//        String selectQuery = "select * from " + Food.TABLE_NAME ;
//        Cursor c = db.rawQuery(selectQuery, null);
//        List<Food> foodList = new ArrayList<>();
//
//        if(c.moveToFirst()){
//            do{
//                Food foundFood = new Food();
//                foundFood.foodName= c.getString(c.getColumnIndex(Food.COLUMN_FOODNAME));
//                foundFood.calories = c.getInt(c.getColumnIndex(Food.COLUMN_CALORIES));
//                foundFood.quantity = c.getInt(c.getColumnIndex(Food.COLUMN_QUANTITY));
//                foundFood.firstDate = c.getString(c.getColumnIndex(Food.COLUMN_DATE));
//            }while (c.moveToNext());
//        }
//        db.close();
//        return foodList;
//
//    }

    public List<Food> getFoods()
    {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "select * from " + Food.TABLE_NAME;

        Cursor c = db.rawQuery(selectQuery, null);

        List<Food> fdList = new ArrayList<>();

        if (c.moveToFirst())
        {
            do {
                Food foundFood = new Food();
                foundFood.foodName = c.getString(c.getColumnIndex(Food.COLUMN_FOODNAME));
                foundFood.calories = c.getInt(c.getColumnIndex(Food.COLUMN_CALORIES));
                foundFood.quantity = c.getInt(c.getColumnIndex(Food.COLUMN_QUANTITY));
                foundFood.firstDate = c.getString(c.getColumnIndex(Food.COLUMN_DATE));

                fdList.add(foundFood);

            } while (c.moveToNext());
        }

        db.close();
        return fdList;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Food.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }}
