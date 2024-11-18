package ru.vsu.cs.cg.oop.galaChess.Window;

import javax.swing.*;

public class FrameMain extends JFrame {
    
    private JTable tableGame;
    private JTextArea textAreaTurnHistory;
    private JButton buttonRestart;
    private JPanel panelMain;
    private JPanel panelRight;
    private JPanel panelButton;
    private JTextArea textAreaTurnsAndResults;
    
    public FrameMain() {
        this.setTitle("Gala Chess");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
}
