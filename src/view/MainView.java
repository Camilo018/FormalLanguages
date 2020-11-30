package view;

import utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        return "";
    }

    public String getSymbolTerminal() {
        return "";
    }

    public String getHeaderProduction() {
        return "";
    }

    public String getBodyProduction() {
        return "";
    }

    public String getAxioma() {
        return "";
    }
}
