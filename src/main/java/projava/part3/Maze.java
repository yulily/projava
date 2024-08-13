package projava.part3;

import java.io.IOException;

public class Maze {
    public static void main(String[] args) throws IOException {
        record Position(int x, int y) {}
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        var current = new Position(1, 1);
        var goal = new Position(8, 8);
        var playerWalkingStatus = false;
        for (;;) {
            var leftBorder = Math.min(current.x() - 2, 0);
            var underBorder = Math.min(current.y() - 2, 0);
            var rightBorder = Math.max(current.x() - 7, 0);
            var overBorder = Math.max(current.y() - 7, 0);

            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map[y].length; x++) {
                    if (x + leftBorder > current.x() + 2 || y + underBorder > current.y() + 2) {
                        continue;
                    }

                    if (x + rightBorder < current.x() - 2 || y + overBorder < current.y() - 2) {
                        continue;
                    }

                    if (x == current.x() && y == current.y()) {
                        System.out.print(playerWalkingStatus ? 'O' : 'o');
                        playerWalkingStatus = !playerWalkingStatus;
                        continue;
                    }

                    if (x == goal.x() && y == goal.y()) {
                        System.out.print("G");
                        continue;
                    }

                    if (map[y][x] == 1) {
                        System.out.print("*");
                        continue;
                    }

                    System.out.print(".");
                }
                System.out.println();
            }

            if (current.equals(goal)) {
                System.out.println("Goal!");
                break;
            }
            int ch = System.in.read();
            if (ch == '\n') continue;

            var next = switch (ch) {
                case 'h' -> new Position(current.x() - 1, current.y());
                case 'u' -> new Position(current.x(), current.y() - 1);
                case 'j' -> new Position(current.x() + 1, current.y());
                case 'n' -> new Position(current.x(), current.y() + 1);
                default -> current;
            };

            if (map[next.y()][next.x()] == 0) {
                current = next;
            }
            System.in.read();
        }
    }
}
