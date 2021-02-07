package com.tp.exercice8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chercher = (Button) findViewById(R.id.search_btn);

        chercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_chercher();
            }
        });

    }
    void onclick_chercher(){
        Spinner sp_d = (Spinner) findViewById(R.id.spinner0);
        Spinner sp_a = (Spinner) findViewById(R.id.spinner1);

        String d = sp_d.getSelectedItem().toString();
        String a = sp_a.getSelectedItem().toString();

        TextView txt_hor = (TextView) findViewById(R.id.horaire);

        ListView liste = (ListView) findViewById(R.id.liste);

        if(a.equals(d)){
            txt_hor.setVisibility(View.INVISIBLE);
            liste.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), R.string.annuler, Toast.LENGTH_SHORT).show();
        }else{

            txt_hor.setVisibility(View.VISIBLE);
            liste.setVisibility(View.VISIBLE);

            String [] H = testvilles(d,a);
            chargerList(H,liste,d,a);
        }

    }

    String[] testvilles(String d, String a){
        String[] H = {};
        switch (d+a){
            case "NîmesMontpellier":
                H = getResources().getStringArray(R.array.nms_mtp);
                break;
            case "NîmesAvignon":
                H = getResources().getStringArray(R.array.nms_avg);
                break;
            case "NîmesMarseille":
                H = getResources().getStringArray(R.array.nms_mrs);
                break;
            case "MontpellierNîmes":
                H = getResources().getStringArray(R.array.mtp_nms);
                break;
            case "MontpellierAvignon":
                H = getResources().getStringArray(R.array.mtp_avg);
                break;
            case "MontpellierMarseille":
                H = getResources().getStringArray(R.array.mtp_mrs);
                break;
            case "AvignonMontpellier":
                H = getResources().getStringArray(R.array.avg_mtp);
                break;
            case "AvignonNîmes":
                H = getResources().getStringArray(R.array.avg_nms);
                break;
            case "AvignonMarseille":
                H = getResources().getStringArray(R.array.avg_mrs);
                break;
            case "MarseilleAvignon":
                H = getResources().getStringArray(R.array.mrs_avg);
                break;
            case "MarseilleNîmes":
                H = getResources().getStringArray(R.array.mrs_nms);
                break;
            case "MarseilleMontpellier":
                H = getResources().getStringArray(R.array.mrs_mtp);
                break;
        }
        return H;
    }

    void chargerList(String[] H,ListView liste , String d, String a){
        ArrayList<Ligne> L = new ArrayList<Ligne>();
        for(String h : H) {
            String[] D = h.split(",");
            L.add(new Ligne(D[0], D[1], d, a, D[2], D[3]));
        }
        liste.setAdapter(new AdapterLigne(this, L));
    }
}