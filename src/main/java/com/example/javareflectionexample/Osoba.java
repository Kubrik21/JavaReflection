package com.example.javareflectionexample;

public class Osoba implements jezyk{
 private String imie;
 private String nazwisko;
 public int wiek;

 public Osoba(String imie, String nazwisko){
        this.imie=imie;
        this.nazwisko=nazwisko;
 }
 public Osoba(String imie, String nazwisko, int wiek){
     this.imie=imie;
     this.nazwisko=nazwisko;
     this.wiek=wiek;
 }

 public void ktoTy()
 {
     System.out.println("Wywołano metodę klasy Osoba");
     System.out.println(imie+ " " + nazwisko);
     System.out.println("Wiek: " + wiek);
 }


 public void mow(String param){
     System.out.println(param);
 }

}
