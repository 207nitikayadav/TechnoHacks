import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    private JFrame frame;
    private JButton[] buttons;
    private int[] values;
    private int currentPlayer;

    public TicTacToe() {
        // Initialize the frame
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Initialize the buttons
        buttons = new JButton[9];
        values = new int[9];

        // Initialize the layout
        frame.getContentPane().setLayout(new GridLayout(3, 3));

        // Add the buttons to the frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].putClientProperty("index", i);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    int index = (int) button.getClientProperty("index");
                    if (values[index] == 0) {
                        values[index] = currentPlayer == 0? 1 : 2;
                        button.setText(currentPlayer == 0? "X" : "O");
                        currentPlayer = 1 - currentPlayer;
                    }
                }
            });
            frame.getContentPane().add(buttons[i]);
        }

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe();
            }
        });
    }
}