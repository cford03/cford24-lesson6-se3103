package view;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.ButtonListener;
import controller.NewGameButtonListener;
import controller.StrategyButtonListener;

import model.PlayStrategy;

import view.statePattern.GameState;
import view.statePattern.GameStateInit;

public class AppWindow extends JFrame {

    public static final String vsHumanAction = "vs. Human";
    public static final String vsComputerAction = "vs. Computer";

    public AppCanvas canvas = new AppCanvas();
    public BoardButton[] markingButtons = new BoardButton[9];
    public JButton newGameButton = new JButton("New Game");
    public JRadioButton vsHumanButton;
    public JRadioButton vsComputerButton;

    private  GameState state = new GameStateInit();




    public void init(){
        var cp = getContentPane();
        cp.add(canvas, BorderLayout.NORTH);

        ButtonListener buttonListener = new ButtonListener();
        for(int i = 0; i< markingButtons.length; i++){
            markingButtons[i] = new BoardButton(i);
            markingButtons[i].addActionListener(buttonListener);

        }

        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setLayout(new GridLayout(3,3));
        for(var cell: markingButtons){
            gameBoardPanel.add(cell);
        }
        cp.add(gameBoardPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        cp.add(southPanel, BorderLayout.SOUTH);

        JPanel radioPanel = new JPanel();
        radioPanel.setBorder(new TitledBorder("Play strategy"));
        vsHumanButton = new JRadioButton(vsHumanAction, App.game.getStrategy() == PlayStrategy.VsHuman);
        vsComputerButton = new JRadioButton(vsComputerAction, App.game.getStrategy() == PlayStrategy.VsComputer);
        radioPanel.add(vsHumanButton);
        radioPanel.add(vsComputerButton);
        StrategyButtonListener strategyListener = new StrategyButtonListener();
        vsHumanButton.addActionListener(strategyListener);
        vsComputerButton.addActionListener(strategyListener);
        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(vsHumanButton);
        strategyGroup.add(vsComputerButton);
        southPanel.add(radioPanel);


        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder("Action"));
        actionPanel.add(newGameButton);
        newGameButton.addActionListener(new NewGameButtonListener());
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        actionPanel.add(exitButton);
        southPanel.add(actionPanel);



        updateWindow();
    }

    public void goNextState(){
        state.goNext(this);
    }

    public GameState getGameState(){

        return state;
    }

    public void setGameState(GameState state){
        this.state = state;
    }

    public void updateWindow(){
        state.updateWindow();
        canvas.repaint();
    }
}
