package view;

import enums.MainActivity;

import model.Production;
import rojeru_san.RSButtonRiple;
import rojeru_san.RSMTextFull;
import utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainJPanel extends JPanel {

    private Image resizeImage;
    private JPanel leftPanel;
    private JPanel rightPanelInformation;
    private RSMTextFull fieldSymbolsNotTerminal;
    private RSMTextFull fieldSymbolsTerminal;
    private JPanel showInfoPanel;
    private RSMTextFull headerProduction;
    private RSMTextFull bodyProduction;

    private JComboBox<String> listSymbolsTerminalToAxioma;

    private JComboBox<String> showSymbolsTerminals;
    private JComboBox<String> showSymbolsNotTerminals;
    private JComboBox<String> showAxioma;
    private JComboBox<String> showProductions;
    private RSMTextFull rsmTextFull;
    private JLabel derivateWordTree;


    public MainJPanel(ActionListener actionListener) {
        this.mainJPanelInstances(actionListener);
        this.mainJPanelFeatures();
        this.mainJPanelInternalContent();
    }

    private void mainJPanelInstances(ActionListener actionListener) {
        this.backGroundImage();
        this.derivateWordTree = new JLabel();
        this.rsmTextFull = Constants.rsmTextFull("Ingrese la palabra que desea validar");

        this.showSymbolsTerminals = Constants.comboBoxDefault();
        this.showSymbolsNotTerminals = Constants.comboBoxDefault();
        this.showAxioma = Constants.comboBoxDefault();
        this.showProductions = Constants.comboBoxDefault();

        this.showInfoPanel = new JPanel();
        this.fieldSymbolsNotTerminal = this.fieldSymbolsNotTerminal();
        this.fieldSymbolsTerminal = this.fieldSymbolsTerminal();
        this.headerProduction = this.headerProduction();
        this.bodyProduction = this.bodyProduction();
        this.listSymbolsTerminalToAxioma = this.listSymbolsTerminalToAxioma();
        this.leftPanel = this.leftPanelFeatures();
        this.rightPanelInformation = this.rightPanelInformationFeatures(actionListener);
    }


    private RSMTextFull headerProduction() {
        return Constants.rsmTextFull("Agregar una ->");
    }

    private RSMTextFull bodyProduction() {
        return Constants.rsmTextFull("producción");
    }


    private JComboBox<String> listSymbolsTerminalToAxioma() {
        JComboBox<String> listSymbolsTerminalToAxioma = new JComboBox<>();
        listSymbolsTerminalToAxioma.setFont(Constants.ralewayFont);
        return listSymbolsTerminalToAxioma;
    }

    private RSMTextFull fieldSymbolsTerminal() {
        return Constants.rsmTextFull("Agregar un simbolo terminal");
    }

    private RSMTextFull fieldSymbolsNotTerminal() {
        return Constants.rsmTextFull("Agregar un simbolo NO terminal");
    }

    private JPanel rightPanelInformationFeatures(ActionListener actionListener) {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3, 1));
        createPanelsAndAddContent(rightPanel, actionListener);
        return rightPanel;
    }

    private void createPanelsAndAddContent(JPanel rightPanel, ActionListener actionListener) {
        JPanel getInfoPanel = new JPanel();

        JPanel acceptInfoPanel = new JPanel();
        acceptInfoPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        showInfoPanel.setOpaque(false);
        getInfoPanel.setOpaque(false);
        this.getInfoPanelFeaturesAndContent(getInfoPanel, actionListener);
        this.showInfoPanelFeaturesAndContent(showInfoPanel);
        this.acceptInfoPanelFeaturesAndContent(acceptInfoPanel, actionListener);
        rightPanel.add(getInfoPanel);
        rightPanel.add(showInfoPanel);
        rightPanel.add(acceptInfoPanel);
    }

    private void acceptInfoPanelFeaturesAndContent(JPanel acceptInfoPanel, ActionListener actionListener) {
        acceptInfoPanel.setBackground(Color.decode("#34495e"));
        RSButtonRiple acceptInfo = Constants.btnRipleTwo("¡Aceptar!", MainActivity.ACCEPT_INFO.toString(), actionListener, "#2ecc71");
        acceptInfoPanel.setLayout(new GridLayout(2, 1));
        JLabel infoPersons = new JLabel();
        infoPersons.setFont(Constants.ralewayFont);
        infoPersons.setText(Constants.PERSONS_PROJECT);
        acceptInfoPanel.add(Constants.insidePanel(acceptInfo, 60, 150, 60, 150, "#000000", false));
        acceptInfoPanel.add(Constants.insidePanel(infoPersons, 10, 30, 10, 30, "#000000", false));
    }

    private void showInfoPanelFeaturesAndContent(JPanel showInfoPanel) {
        showInfoPanel.setLayout(new GridLayout(4, 1));
        showInfoPanel.add(Constants.insidePanel(showSymbolsNotTerminals, 10, 30, 10, 30, "#0000", false));
        showInfoPanel.add(Constants.insidePanel(showSymbolsTerminals, 10, 30, 10, 30, "#0000", false));
        showInfoPanel.add(Constants.insidePanel(showAxioma, 10, 30, 10, 30, "#0000", false));
        showInfoPanel.add(Constants.insidePanel(showProductions, 10, 30, 10, 30, "#0000", false));

        showInfoPanel.setBackground(Color.decode("#2c3e50"));
    }

    private void getInfoPanelFeaturesAndContent(JPanel getInfoPanel, ActionListener actionListener) {
        getInfoPanel.setLayout(new GridLayout(4, 1));
        getInfoPanel.setBackground(Color.decode("#34495e"));
        getInfoInternalsPanels(getInfoPanel, actionListener);
    }

    private void getInfoInternalsPanels(JPanel getInfoPanel, ActionListener actionListener) {
        JPanel symbolsNotTerminalGetInfo = this.symbolsNotTerminalGetInfo(actionListener);
        JPanel symbolsTerminalGetInfo = this.symbolsTerminalGetInfo(actionListener);
        JPanel symbolAxiomalGetInfo = this.symbolAxiomalGetInfo(actionListener);
        JPanel productionsGetInfo = this.productionsGetInfo(actionListener);
        this.setOpaquePanels(symbolsNotTerminalGetInfo, symbolsTerminalGetInfo, symbolAxiomalGetInfo, productionsGetInfo);
        getInfoPanel.add(symbolsNotTerminalGetInfo);
        getInfoPanel.add(symbolsTerminalGetInfo);
        getInfoPanel.add(symbolAxiomalGetInfo);
        getInfoPanel.add(productionsGetInfo);
    }

    private void setOpaquePanels(JPanel symbolsNotTerminalGetInfo, JPanel symbolsTerminalGetInfo, JPanel symbolAxiomalGetInfo, JPanel productionsGetInfo) {
        symbolsTerminalGetInfo.setOpaque(false);
        symbolAxiomalGetInfo.setOpaque(false);
        productionsGetInfo.setOpaque(false);
        symbolsNotTerminalGetInfo.setOpaque(false);
    }

    private JPanel symbolsNotTerminalGetInfo(ActionListener actionListener) {
        JPanel symbolsNotTerminalGetInfo = new JPanel(new GridLayout(1, 3));
        symbolsNotTerminalGetInfo.setOpaque(false);
        RSButtonRiple addSymbolNotTerminal = Constants.btnRiple("", MainActivity.ADD_SYMBOL_NOT_TERMINAL.toString(), actionListener, "#3498db", Constants.ICON_ADD);


        symbolsNotTerminalGetInfo.add(Constants.getSpace(0, 0, 0, 0));
        symbolsNotTerminalGetInfo.add(Constants.insidePanel(fieldSymbolsNotTerminal, 15, 10, 15, 10, "#000000", false));
        symbolsNotTerminalGetInfo.add(Constants.insidePanel(addSymbolNotTerminal, 15, 10, 15, 220, "#000000", false));
        return symbolsNotTerminalGetInfo;
    }

    private JPanel symbolsTerminalGetInfo(ActionListener actionListener) {
        JPanel symbolsTerminalGetInfo = new JPanel(new GridLayout(1, 3));
        symbolsTerminalGetInfo.setOpaque(false);

        RSButtonRiple addSymbolTerminal = Constants.btnRiple("", MainActivity.ADD_SYMBOL_TERMINAL.toString(), actionListener, "#3498db", Constants.ICON_ADD);

        symbolsTerminalGetInfo.add(Constants.getSpace(0, 0, 0, 0));
        symbolsTerminalGetInfo.add(Constants.insidePanel(fieldSymbolsTerminal, 15, 10, 15, 10, "#000000", false));
        symbolsTerminalGetInfo.add(Constants.insidePanel(addSymbolTerminal, 15, 10, 15, 220, "#000000", false));
        return symbolsTerminalGetInfo;
    }

    private JPanel symbolAxiomalGetInfo(ActionListener actionListener) {
        JPanel symbolAxiomalGetInfo = new JPanel(new GridLayout(1, 3));
        symbolAxiomalGetInfo.setOpaque(false);

        RSButtonRiple addSymbolAxioma = Constants.btnRiple("", MainActivity.ADD_AXIOMA.toString(), actionListener, "#3498db", Constants.ICON_ADD);

        symbolAxiomalGetInfo.add(Constants.getSpace(0, 0, 0, 0));
        symbolAxiomalGetInfo.add(Constants.insidePanel(listSymbolsTerminalToAxioma, 15, 10, 15, 10, "#000000", false));
        symbolAxiomalGetInfo.add(Constants.insidePanel(addSymbolAxioma, 15, 10, 15, 220, "#000000", false));
        return symbolAxiomalGetInfo;
    }


    private JPanel productionsGetInfo(ActionListener actionListener) {
        JPanel productionsGetInfo = new JPanel(new GridLayout(1, 3));
        productionsGetInfo.setOpaque(false);

        RSButtonRiple addProduction = Constants.btnRiple("", MainActivity.ADD_PRODUCTION.toString(), actionListener, "#00000", Constants.ICON_ADD);

        productionsGetInfo.add(Constants.insidePanel(headerProduction, 15, 10, 15, 10, "#000000", false));
        productionsGetInfo.add(Constants.insidePanel(bodyProduction, 15, 10, 15, 10, "#000000", false));
        productionsGetInfo.add(Constants.insidePanel(addProduction, 15, 10, 15, 220, "#000000", false));
        return productionsGetInfo;
    }


    //Aca se tiene el panel que muestra el arbol de derivación junto con
    //la gramatica
    private JPanel leftPanelFeatures() {
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new BorderLayout());

        return leftPanel;
    }

    private void mainJPanelFeatures() {
        this.setLayout(new GridLayout(1, 2));
    }


    private void mainJPanelInternalContent() {
        this.add(leftPanel);
        this.add(rightPanelInformation);
    }

    private ImageIcon backGroundImage() {
        ImageIcon backGroundImage = new ImageIcon(getClass().getResource(Constants.BACKGROUND_IMAGE));
        this.resizeImage = backGroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        return backGroundImage;
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.resizeImage, 0, 0, this);
    }


    public String getSymbolNotTermianl() {
        return fieldSymbolsNotTerminal.getText();
    }

    public void setListSymbolsNotTerminalToAxioma(ArrayList<String> symbolsTerminal) {
        listSymbolsTerminalToAxioma.removeAllItems();
        for (String symbol : symbolsTerminal) {
            listSymbolsTerminalToAxioma.addItem(symbol);
        }
        listSymbolsTerminalToAxioma.repaint();
        this.repaint();
    }


    public String getSymbolTerminal() {
        return fieldSymbolsTerminal.getText();
    }

    public String getHeaderProduction() {
        return headerProduction.getText();
    }

    public String getBodyProduction() {
        return bodyProduction.getText();
    }

    public String getAxioma() {
        return listSymbolsTerminalToAxioma.getSelectedItem().toString();
    }

    public void addListSymbolsNotTerminal(ArrayList<String> nonTerminalSymbols) {
        showSymbolsNotTerminals.setVisible(true);
        showSymbolsNotTerminals.removeAllItems();
        for (String symbol : nonTerminalSymbols) {
            showSymbolsNotTerminals.addItem(symbol);
        }
        showSymbolsNotTerminals.repaint();
        this.repaint();
    }

    public void addListSymbolsTerminal(ArrayList<String> terminalSymbols) {
        showSymbolsTerminals.setVisible(true);
        showSymbolsTerminals.removeAllItems();
        for (String symbol : terminalSymbols) {
            showSymbolsTerminals.addItem(symbol);
        }
        showSymbolsTerminals.repaint();
        this.repaint();
    }

    public void addListProduction(ArrayList<Production> productions) {
        showProductions.setVisible(true);
        showProductions.removeAllItems();
        for (Production symbol : productions) {
            showProductions.addItem(symbol.getNonTerminalSymbol() + " --> " + symbol.getProduction());
        }
        showProductions.repaint();
        this.repaint();
    }

    public void addListAxioma(String axiomaticSymbol) {
        showAxioma.setVisible(true);
        showAxioma.removeAllItems();
        showAxioma.addItem(axiomaticSymbol);
        listSymbolsTerminalToAxioma.setEnabled(false);
        this.repaint();
    }

    public void acceptInfo(ActionListener actionListener) {
        RSButtonRiple validateBtn = Constants.btnRipleTwo("Validar", MainActivity.VALIDATE_WORD.toString(), actionListener, "#2ecc71");
        JPanel validateWordPanel = new JPanel(new GridLayout(1, 2));
        validateWordPanel.setOpaque(false);
        validateWordPanel.add(Constants.insidePanel(rsmTextFull, 0, 50, 0, 50, "#0000", false));
        validateWordPanel.add(Constants.insidePanel(validateBtn, 0, 50, 0, 50, "#0000", false));
        leftPanel.add(Constants.insidePanel(validateWordPanel, 50, 50, 10, 50, "#0000", false), BorderLayout.PAGE_START);
        this.leftPanel.add(Constants.insidePanel(derivateWordTree, 50, 50, 10, 50, "#0000", false), BorderLayout.CENTER);
        this.leftPanel.repaint();
        this.repaint();
        this.revalidate();
    }

    public String validateWord() {
        return this.rsmTextFull.getText();
    }

    public void showValidateWord(String derivationTreeText) {
        this.derivateWordTree.setFont(Constants.ralewayFontLabel);
        this.derivateWordTree.setText(derivationTreeText);
        this.derivateWordTree.setHorizontalAlignment(JLabel.CENTER);
        this.derivateWordTree.setVerticalAlignment(JLabel.TOP);
        this.derivateWordTree.setHorizontalTextPosition(JLabel.CENTER);
        this.derivateWordTree.setVerticalTextPosition(JLabel.TOP);
        this.leftPanel.repaint();
        this.repaint();
        this.revalidate();
    }

    public boolean getContentSymbolsNotTerminal(ArrayList<String> listSymbolsNotTerminal) {
        if (this.fieldSymbolsNotTerminal.getText().length() == 0) {
            return true;
        } else if (this.fieldSymbolsNotTerminal.getText().length() > 0) {
            for (String item : listSymbolsNotTerminal) {
                if (item.equals(fieldSymbolsNotTerminal.getText())) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean getContentSymbolsTerminal(ArrayList<String> terminalSymbols) {
        if (this.fieldSymbolsTerminal.getText().length() == 0) {
            return true;
        } else if (this.fieldSymbolsTerminal.getText().length() > 0) {
            for (String item : terminalSymbols) {
                if (item.equals(fieldSymbolsTerminal.getText())) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean getContentProduction(ArrayList<Production> productions, ArrayList<String> nonTerminalSymbols) {
        if (this.headerProduction.getText().length() == 0 && this.bodyProduction.getText().length() == 0) {
            return true;
        } if (this.headerProduction.getText().length() > 0 && this.bodyProduction.getText().length() > 0 ) {
            for (Production item : productions) {
                if (item.getProduction().equals(bodyProduction.getText()) && item.getNonTerminalSymbol().equals(headerProduction.getText()) ) {
                    return true;
                }
            }
        } if(!nonTerminalSymbols.contains(headerProduction.getText().toString())){
            System.out.println(headerProduction.getText().toString());
            return  true;
        } else {
            return false;
        }
    }

    public boolean getContentAxioma() {
        if (listSymbolsTerminalToAxioma.getItemCount() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
