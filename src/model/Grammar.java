package model;

import dataStructure.NTree;
import dataStructure.NodeTree;

import java.util.ArrayList;
import java.util.Comparator;

public class Grammar {

    private ArrayList<String> nonTerminalSymbols;
    private ArrayList<String> terminalSymbols;
    private String axiomaticSymbol;
    private ArrayList<Production> productions;
    private NTree<String> derivationTree;
    private String derivationTreeText;

    public Grammar() {
        this.nonTerminalSymbols = new ArrayList<>();
        this.terminalSymbols = new ArrayList<>();
        this.axiomaticSymbol = "";
        this.productions = new ArrayList<>();
        this.derivationTreeText = "<html>";
    }

    public boolean validateWord(String input) {
        return recursiveValidateWord(input, changeText(axiomaticSymbol));
    }

    /*
    Recorre recursivamente el arbol para buscar si una palabra existe en el lenguaje
     */
    public boolean recursiveValidateWord(String input, ArrayList<String> list) {
        boolean flag = false;
        boolean isAccept = false;

        for (String string2 : changeText(axiomaticSymbol)) {
            derivationTree.addSon(axiomaticSymbol, string2);
        }
        while (!flag) {
            ArrayList<String> aux = new ArrayList<>();
            for (String string : list) {
                if (isTerminal(string)) {
                    if (string.compareTo(input) == 0) {
                        isAccept = true;
                        flag = true;
                        break;
                    }
                } else {
                    if (countVar(string) <= input.length()) {
                        for (String string2 : changeText(string)) {
                            derivationTree.addSon(string, string2);
                            aux.add(string2);
                        }
                    } else {
                        flag = true;
                    }

                }
            }
            list = aux;
        }
        if (isAccept)
            treeNArio(input);
        else
            derivationTreeText = "No pertenece al lenguaje (" + input + ")";

        return isAccept;
    }

    public int countVar(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (terminalSymbols.contains(text.charAt(i) + "")) {
                count++;
            }
        }
        return count;
    }

    public void showTree(NodeTree<String> root) {
        if (root.getInfo() == axiomaticSymbol) {
            derivationTreeText += root.getInfo() + "<br> &darr; " + "<br>";
        }
        for (int i = 0; i < root.getSons().size(); i++) {
            derivationTreeText += root.getSons().get(i).getInfo() + "<br> &darr;" + "<br>";
            showTree(root.getSons().get(i));
        }
    }

    public boolean isTerminal(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (nonTerminalSymbols.contains(text.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }

    public NTree<String> treeNArio(String input) {
        NTree<String> treeNArio = new NTree<>(input, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        NodeTree<String> root = derivationTree.search(input);
        while (root != derivationTree.getRoot()) {
            treeNArio.addSon(root.getInfo(), root.getFather().getInfo());
            root = root.getFather();
        }

        NTree<String> auxNArio = new NTree<>(axiomaticSymbol, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        NodeTree<String> rootAux = treeNArio.search(axiomaticSymbol);
        while (rootAux != treeNArio.getRoot()) {
            auxNArio.addSon(rootAux.getInfo(), rootAux.getFather().getInfo());
            rootAux = rootAux.getFather();
        }

        showTree(auxNArio.getRoot());
        derivationTreeText += "Es aceptado </html>";
        return auxNArio;
    }

    public ArrayList<String> changeText(String text) {
        ArrayList<String> list = new ArrayList<>();
        for (Production production : productions) {
            if (isIn(production.getNonTerminalSymbol(), text)) {
                list.add(replaceAxiomatic(text, production.getNonTerminalSymbol(), production.getProduction()));
            }
        }
        return list;
    }

    public String replaceAxiomatic(String text, String axiomatic, String replace) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == axiomatic.charAt(0)) {
                result += replace;
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }

    public boolean isIn(String axiomatic, String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == axiomatic.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public void addNonTerminalSymbol(String symbol){
        nonTerminalSymbols.add(symbol);
    }

    public void addTerminalSymbol(String symbol){
        terminalSymbols.add(symbol);
    }

    public void addProduction(Production production){
        productions.add(production);
    }

    public ArrayList<String> getTerminalSymbols() {
        return terminalSymbols;
    }

    public String getDerivationTreeText() {
        return derivationTreeText;
    }

    public void addTerminal(String terminal){
        terminalSymbols.add(terminal);
    }

    public void setAxiomaticSymbol(String axiomaticSymbol) {
        this.axiomaticSymbol = axiomaticSymbol;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public ArrayList<String> getNonTerminalSymbols() {
        return nonTerminalSymbols;
    }


}