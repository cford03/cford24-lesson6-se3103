package view.statePattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import controller.App;
import model.Marking;
import view.AppWindow;

public class GameStatePlaying implements GameState {

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateDone());
    }

    @Override
    public void updateWindow() {
        App.win.newGameButton.setEnabled(false);
        App.win.vsHumanButton.setEnabled(false);
        App.win.vsComputerButton.setEnabled(false);
        for (int i = 0; i < App.game.getBoard().length; i++) {
            App.win.markingButtons[i].setMark(App.game.getBoard()[i]);
            App.win.markingButtons[i].setEnabled(App.game.getBoard()[i] == Marking.U);
        }

        App.win.canvas.repaint();

    }

    @Override
    public void updateCanvas(Graphics2D g2) {
        g2.setFont(new Font("Courier New", Font.BOLD, 16));
        g2.setColor(Color.BLUE);
        g2.drawString("Turn: " + App.game.getTurn(), 50, 90);
    }

}
