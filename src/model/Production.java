package model;

public class Production {

    private String nonTerminalSymbol;
    private String production;

    public Production(String nonTerminalSymbol, String production) {
        this.nonTerminalSymbol = nonTerminalSymbol;
        this.production = production;
    }

    public String getNonTerminalSymbol() {
        return nonTerminalSymbol;
    }

    public String getProduction() {
        return production;
    }

}
