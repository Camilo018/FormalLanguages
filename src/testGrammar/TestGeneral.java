package testGrammar;


import java.util.ArrayList;

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

        for(String item: symbolNotTerminal) {
            if (symbolAxioma.equals(item)){
                for (String[] productionInitial: listProductions){
                    if (productionInitial[0].equals(item)){
                        char[] characters = productionInitial[1].toCharArray();
                        String symbolNotTerminalConc = "";
                        for (char testChar: characters){
                            System.out.println("Los caracterese sde la producción son: " + testChar);
                            for (String[] production: listProductions) {

                                if (String.valueOf(testChar).equals(production)) {
                                    System.out.println("El simbolo es:" + testChar);
                                } else if (String.valueOf(testChar).equals(symbolTerminal)){
                                    symbolNotTerminalConc += testChar;
                                }
                            }
                        }
                        System.out.println("El no terminal es: " + symbolNotTerminalConc);
                        System.out.println("Aca llega lo siguiente: " + productionInitial[0] + " y la produccion es: " + productionInitial[1]);
                    }
                }
            }
        }





    }


}
