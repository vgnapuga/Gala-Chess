package ru.vsu.cs.cg.oop.galaChess.Window;

import ru.vsu.cs.cg.oop.galaChess.board.GameBoard;
import ru.vsu.cs.cg.oop.galaChess.engine.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FrameMain extends JFrame {
    
    private JPanel panelMain;
    private JPanel panelLeft;
    private JTable tableGame;
    private JPanel panelRight;
    private JTextArea textAreaTurnHistory;
    private JTextArea textAreaTurnsAndResults;
    private JPanel panelButton;
    private JButton buttonRestart;
    
    private GameBoard gameBoard;
    private GameEngine gameEngine;
    
    private BufferedImage backgroundImage;
    
    public FrameMain() {
        gameBoard = new GameBoard();
        gameEngine = new GameEngine(gameBoard);
        
        this.setTitle("Gala Chess");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    private void createUIComponents() {
        try {
            backgroundImage = ImageIO.read(new File("src/main/resources/GalaChessBoard.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка: Фон не найден");
        }
        
        tableGame = new JTable(10, 10) {
            @Override
            protected void paintComponent(Graphics g) {
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
                super.paintComponent(g);
            }
        };
        
        tableGame.setRowHeight(80);
        tableGame.setOpaque(false);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setOpaque(false);
        for (int i = 0; i < tableGame.getColumnCount(); i++) {
            tableGame.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    
}
