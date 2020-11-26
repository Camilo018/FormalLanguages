package test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TestGeneral {


    public static void main(String[] args) {
        String[] productionOne = {"S", "aA"};
        String[] productionTwo = {"A", "aA"};
        String[] productionThree = {"A", "bA"};
        String[] productionFour = {"A", "b"};



        String[] symbolNotTerminal = {"A", "S"};
        String[] symbolTerminal = {"a", "b"};
        String symbolAxioma = "S";
        int numberProductions = 4;
        ArrayList<String[]> listProductions = new ArrayList<>();

        listProductions.add(productionOne);
        listProductions.add(productionTwo);
        listProductions.add(productionThree);
        listProductions.add(productionFour);


        System.out.println("Los simbolos no terminales son: " + symbolNotTerminal[0] + ", " + symbolNotTerminal[1]);
        System.out.println("Los simbolos terminales son: " + symbolTerminal[0] + ", " + symbolTerminal[1]);
        System.out.println("El axioma es: " + symbolAxioma);
        System.out.println("El numero de producciones es " + numberProductions);

        int count = 0;
        for (String[] production: listProductions
             ) {
            System.out.println("La Produccion " + (count+1) + " es:  " + listProductions.get(count)[0] + " -> " + listProductions.get(count)[1]);
            count++;
        }

        String word = "aaab";





    }


}
