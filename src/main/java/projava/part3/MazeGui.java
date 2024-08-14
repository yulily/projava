package projava.part3;

import javax.swing.*;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Component;
import java.util.Objects;

public class MazeGui {
    private static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return this.x;
        }

        public int y() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void up() {
            this.y -= 1;
        }

        public void down() {
            this.y += 1;
        }

        public void left() {
            this.x -= 1;
        }

        public void right() {
            this.x += 1;
        }
    }
    private static final Position GOAL = new Position(10, 10);
    private static JLabel informationLabel;
    private static JTextArea mazeDisplay;
    private static JPanel panel;
    private static JButton resetButton;

    public static final int[][] MAP = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    public static void main(String[] args) throws IOException {
        var current = new Position(1, 1);

        JFrame frame = new JFrame("Maze");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        JButton upButton = new JButton("↑");
        JButton downButton = new JButton("↓");
        JButton leftButton = new JButton("←");
        JButton rightButton = new JButton("→");
        resetButton = new JButton("Reset");

        upButton.addActionListener(ae -> {
                    if (MAP[current.y() - 1][current.x()] == 0) {
                        current.up();
                        updateDisplay(current);
                    }
                }
        );

        downButton.addActionListener(ae -> {
                    if (MAP[current.y() + 1][current.x()] == 0) {
                        current.down();
                        updateDisplay(current);
                    }
                }
        );

        leftButton.addActionListener(ae -> {
                    if (MAP[current.y()][current.x() - 1] == 0) {
                        current.left();
                        updateDisplay(current);
                    }
                }
        );

        rightButton.addActionListener(ae -> {
                    if (MAP[current.y()][current.x() + 1] == 0) {
                        current.right();
                        updateDisplay(current);
                    }
                }
        );

        resetButton.setName("resetButton");
        resetButton.addActionListener(ae -> {
            reset(current);
            updateButtonState(true);
        });
        resetButton.setEnabled(false);

        panel.add(upButton);
        panel.add(downButton);
        panel.add(leftButton);
        panel.add(rightButton);
        panel.add(resetButton);
        panel.setPreferredSize(new Dimension(100, 200));

        mazeDisplay = new JTextArea(generateDisplay(current));
        mazeDisplay.setEditable(false);
        mazeDisplay.setPreferredSize(new Dimension(200, 200));

        informationLabel = new JLabel("");
        informationLabel.setPreferredSize(new Dimension(300, 50));
        informationLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add("South", informationLabel);

        frame.add("Center", mazeDisplay);
        frame.add("East", panel);
        frame.setVisible(true);
    }

    private static void updateDisplay(Position current) {
        mazeDisplay.setText(generateDisplay(current)); // テキストを更新

        if (current.x() == GOAL.x() && current.y() == GOAL.y()) {
            informationLabel.setText("Goal!");
            updateButtonState(false);
            resetButton.setEnabled(true);
        }
    }

    private static String generateDisplay(Position current) {
        var playerWalkingStatus = false;
        var leftBorder = Math.min(current.x() - 3, 0);
        var underBorder = Math.min(current.y() - 3, 0);
        var rightBorder = Math.max(current.x() - 8, 0);
        var overBorder = Math.max(current.y() - 8, 0);

        StringBuilder result = new StringBuilder();
        for (int y = 0; y < MAP.length; y++) {
            for (int x = 0; x < MAP[y].length; x++) {
                if (x + leftBorder > current.x() + 3 || y + underBorder > current.y() + 3) {
                    continue;
                }

                if (x + rightBorder < current.x() - 3 || y + overBorder < current.y() - 3) {
                    continue;
                }

                if (x == current.x() && y == current.y()) {
                    result.append(playerWalkingStatus ? 'O' : 'o');

                    playerWalkingStatus = !playerWalkingStatus;
                    continue;
                }

                if (x == GOAL.x() && y == GOAL.y()) {
                    result.append("G");
                    continue;
                }

                if (MAP[y][x] == 1) {
                    result.append("[]");
                    continue;
                }

                result.append("  ");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    private static void reset(Position current) {
        informationLabel.setText("");
        resetButton.setEnabled(false);
        current.setX(1);
        current.setY(1);
        updateDisplay(current);
    }


    private static void updateButtonState(boolean enabled) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton && !Objects.equals(component.getName(), "resetButton")) {
                component.setEnabled(enabled);
            }
        }
    }
}
