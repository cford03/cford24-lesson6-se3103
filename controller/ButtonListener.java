package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.TicTacToeGame;
import view.BoardButton;

public class ButtonListener implements ActionListener{
    


    @Override
    public void actionPerformed(ActionEvent e) {
        TicTacToeGame game = App.game;
        BoardButton button = (BoardButton) e.getSource();
        
        game.play(button.getPos());
        if(game.getWinner() != null){
            App.win.goNextState();
            System.out.println("Game Over: " + game.getWinner());
        }else{
            game.changeTurns();
        }
        App.win.updateWindow();
    }
}
