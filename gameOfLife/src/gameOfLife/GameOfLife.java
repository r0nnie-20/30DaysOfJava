package gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {
    private int width;
    private int height;
    private boolean[][] grid;
    private boolean[][] nextGeneration;
    private CellPanel[][] cellPanels;
    private Timer timer;

    private static final int CELL_SIZE = 10;
    private static final int DELAY = 100; // Milliseconds

    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[width][height];
        this.nextGeneration = new boolean[width][height];
        this.cellPanels = new CellPanel[width][height];

        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(height, width));

        // Create cell panels
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CellPanel cellPanel = new CellPanel(x, y);
                cellPanels[x][y] = cellPanel;
                add(cellPanel);
            }
        }

        // Create timer for automatic generation updates
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextGeneration();
                repaintGrid();
            }
        });
    }

    public void setCell(int x, int y, boolean alive) {
        grid[x][y] = alive;
        cellPanels[x][y].repaint();
    }

    public boolean isCellAlive(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;
        }
        return grid[x][y];
    }

    public void nextGeneration() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int neighbors = countLivingNeighbors(x, y);
                if (grid[x][y]) {
                    nextGeneration[x][y] = (neighbors == 2 || neighbors == 3);
                } else {
                    nextGeneration[x][y] = (neighbors == 3);
                }
            }
        }
        // Swap grids
        boolean[][] temp = grid;
        grid = nextGeneration;
        nextGeneration = temp;
    }

    private int countLivingNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (isCellAlive(x + i, y + j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void start() {
        pack();
        setLocationRelativeTo(null); // Center window on screen
        setVisible(true);
        timer.start();
    }

    private void repaintGrid() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                cellPanels[x][y].repaint();
            }
        }
    }

    private class CellPanel extends JPanel {
        private int x;
        private int y;

        public CellPanel(int x, int y) {
            this.x = x;
            this.y = y;
            setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (grid[x][y]) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, CELL_SIZE, CELL_SIZE);
            } else {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, CELL_SIZE, CELL_SIZE);
            }

            g.setColor(Color.BLACK);
            g.drawRect(0, 0, CELL_SIZE, CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create a game with a 10x10 grid
                GameOfLife game = new GameOfLife(20, 20);
                game.getContentPane().setBackground(Color.BLACK);

                // Set initial live cells for a Blinker pattern
                

                
                game.setCell(1, 3, true);
                game.setCell(2, 4, true);
                game.setCell(3, 2, true);
                game.setCell(3, 3, true);
                game.setCell(3, 4, true);
                
                
                game.start();
            }
        });
    }
}