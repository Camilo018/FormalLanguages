package utilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import rojeru_san.RSButtonRiple;
import rojeru_san.RSMTextFull;

public class Constants {
    public static final String TITLE_APP = "Lenguajes Formales";
    public static final String ICON_APP = "/images/icon.png";
    public static final int MINIMUM_WIDTH = 720;
    public static final int MINIMUM_HEIGHT = 480;

    public static final String ICON_ADD = "/images/addIcon.png";

    public static final String BACKGROUND_IMAGE = "/images/background.jpg";
    public static final String PERSONS_PROJECT = "<html><body align=\"justify\"> Este proyecto es presentado por: <br><br>" + " - Cristian Camilo Lopez Niño <br>" + " - Juan Camilo Hurtado Baez<br>" +
            " - Brayan Steven Pineda Pachon </body></html>";
    public static Font ralewayFont = new Font("Raleway", Font.PLAIN, 18);


    public static JLabel getSpace(int top, int left, int bottom, int right) {
        JLabel getSpace = new JLabel();
        getSpace.setBorder(new EmptyBorder(top, left, bottom, right));
        return getSpace;
    }

    public static JPanel insidePanel(Component comp, int top, int left, int bottom, int right, String color,
                                     boolean opaque) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode(color));
        panel.setOpaque(opaque);
        insidePanelContent(panel, comp, top, left, bottom, right);
        return panel;
    }

    private static void insidePanelContent(JPanel panel, Component comp, int top, int left, int bottom, int right) {
        panel.add(getSpace(top, 0, 0, 0), BorderLayout.PAGE_START);
        panel.add(getSpace(0, left, 0, 0), BorderLayout.LINE_START);
        panel.add(comp, BorderLayout.CENTER);
        panel.add(getSpace(0, 0, bottom, 0), BorderLayout.PAGE_END);
        panel.add(getSpace(0, 0, 0, right), BorderLayout.LINE_END);
    }

    public static RSButtonRiple btnRiple(String texto, String command, ActionListener actionListener, String color, String urlIcon) {
        RSButtonRiple btnRiple = new RSButtonRiple();
        btnRiple.setText(texto);


        btnRiple.setActionCommand(command);
        btnRiple.addActionListener(actionListener);
        btnRipleFeatures(btnRiple, color);
        btnRiple.setIcon(new ImageIcon(Constants.class.getResource(urlIcon)));
        btnRiple.setBackground(new Color(255,255,255,0));
        return btnRiple;
    }

    public static RSButtonRiple btnRipleTwo(String texto, String command, ActionListener actionListener, String color) {
        RSButtonRiple btnRiple = new RSButtonRiple();
        btnRiple.setText(texto);


        btnRiple.setActionCommand(command);
        btnRiple.addActionListener(actionListener);
        btnRipleFeatures(btnRiple, color);
        return btnRiple;
    }

    private static void btnRipleFeatures(RSButtonRiple rsButtonRiple, String color) {
        rsButtonRiple.setFocusable(false);
        rsButtonRiple.setColorHover(Color.decode("#27ae60"));
        rsButtonRiple.setBackground(Color.decode(color));
        rsButtonRiple.setFont(fontBtn(16));
        rsButtonRiple.setBorderPainted(false);
    }

    public static Font fontBtn(int size) {
        Font ralewaye = new Font("Raleway", Font.PLAIN, size);
        return ralewaye;
    }

    public static final Font bold_italic = new Font("Lucida Sans Typewriter", Font.BOLD + Font.ITALIC, 14);

    public static RSMTextFull rsmTextFull(String placeHolder) {
        RSMTextFull rsmTextFull = new RSMTextFull();
        rsmTextFull.setForeground(Color.white);
        rsmTextFull.setModoMaterial(true);
        rsmTextFull.setPlaceholder(placeHolder);
        rsmTextFull.setSelectedTextColor(Color.white);
        rsmTextFull.setBordeColorFocus(Color.decode("#9b59b6"));
        rsmTextFull.setBordeColorNoFocus(Color.decode("#fafafa"));
        rsmTextFull.setFont(new Font("Raleway", Font.PLAIN, 16));
        rsmTextFull.setBackground(Color.decode("#34495e"));
        return rsmTextFull;
    }
}
