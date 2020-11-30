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
                this.acceptInfo();
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
            case VALIDATE_WORD:
                this.validate_word();
                break;

        }

    }

    private void validate_word() {
        grammar.validateWord(this.mainView.validateWord());
        mainView.showValidateWord(grammar.getDerivationTreeText());
        grammar.setDerivationTreeText("<html>");

    }

    private void acceptInfo() {
        this.mainView.acceptInfo(this);
    }

    private void addSymbolNotTermianl() {
        if (mainView.getContentSymbolsNotTerminal(this.grammar.getNonTerminalSymbols()) == true) {
            this.mainView.showAdvertenceDialog();
        } else {
            this.grammar.addNonTerminalSymbol(this.mainView.getSymbolNotTermianl());
            this.mainView.setListSymbolsNotTerminalToAxioma(this.grammar.getNonTerminalSymbols());
            this.mainView.addListSymbolsNotTerminal(this.grammar.getNonTerminalSymbols());
        }
    }

    private void addSymbolTerminal() {
        if (mainView.getContentSymbolsTerminal(this.grammar.getTerminalSymbols()) == true) {
            this.mainView.showAdvertenceDialog();
        } else {
            this.grammar.addTerminalSymbol(this.mainView.getSymbolTerminal());
            this.mainView.addListSymbolsTerminal(this.grammar.getTerminalSymbols());
        }
    }

    private void addProduction() {
        if (mainView.getContentProduction(this.grammar.getProductions(), this.grammar.getNonTerminalSymbols()) == true) {
            System.out.println(this.grammar.getNonTerminalSymbols().size());
            this.mainView.showAdvertenceDialog();
        } else {
            this.grammar.addProduction(Grammar.createProduction(this.mainView.getHeaderProduction(), this.mainView.getBodyProduction()));
            this.mainView.addListProduction(this.grammar.getProductions());
        }
    }

    private void addAxioma() {
        if (mainView.getContentAxioma() == true) {
            this.mainView.showAdvertenceDialog();
        } else {
            this.grammar.setAxiomaticSymbol(this.mainView.getAxioma());
            this.mainView.addListAxioma(this.grammar.getAxiomaticSymbol());
        }
    }
}
