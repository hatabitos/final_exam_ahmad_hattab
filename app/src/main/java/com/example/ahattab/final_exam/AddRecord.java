package com.example.ahattab.final_exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
//        CalendarView calender = findViewById(R.id.calendarView1);
//        EditText foodName = findViewById(R.id.edit_foodName);
//        EditText quantity = findViewById(R.id.edit_food_quantity);
//        EditText cal = findViewById(R.id.edit_cal);
        Button saveRec = findViewById(R.id.btn_save);

        saveRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBManager dbc = new DBManager(getApplicationContext());
                EditText editName = findViewById(R.id.edit_foodName);
                EditText editCalories = findViewById(R.id.edit_cal);
                EditText editQuantity = findViewById(R.id.edit_food_quantity);
                final TextView textDate = findViewById(R.id.set_date);

                CalendarView calender = (CalendarView)findViewById(R.id.calendarView1);
                calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month,
                                                    int dayOfMonth) {
                        // TODO Auto-generated method stub


                        textDate.setText(dayOfMonth +" / " + (month+1) + " / " + year);

                    }
                });



                Food newFood = new Food(
                        textDate.getText().toString(),
                        editName.getText().toString(),
                        Integer.valueOf( editCalories.getText().toString()),
                        Integer.valueOf(editQuantity.getText().toString()));


                dbc.addFood(newFood);
                Toast.makeText(getApplicationContext(), "Record added" ,Toast.LENGTH_LONG).show();
                Intent i = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
    }
}
