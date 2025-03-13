package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.strategyPattern.VsComputerStrategy;
import model.strategyPattern.VsHumanStrategy;
import model.strategyPattern.VsSmartComputerStrategy;
import view.AppWindow;

public class StrategyButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        var actionCommand = e.getActionCommand();
        switch(actionCommand){
            case AppWindow.vsHumanAction:
                App.game.setStrategy(new VsHumanStrategy(App.game));
                break;
            case AppWindow.vsComputerAction:
                App.game.setStrategy(new VsComputerStrategy(App.game));
                break;
            case AppWindow.vsSmartComputerAction:
                App.game.setStrategy(new VsSmartComputerStrategy(App.game));
                break;
        }
    }
    
}
