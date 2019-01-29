package org.white.algorithms.sudoku;

import javafx.util.Pair;

/**
 * <p></p >
 *
 * @author white
 * @version $Id: Sudoku.java, v 0.1 2019年01月29日 14:30:00 white Exp$
 */
public class Sudoku {

    private static int[][] array = {
            {0,0,5,3,0,0,0,0,0},
            {8,0,0,0,0,0,0,2,0},
            {0,7,0,0,1,0,5,0,0},
            {4,0,0,0,0,5,3,0,0},
            {0,1,0,0,7,0,0,0,6},
            {0,0,3,2,0,0,0,8,0},
            {0,6,0,5,0,0,0,0,9},
            {0,0,4,0,0,0,0,3,0},
            {0,0,0,0,0,9,7,0,0}
    };

    public static void main(String[] args) {
        print();
        sudoku();
    }

    private static boolean sudoku() {
        Pair<Integer, Integer> nextElement = findNextEmptyElement();
        if (nextElement == null) {
            print();
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(nextElement.getKey(), nextElement.getValue(), i)) {
                array[nextElement.getKey()][nextElement.getValue()] = i;
                if (!sudoku()) {
                    array[nextElement.getKey()][nextElement.getValue()] = 0;
                }
            }
        }
        return false;
    }

    private static boolean check(int x, int y, int value) {
        // 检查横排
        for (int j = 0; j < 9; j++) {
            if (array[x][j] == value) {
                return false;
            }
        }
        // 检查竖排
        for (int i = 0; i < 9; i++) {
            if (array[i][y] == value) {
                return false;
            }
        }
        // 检查小3格
        int tempX = x / 3 * 3;
        int tempY = y / 3 * 3;
        for (int i = tempX; i < tempX + 3; i++) {
            for (int j = tempY; j < tempY + 3; j++) {
                if (array[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Pair<Integer, Integer> findNextEmptyElement() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] == 0) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    private static void print() {
        System.out.println("============================");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf(array[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
