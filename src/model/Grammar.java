package model;

import com.kitfox.svg.A;
import dataStructure.NTree;

import java.util.ArrayList;

public class Grammar {

    private ArrayList<String> symbolNotTerminal;
    private ArrayList<String> symbolTerminal;
    private ArrayList<Production> productionsArrayList;
    private String symbolAxioma;
    private NTree<String> nTree;

    public Grammar() {
        this.symbolNotTerminal = new ArrayList<>();
        this.symbolNotTerminal = new ArrayList<>();
        this.symbolAxioma = "";
        this.productionsArrayList = new ArrayList<>();
    }

    public Grammar(ArrayList<String> symbolNotTerminal, ArrayList<String> symbolTerminal, ArrayList<Production> productionsArrayList, String symbolAxioma) {
        this.symbolNotTerminal = symbolNotTerminal;
        this.symbolTerminal = symbolTerminal;
        this.productionsArrayList = productionsArrayList;
        this.symbolAxioma = symbolAxioma;
    }

   // public boolean validateAccepted(String input){
     //   return validateAccepted(input, changueText(symbolAxioma));
    //}

    //private boolean validateAccepted(String input, boolean changueText) {
    //}

   // private ArrayList<String> changueText(String symbolAxioma) {

    //}





}
