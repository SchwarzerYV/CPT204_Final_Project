package ataxx;


import java.util.concurrent.ArrayBlockingQueue;

import java.io.InputStream;
import java.awt.Menu;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import static ataxx.PieceState.*;
import static ataxx.Utils.*;

// Optional Task: The GUI for the Ataxx Game

class GUI implements View, CommandSource, Reporter {
    private Board board;
    private final ArrayBlockingQueue<String> _commandQueue =
    new ArrayBlockingQueue<>(5);
    // Complete the codes here
    /**
     * @param ataxx
     */
    GUI(String ataxx) {
        addMenuButton("Game->New", this::newGame);
        addMenuRadioButton("Game->Blocks->Set Blocks", "Blocks",
                           false, this::adjustBlockMode);
        addMenuRadioButton("Game->Blocks->Move Pieces", "Blocks",
                           true, this::adjustBlockMode);
        addMenuButton("Game->Quit", this::quit);
        addMenuButton("Options->Seed...", this::setSeed);
        addMenuRadioButton("Options->Players->Red AI", "Red",
                           false, (dummy) -> send("auto red"));
        addMenuRadioButton("Options->Players->Red Manual", "Red",
                           true, (dummy) -> send("manual red"));
        addMenuRadioButton("Options->Players->Blue AI", "Blue",
                           true, (dummy) -> send("auto blue"));
        addMenuRadioButton("Options->Players->Blue Manual", "Blue",
                           false, (dummy) -> send("manual blue"));
        addMenuButton("Info->Help", this::doHelp);
        _widget = new BoardWidget(_commandQueue);
        add(_widget,
            new LayoutSpec("height", "1",
                           "width", "REMAINDER",
                           "ileft", 5, "itop", 5, "iright", 5,
                           "ibottom", 5));
        addLabel("Red to move", "State",
                 new LayoutSpec("y", 1, "anchor", "west"));
        addButton("Pass", this::doPass, new LayoutSpec("y",
    }
    // Add some codes here


    



    // These methods could be modified
	
    @Override
    public void update(Board board) {
        Game game = new Game(this, this, this);
        game.runCommand("board_on");
    }

    @Override
    public String getCommand(String prompt) {
        try {
            return _commandQueue.take();
        } catch (InterruptedException excp) {
            throw new Error("unexpected interrupt");
        }
    }

    @Override
    public void announceWinner(PieceState a) {
//FIXME
if (board.getColorNums(PieceState.RED) == 0) {
    JOptionPane.showMessageDialog(null, "BLUE WINS! We have a winner String");
   
if (board.getColorNums(PieceState.BLUE) == 0) {
    JOptionPane.showMessageDialog(null, "RED WINS! We have a winner");
   
if (board.getConsecJumpNums() >= 25
|| (!board.couldMove(PieceState.BLUE) && !board.couldMove(PieceState.BLUE))) {
    if (board.getColorNums(PieceState.RED) > board.getColorNums(PieceState.BLUE)) {
        JOptionPane.showMessageDialog(null, "RED WINS! We have a winner");
    } else if (board.getColorNums(PieceState.RED) == board.getColorNums(PieceState.BLUE)) {
        JOptionPane.showMessageDialog(null, "TIE End game but no one wins");
    } else {
        JOptionPane.showMessageDialog(null, "BLUE WINS! We have a winner String");
    }
}
}
}
  }

    @Override
    public void announceMove(Move move, PieceState player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'announceMove'");
    }
  

    @Override
    public void message(String format, Object... args) {
        
        JOptionPane.showMessageDialog(null, String.format(format, args));
    }

    @Override
    public void error(String format, Object... args) {
        JOptionPane.showMessageDialog(null, "Simple Information Message");
        JOptionPane.showMessageDialog(null, String.format(format, args), "Error", JOptionPane.ERROR_MESSAGE);
        
    }

    public void setVisible(boolean b) {
		
    }

    public void pack() {
		
    }

}

