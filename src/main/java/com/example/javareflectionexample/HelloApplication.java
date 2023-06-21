package com.example.javareflectionexample;

import java.lang.reflect.*;
import java.util.Scanner;


public class HelloApplication {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {


        System.out.println("Wybierz klasę (Osoba, Auto). Zachowaj poprawność nazw wraz z wielkością znaków.:");
        Scanner scanner = new Scanner(System.in);
        String wybor = scanner.nextLine();


        Class<?> wyborClass = Class.forName("com.example.javareflectionexample."+wybor);

            //Nazwa klasy
        System.out.println(ANSI_RED+"Nazwa wybranej klasy: "+ANSI_RESET+wyborClass.getSimpleName());

        int classMods = wyborClass.getModifiers();
        System.out.println(ANSI_RED+"Wybrana klasa ma modyfikator: "+ANSI_RESET+ Modifier.toString(classMods));

            //Nadklasa

        Class<?> wyborSuperClass = wyborClass.getSuperclass();
        System.out.println(ANSI_RED+"Nadklasa wybranej klasy: " +ANSI_RESET+wyborSuperClass.getSimpleName());

            //Interfejsy

        Class<?>[] classInterfaces = wyborClass.getInterfaces();
            if (classInterfaces.length == 0) {
                System.out.println(ANSI_RED+"Brak interfaceów"+ANSI_RESET);
            } else {
                System.out.println(ANSI_RED+"Dostępne interface'y: "+ANSI_RESET);
            }
        for(Class<?> interfaces : classInterfaces)
        {
            System.out.println(interfaces.getSimpleName() +" - "+ Modifier.toString(interfaces.getModifiers()));
        }



        Constructor<?>[] constructors = wyborClass.getConstructors();

        System.out.println(ANSI_RED+"Konstruktory:"+ANSI_RESET);
        for(Constructor<?> constructor: constructors){
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Parameter[] parameters = constructor.getParameters();

            System.out.println("\n" + Modifier.toString(constructor.getModifiers())+" - "+constructor.getName()+ANSI_RED+"\nParametry konstruktora:"+ANSI_RESET);

            for (int i = 0; i < parameters.length; i++) {
                System.out.println(parameterTypes[i].getName()+" - "+parameters[i].getName());
            }
            }


        Field[] fields = wyborClass.getDeclaredFields();
        System.out.println(ANSI_RED+"Pola"+ANSI_RESET);
        for(Field field:fields) {
            System.out.println(field);
            }


        Method[] methods = wyborClass.getDeclaredMethods();
        System.out.println(ANSI_RED+"Metody"+ANSI_RESET);
        for(Method method:methods){
            System.out.println(method);
            }

            //Tworzenie instancji wybranego obiektu


        Object object = constructors[0].newInstance("A","B");

            //Listowanie obiektu
        System.out.println(ANSI_RED+"Listowanie obiektu"+ANSI_RESET);
        for(Field field:fields){
            field.setAccessible(true);
            System.out.println(field.getName() +" "+ field.get(object));
        }

    }
}