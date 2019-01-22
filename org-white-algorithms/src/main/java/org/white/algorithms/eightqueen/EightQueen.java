package org.white.algorithms.eightqueen;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: EightQueen.java, v 0.1 2019年01月22日 14:25:00 white Exp$
 */
public class EightQueen {

    private static int[][] board = new int[8][8];

    public static void main(String[] args) {
        put(0);
    }

    private static void put(int y) {
        if (y == 8) {
            printBoard();
            return;
        }
        for (int i = 0; i < 8; i++) {
            // 递归过程中可能存在在一行放多个的情况,需要清除同一行其他
            for (int j = 0; j < 8; j++) {
                board[j][y] = 0;
            }
            if (check(i, y)) {
                board[i][y] = 1;
                put(y + 1);
            }
        }
    }

    /**
     * 检测是否可放置queen,只需向上检查
     * @param x
     * @param y
     * @return
     */
    private static boolean check(int x, int y) {
        for (int i = 1; i <= y; i++) {
            if (board[x][y - i] == 1) {
                return false;
            }
            if (x - i >= 0 && board[x - i][y - i] == 1) {
                return false;
            }
            if (x + i < 8 && board[x + i][y - i] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    private static void printBoard() {
        System.out.println("----------------------------------");
        for (int i = 0; i < board.length; i++) {
            int[] line = board[i];
            for (int j = 0; j < line.length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
