package com.example.ordenrestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class PMenu extends AppCompatActivity {

    Button iniciaremail,iniciartelefono,Registrarse;
    ImageView bgimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmenu);

        final Animation Zoomin = AnimationUtils.loadAnimation(this,R.anim.zooom1);
        final Animation Zoomout = AnimationUtils.loadAnimation(this, R.anim.zoom2);

        bgimage = findViewById(R.id.back2);
        bgimage.setAnimation(Zoomin);
        bgimage.setAnimation(Zoomout);

        Zoomout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(Zoomin);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bgimage.startAnimation(Zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        iniciaremail=(Button) findViewById(R.id.IniciarEmail);
        iniciartelefono = (Button) findViewById(R.id.IniciarTelefono);
        Registrarse = (Button) findViewById(R.id.Registrarse);

        iniciaremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciarem = new Intent(PMenu.this,Menu2.class);
                startActivity(iniciarem);
                finish();
            }
        });

        iniciartelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciartel = new Intent(PMenu.this,Menu2.class);
                startActivity(iniciartel);
                finish();
            }
        });

        Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro=new Intent(PMenu.this,Menu2.class);
                registro.putExtra("Inicio","Registrarse");
                startActivity(registro);
                finish();
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.gc();
    }
}