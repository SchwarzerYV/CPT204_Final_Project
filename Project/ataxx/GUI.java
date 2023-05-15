package ataxx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Optional Task: The GUI for the Ataxx Game

class GUI implements View, CommandSource, Reporter {

    // Complete the codes here

    private JFrame frame;
    private JPanel boardPanel;
    private JLabel messageLabel;
    private Board board;

    GUI(String ataxx) {
        frame = new JFrame(ataxx);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(7, 7));
        createBoardButtons();
        frame.add(boardPanel, BorderLayout.CENTER);

        messageLabel = new JLabel("Welcome to Ataxx!");
        frame.add(messageLabel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    // Add some codes here
    private void createBoardButtons() {
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                JButton button = new JButton();
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle button click event
                    }
                });
                boardPanel.add(button);
            }
        }
    }


    // These methods could be modified
	
    @Override
    public void update(Board board) {
        this.board = board;
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                JButton button = (JButton) boardPanel.getComponent(row * 7 + col);
                PieceState piece = board.get(row, col);
                button.setText(piece.toString());
            }
        }
    }

    @Override
    public String getCommand(String prompt) {
        return null;
    }

    @Override
    public void announceWinner(PieceState state) {
        String winner = (state == PieceState.EMPTY) ? "It's a tie!" : state + " wins!";
        messageLabel.setText(winner);
    }

    @Override
    public void announceMove(Move move, PieceState player) {
        messageLabel.setText(player + " moves: " + move);
    }

    @Override
    public void message(String format, Object... args) {
        String message = String.format(format, args);
        messageLabel.setText(message);
    }

    @Override
    public void error(String format, Object... args) {
        String errorMessage = String.format(format, args);
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public void pack() {
        frame.pack();
    }
	
}
