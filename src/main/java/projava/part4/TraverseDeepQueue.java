package projava.part4;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraverseDeepQueue {
    public static void main(String[] args) {
        int[][] map = {
                {1,1,1,1,1,1,1},
                {1,0,1,0,0,0,1},
                {1,0,0,0,1,0,1},
                {1,0,1,0,0,2,1},
                {1,1,1,1,1,1,1},
        };
        traverse(map, 1, 1);
        char[] ch = {'.', '*', 'G', 'o'};
        for (int[] row : map) {
            for (int cell : row) {
                System.out.print(ch[cell]);
            }
            System.out.println();
        }
    }

    static boolean traverse(int[][] map, int curX, int curY) {
        record Position(int x, int y) {}
        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(curX, curY));

        for (Position p; (p = queue.poll()) != null;) {
            switch (map[p.y()][p.x()]) {
                case 0: break;
                case 2: return true;
                default: continue;
            }

            map[p.y()][p.x()] = 3;
            queue.offer(new Position(p.x() + 1, p.y()));
            queue.offer(new Position(p.x() - 1, p.y()));
            queue.offer(new Position(p.x(), p.y() + 1));
            queue.offer(new Position(p.x(), p.y() - 1));
        }

        return false;
    }
}
