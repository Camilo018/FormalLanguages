package view;

import model.Production;
import utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends JFrame {

    private MainJPanel mainJPanel;

    public MainView(ActionListener actionListener) throws HeadlessException, InterruptedException {
        this.mainJPanelInstances(actionListener);
        this.mainJPanelFeatures();
        this.mainJPanelInternalContent();
        Thread.sleep(500);
        this.setVisible(true);
    }

    private void mainJPanelInstances(ActionListener actionListener) {
        this.mainJPanel = new MainJPanel(actionListener);
    }

    private void mainJPanelFeatures() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(Constants.TITLE_APP);
        this.setMinimumSize(new Dimension(Constants.MINIMUM_WIDTH, Constants.MINIMUM_HEIGHT));
        this.setIconImage(new ImageIcon(getClass().getResource(Constants.ICON_APP)).getImage());
        this.setFont(Constants.ralewayFont);
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void mainJPanelInternalContent() {
        this.add(this.mainJPanel, BorderLayout.CENTER);
    }

    public String getSymbolNotTermianl() {
        return mainJPanel.getSymbolNotTermianl();
    }

    public String getSymbolTerminal() {
        return mainJPanel.getSymbolTerminal();
    }

    public String getHeaderProduction() {
        return mainJPanel.getHeaderProduction();
    }

    public String getBodyProduction() {
        return mainJPanel.getBodyProduction();
    }

    public String getAxioma() {
        return mainJPanel.getAxioma();
    }

    public void setListSymbolsNotTerminalToAxioma(ArrayList<String> symbolsTerminal){
        mainJPanel.setListSymbolsNotTerminalToAxioma(symbolsTerminal);
    }

    public void addListSymbolsNotTerminal(ArrayList<String> nonTerminalSymbols) {
        mainJPanel.addListSymbolsNotTerminal(nonTerminalSymbols);
    }

    public void addListSymbolsTerminal(ArrayList<String> terminalSymbols) {
        mainJPanel.addListSymbolsTerminal(terminalSymbols);
    }

    public void addListProduction(ArrayList<Production> productions) {
        this.mainJPanel.addListProduction(productions);
    }

    public void addListAxioma(String axiomaticSymbol) {
        this.mainJPanel.addListAxioma(axiomaticSymbol);
    }

    public void acceptInfo(ActionListener actionListener) {
        this.mainJPanel.acceptInfo(actionListener);
    }

    public String validateWord() {
        return this.mainJPanel.validateWord();
    }

    public void showValidateWord(String derivationTreeText) {
        this.mainJPanel.showValidateWord(derivationTreeText);
    }
}
