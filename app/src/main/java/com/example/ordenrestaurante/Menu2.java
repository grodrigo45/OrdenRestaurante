package com.example.ordenrestaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu2 extends AppCompatActivity {

    Button Chef, Customer, DeliveryPerson;
    Intent intent;
    String type;
    ConstraintLayout bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);


        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img4), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.bg3), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11), 3000);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);

        bgimage = findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        intent = getIntent();
        type = intent.getStringExtra("Inicio").toString().trim();

        Chef = (Button) findViewById(R.id.chef);
        DeliveryPerson = (Button) findViewById(R.id.repartidor);
        Customer = (Button) findViewById(R.id.cliente);

        Chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("Email")) {
                    Intent loginemail = new Intent(Menu2.this, Cheflogin.class);
                    startActivity(loginemail);
                    finish();
                }
                if (type.equals("Telefono")) {
                    Intent loginphone = new Intent(Menu2.this, Chefloginphone.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("Registrarse")) {
                    Intent Register = new Intent(Menu2.this, ChefRegistration.class);
                    startActivity(Register);
                }
            }
        });

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (type.equals("Email")) {
                    Intent loginemailcust = new Intent(Menu2.this, Login.class);
                    startActivity(loginemailcust);
                    finish();
                }
                if (type.equals("Telefono")) {
                    Intent loginphonecust = new Intent(Menu2.this, Loginphone.class);
                    startActivity(loginphonecust);
                    finish();
                }
                if (type.equals("Registrarse")) {
                    Intent Registercust = new Intent(Menu2.this, Registration.class);
                    startActivity(Registercust);
                }

            }
        });

        DeliveryPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (type.equals("Email")) {
                    Intent loginemail = new Intent(Menu2.this, Delivery_Login.class);
                    startActivity(loginemail);
                    finish();
                }
                if (type.equals("Telefono")) {
                    Intent loginphone = new Intent(Menu2.this, Delivery_Loginphone.class);
                    startActivity(loginphone);
                    finish();
                }
                if (type.equals("Registrarse")) {
                    Intent Registerdelivery = new Intent(Menu2.this, Delivery_Registration.class);
                    startActivity(Registerdelivery);
                }

            }
        });
    }
}