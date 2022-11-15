package com.example.ordenrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ChooseOne extends AppCompatActivity {

    Button Chef, Customer, DeliveryPerson;
    Intent intent;
    String type;
    ConstraintLayout bgimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);
    }
}