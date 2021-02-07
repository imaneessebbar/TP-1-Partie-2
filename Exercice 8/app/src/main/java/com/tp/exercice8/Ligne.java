package com.tp.exercice8;

public class Ligne {
    private String depart_h;
    private String arrive_h;
    private String depart_v;
    private String arrive_v;
    private String duree;
    private String train;

    public Ligne(String dh, String ah,String dv, String av,String d,String t){
        this.depart_h=dh;
        this.depart_v=dv;
        this.arrive_h=ah;
        this.arrive_v=av;
        this.duree=d;
        this.train=t;
    }
    String getDepart_h(){
        return depart_h;
    }
    String getDepart_v(){
        return depart_v;
    }
    String getArrive_h(){
        return arrive_h;
    }
    String getArrive_v(){
        return arrive_v;
    }
    String getDuree(){
        return duree;
    }
    String getTrain(){
        return train;
    }

}
