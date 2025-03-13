package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class NewGameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        App.game.reset();
        App.win.goNextState();
        App.win.updateWindow();
    }
    
}
