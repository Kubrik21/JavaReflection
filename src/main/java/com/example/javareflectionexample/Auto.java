package com.example.javareflectionexample;

public class Auto {
    private String marka;
    private String model;
    private String kolor;


    public Auto(String marka, String model){
        this.marka=marka;
        this.model=model;
    }
    public Auto(String marka, String model, String kolor){
        this.marka=marka;
        this.model=model;
        this.kolor=kolor;
    }

    public void prezentacjaAuta(){
        System.out.println("Wywołano metodę klasy Auto");
        System.out.println(marka+" "+model);
        System.out.println("Kolor: "+kolor);
    }
    public void setKolor(String kolor){
        this.kolor=kolor;
    }

    public String getKolor(){
        return kolor;
    }



}
