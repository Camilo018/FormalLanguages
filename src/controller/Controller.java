package controller;

import enums.MainActivity;
import model.Grammar;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Grammar grammar;
    private MainView mainView;

    public Controller() {
        this.grammar = new Grammar();
        this.mainView = new MainView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (MainActivity.valueOf(e.getActionCommand())){

        }

    }
}
