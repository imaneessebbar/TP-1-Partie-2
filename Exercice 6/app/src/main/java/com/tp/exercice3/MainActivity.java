package com.tp.exercice3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  int w = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.valider_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(v);
            }
        });
    }
        /** AFFICHAGE DE LA FENETRE DE DIALOGUE **/

        public void onClickButton(View v) {
            EditText prenom = (EditText) findViewById(R.id.user_prenom);
            EditText nom = (EditText) findViewById(R.id.user_nom);
            EditText age = (EditText) findViewById(R.id.user_age);
            EditText tel = (EditText) findViewById(R.id.user_phone);
            Spinner sp = (Spinner) findViewById(R.id.spinner1);
            String[] competences =  getResources().getStringArray(R.array.skills);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.demande);
            builder.setMessage(R.string.message);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
                /** POUR CONFIRMER **/
            builder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                     /**VERIFICATION DES CHAMPS SI VIDES OU PAS**/

                     if((nom.getText().toString()).equals("") || (prenom.getText().toString()).equals("") || (age.getText().toString()).equals("") || (tel.getText().toString()).equals("") || sp.getSelectedItem().toString().equals(competences[0]) ){
                            /** SI L'UN DES CHAMPS EST VIDE **/
                        Toast.makeText(getApplicationContext(), R.string.erreur , Toast.LENGTH_LONG).show();
                     }else {
                         /** SI TOUS LES CHAMPS SONT REMPLIS **/
                         String x = getResources().getString(R.string.valid);
                         start(nom.getText().toString(),prenom.getText().toString(),age.getText().toString(),tel.getText().toString(),sp.getSelectedItem().toString());
                         Toast.makeText(getApplicationContext(), x + prenom.getText()+" "+nom.getText() , Toast.LENGTH_LONG).show();

                     }
                }
            });
            builder.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), R.string.anuuler, Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();


        }
    /** DEMARRER UNE ACTIVITE */
    void start(String n,String p,String a,String ph,String s){
            Intent i = new Intent(this, OkActivity.class);
            i.putExtra("nom",n);
            i.putExtra("prenom",p);
            i.putExtra("age",a);
            i.putExtra("tel",ph);
            i.putExtra("sp",s);
            startActivity(i);
        }
}