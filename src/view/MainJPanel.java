package view;

import com.kitfox.svg.A;
import enums.MainActivity;

import rojeru_san.RSButtonRiple;
import rojeru_san.RSMTextFull;
import utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainJPanel extends JPanel {

    private Image resizeImage;
    private JPanel leftPanel;
    private JPanel rightPanelInformation;
    private RSMTextFull fieldSymbolsNotTerminal;
    private RSMTextFull fieldSymbolsTerminal;
    private RSMTextFull headerProduction;
    private RSMTextFull bodyProduction;

    private JComboBox<String> listSymbolsTerminalToAxioma;


    public MainJPanel(ActionListener actionListener) {
        this.mainJPanelInstances(actionListener);
        this.mainJPanelFeatures();
        this.mainJPanelInternalContent();
    }

    private void mainJPanelInstances(ActionListener actionListener) {
        this.backGroundImage();
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
        listSymbolsTerminalToAxioma.addItem("Hola");
        listSymbolsTerminalToAxioma.addItem("Esto ES");
        listSymbolsTerminalToAxioma.addItem("Una prueba");

        return listSymbolsTerminalToAxioma;
    }

    private RSMTextFull fieldSymbolsTerminal() {
        return Constants.rsmTextFull("Agregue un simbolo terminal");
    }

    private RSMTextFull fieldSymbolsNotTerminal() {
        return Constants.rsmTextFull("Agregue un simbolo NO terminal");
    }

    private JPanel rightPanelInformationFeatures(ActionListener actionListener) {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3,1));
        createPanelsAndAddContent(rightPanel, actionListener);
        return rightPanel;
    }

    private void createPanelsAndAddContent(JPanel rightPanel, ActionListener actionListener) {
        JPanel getInfoPanel = new JPanel();
        JPanel showInfoPanel = new JPanel();
        JPanel acceptInfoPanel = new JPanel();
        this.getInfoPanelFeaturesAndContent(getInfoPanel, actionListener);
        this.showInfoPanelFeaturesAndContent(showInfoPanel);
        this.acceptInfoPanelFeaturesAndContent(acceptInfoPanel, actionListener);
        rightPanel.add(getInfoPanel);
        rightPanel.add(showInfoPanel);
        rightPanel.add(acceptInfoPanel);
    }

    private void acceptInfoPanelFeaturesAndContent(JPanel acceptInfoPanel, ActionListener actionListener) {
        acceptInfoPanel.setBackground(Color.decode("#34495e"));
        RSButtonRiple acceptInfo = Constants.btnRiple("¡Aceptar!", MainActivity.ACCEPT_INFO.toString(), actionListener, "#2ecc71", "" );
        acceptInfoPanel.setLayout(new GridLayout(2,1));
        JLabel infoPersons = new JLabel();
        infoPersons.setFont(Constants.ralewayFont);
        infoPersons.setText(Constants.PERSONS_PROJECT);
        acceptInfoPanel.add(Constants.insidePanel(acceptInfo, 60, 150, 60, 150, "#000000", false));
        acceptInfoPanel.add(Constants.insidePanel(infoPersons, 10, 30, 10, 30, "#000000", false));
    }

    private void showInfoPanelFeaturesAndContent(JPanel showInfoPanel) {
        showInfoPanel.setBackground(Color.decode("#2c3e50"));
    }

    private void getInfoPanelFeaturesAndContent(JPanel getInfoPanel, ActionListener actionListener) {
        getInfoPanel.setLayout(new GridLayout(4,1));
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
        symbolsTerminalGetInfo.setBackground(Color.decode("#34495e"));
        symbolAxiomalGetInfo.setBackground(Color.decode("#34495e"));
        productionsGetInfo.setBackground(Color.decode("#34495e"));
        symbolsNotTerminalGetInfo.setBackground(Color.decode("#34495e"));
    }

    private JPanel symbolsNotTerminalGetInfo(ActionListener actionListener) {
        JPanel symbolsNotTerminalGetInfo = new JPanel(new GridLayout(1,3));
        RSButtonRiple addSymbolNotTerminal = Constants.btnRiple("", MainActivity.ADD_SYMBOL_NOT_TERMINAL.toString(), actionListener, "#3498db", Constants.ICON_ADD);
        symbolsNotTerminalGetInfo.add(Constants.getSpace(0,0,0,0));
        symbolsNotTerminalGetInfo.add(Constants.insidePanel(fieldSymbolsNotTerminal, 8,13,8,10,"#000000", false));
        symbolsNotTerminalGetInfo.add(Constants.insidePanel(addSymbolNotTerminal, 8,70,8,70,"#000000", false));
        return symbolsNotTerminalGetInfo;
    }

    private JPanel symbolsTerminalGetInfo(ActionListener actionListener) {
        JPanel symbolsTerminalGetInfo = new JPanel(new GridLayout(1,3));
        RSButtonRiple addSymbolTerminal = Constants.btnRiple("", MainActivity.ADD_SIMBOL_TERMINAL.toString(), actionListener, "#3498db", Constants.ICON_ADD);

        symbolsTerminalGetInfo.add(Constants.getSpace(0,0,0,0));
        symbolsTerminalGetInfo.add(Constants.insidePanel(fieldSymbolsTerminal, 8,10,8,10,"#000000", false));
        symbolsTerminalGetInfo.add(Constants.insidePanel(addSymbolTerminal, 8,70,8,70,"#000000", false));
        return symbolsTerminalGetInfo;
    }

    private JPanel symbolAxiomalGetInfo(ActionListener actionListener) {
        JPanel symbolAxiomalGetInfo = new JPanel(new GridLayout(1,3));
        RSButtonRiple addSymbolAxioma = Constants.btnRiple("", MainActivity.ADD_AXIOMA.toString(), actionListener, "#3498db", Constants.ICON_ADD);

        symbolAxiomalGetInfo.add(Constants.getSpace(0,0,0,0));
        symbolAxiomalGetInfo.add(Constants.insidePanel(listSymbolsTerminalToAxioma, 8,10,8,10,"#000000", false));
        symbolAxiomalGetInfo.add(Constants.insidePanel(addSymbolAxioma, 8,70,8,70,"#000000", false));
        return symbolAxiomalGetInfo;
    }


    private JPanel productionsGetInfo(ActionListener actionListener) {
        JPanel productionsGetInfo = new JPanel(new GridLayout(1, 3));
        RSButtonRiple addProduction = Constants.btnRiple("", MainActivity.ADD_PRODUCTION.toString(), actionListener, "#3498db", Constants.ICON_ADD);

        productionsGetInfo.add(Constants.insidePanel(headerProduction, 8,10,8,10,"#000000", false));
        productionsGetInfo.add(Constants.insidePanel(bodyProduction, 8,10,8,10,"#000000", false));
        productionsGetInfo.add(Constants.insidePanel(addProduction, 8,70,8,70,"#000000", false));
        return productionsGetInfo;
    }


    //Aca se tiene el panel que muestra el arbol de derivación junto con
    //la gramatica
    private JPanel leftPanelFeatures() {
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
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


}
