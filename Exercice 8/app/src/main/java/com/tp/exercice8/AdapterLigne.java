package com.tp.exercice8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterLigne extends BaseAdapter {

    private List<Ligne> liste;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterLigne(Context c,  List<Ligne> liste) {
        this.context = c;
        this.liste = liste;
        this.layoutInflater = LayoutInflater.from(c);
    }
    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Ligne getItem(int position) {
        return  liste.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View myLayoutlist, ViewGroup parent) {

        Ligne ligne = this.liste.get(position);

        myLayoutlist = layoutInflater.inflate(R.layout.item_list, null);

        TextView  txt_vd = (TextView) myLayoutlist.findViewById(R.id.textView3);
        TextView  txt_va = (TextView) myLayoutlist.findViewById(R.id.textView4);

        TextView txt_hd = (TextView) myLayoutlist.findViewById(R.id.textView);
        TextView txt_ha = (TextView) myLayoutlist.findViewById(R.id.textView2);

        TextView txt_d = (TextView) myLayoutlist.findViewById(R.id.textView5);
        TextView txt_t = (TextView) myLayoutlist.findViewById(R.id.textView6);



        txt_vd.setText(ligne.getDepart_v());
        txt_va.setText(ligne.getArrive_v());
        txt_hd.setText(ligne.getDepart_h()); //hd
        txt_ha.setText(ligne.getArrive_h()); //ha
        txt_d.setText(ligne.getDuree());
        txt_t.setText(ligne.getTrain());

        return myLayoutlist;
    }


}
