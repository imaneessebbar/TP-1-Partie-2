package com.tp.exercice3;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socond_layout);
        Intent intent = getIntent();

        Button button_ok = (Button) findViewById(R.id.ok_button);
        Button button_back = (Button) findViewById(R.id.return_button);

        TextView v_prenom = (TextView) findViewById(R.id.show_prenom);
        v_prenom.setText(intent.getStringExtra("prenom"));
        TextView v_nom = (TextView) findViewById(R.id.show_nom);
        v_nom.setText(intent.getStringExtra("nom"));
        TextView v_age = (TextView) findViewById(R.id.show_age);
        v_age.setText(intent.getStringExtra("age"));
        TextView v_tel = (TextView) findViewById(R.id.show_phone);
        v_tel.setText(intent.getStringExtra("tel"));
        TextView v_sp = (TextView) findViewById(R.id.show_skill);
        v_sp.setText(intent.getStringExtra("sp"));

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             okstart();
            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               backstart();
            }
        });
    }
    public void okstart(){
        Intent i = new Intent(this, BackActivity.class);
        startActivity(i);
    }
    public void backstart(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
