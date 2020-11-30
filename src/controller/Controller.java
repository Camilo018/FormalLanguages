package controller;

import enums.MainActivity;
import model.Grammar;
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
    }

    private void addSymbolTerminal() {
        this.grammar.addTerminalSymbol(this.mainView.getSymbolTerminal());
    }

    private void addProduction() {
        this.grammar.addProduction(Grammar.createProduction(this.mainView.getHeaderProduction(), this.mainView.getBodyProduction()));
    }

    private void addAxioma() {
        this.grammar.setAxiomaticSymbol(this.mainView.getAxioma());
    }
}
