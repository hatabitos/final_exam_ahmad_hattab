package com.example.ahattab.final_exam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import java.util.List;
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    List<Food> foodList;


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView displayFoodName, displayCalories, displayQuantity, displayDate;


        MyViewHolder(View view) {
            super(view);

            displayFoodName = view.findViewById(R.id.display_name);
            displayCalories = view.findViewById(R.id.display_calories);
            displayQuantity = view.findViewById(R.id.display_quantity);
            displayDate = view.findViewById(R.id.display_date);
        }
    }

    FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_food_adapter, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodAdapter.MyViewHolder viewHolder, final int i) {
        final Food food = foodList.get(i);

        viewHolder.displayFoodName.setText(food.getFoodName()) ;
        viewHolder.displayCalories.setText(String.valueOf(food.getCalories()));
        viewHolder.displayQuantity.setText(String.valueOf(food.getQuantity()));
        viewHolder.displayDate.setText(food.getFirstDate());


    }

    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}

