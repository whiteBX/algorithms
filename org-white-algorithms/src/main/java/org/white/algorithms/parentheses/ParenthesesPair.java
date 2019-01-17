package org.white.algorithms.parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>括号配对</p >
 *
 * @author white
 * @version $Id: ParenthesesPair.java, v 0.1 2019年01月17日 19:34:00 white Exp$
 */
public class ParenthesesPair {

    public static void main(String[] args) {
        List<String> pair = new ArrayList<>();
        pair("", pair, 5, 5);
        System.out.println(pair);
    }


    private static void pair(String result, List<String> pair, int left, int right) {
        if (left == 0 && right == 0)  {
            pair.add(result);
            return;
        }
        if (left > 0) {
            pair(result + "(", pair, left - 1, right);
        }
        if (right > left) {
            pair(result + ")", pair, left, right - 1);
        }

    }

}
