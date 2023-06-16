package com.example.javareflectionexample;

import java.lang.reflect.*;
import java.util.Scanner;


public class HelloApplication {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {


        System.out.println("Wybierz klasę (Osoba, Auto). Zachowaj poprawność nazw wraz z wielkością znaków.:");
        Scanner scanner = new Scanner(System.in);
        String wybor = scanner.nextLine();


            Class<?> wyborClass = Class.forName("com.example.javareflectionexample."+wybor);

            Constructor<?>[] constructors = wyborClass.getConstructors();

            System.out.println("Konstruktory");
            for(Constructor<?> constructor: constructors){
                System.out.println(constructor);
            }


            Field[] fields = wyborClass.getDeclaredFields();
            System.out.println("Pola");
            for(Field field:fields) {
                System.out.println(field);
            }


            Method[] methods = wyborClass.getDeclaredMethods();
            System.out.println("Metody");
            for(Method method:methods){
                System.out.println(method);
            }

            //Tworzenie instancji wybranego obiektu


        Object object = constructors[0].newInstance("A","B");

            //Listowanie obiektu
        System.out.println("Listowanie obiektu");
        for(Field field:fields){
            field.setAccessible(true);
            System.out.println(field.getName() +" "+ field.get(object));
        }


    }
}