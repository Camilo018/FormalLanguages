package controller;

import enums.MainActivity;
import model.Grammar;
import model.Production;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Grammar grammar;
    private MainView mainView;

    public Controller() throws InterruptedException {
        this.grammar = new Grammar();
        this.mainView = new MainView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (MainActivity.valueOf(e.getActionCommand())) {
            case ADD_AXIOMA:
                this.addAxioma();
                break;

            case ACCEPT_INFO:

                break;

            case ADD_PRODUCTION:
                this.addProduction();
                break;
            case ADD_SYMBOL_TERMINAL:
                this.addSymbolTerminal();
                break;
            case ADD_SYMBOL_NOT_TERMINAL:
                this.addSymbolNotTermianl();
                break;

        }

    }

    private void addSymbolNotTermianl() {
        this.grammar.addNonTerminalSymbol(this.mainView.getSymbolNotTermianl());
        this.mainView.setListSymbolsNotTerminalToAxioma(this.grammar.getNonTerminalSymbols());
        this.mainView.addListSymbolsNotTerminal(this.grammar.getNonTerminalSymbols());
    }

    private void addSymbolTerminal() {
        this.grammar.addTerminalSymbol(this.mainView.getSymbolTerminal());
        for (String a: grammar.getTerminalSymbols()) {
            System.out.println(a);
        }
        this.mainView.addListSymbolsTerminal(this.grammar.getTerminalSymbols());

    }

    private void addProduction() {
        this.grammar.addProduction(Grammar.createProduction(this.mainView.getHeaderProduction(), this.mainView.getBodyProduction()));
        for (Production a: grammar.getProductions()) {
            System.out.println(a.getNonTerminalSymbol() + "----" + a.getProduction());
        }
        this.mainView.addListProduction(this.grammar.getProductions());

    }

    private void addAxioma() {
        System.out.println("´HOLA " +this.mainView.getAxioma());
        this.grammar.setAxiomaticSymbol(this.mainView.getAxioma());
        System.out.println(this.grammar.getAxiomaticSymbol());
        this.mainView.addListAxioma(this.grammar.getAxiomaticSymbol());

    }
}
