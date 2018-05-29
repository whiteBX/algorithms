package org.white.algorithms.quicksort;

import java.util.Arrays;

/**
 * <p> 快速排序</p >
 *
 * @author white
 * @version $Id: QuickSort.java, v 0.1 2018年05月29日 上午21:15:00 white Exp$
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 7, 4, 3, 2, 2, 11, 9, 32, 13};
        sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(s -> System.out.print(s + " "));
    }

    /**
     * 单次区间排序
     */
    private static int partition(int[] array, int begin, int end) {
        int value = array[begin];
        while (begin < end) {
            // 从右往左，查找到比选定值小的数值则跳出循环并将小值放到选定值位置
            while (begin < end && array[end] >= value) {
                end--;
            }
            array[begin] = array[end];
            // 从左往右，查找到比选定值大的数值则跳出循环将大值放到end位置
            while (begin < end && array[begin] <= value) {
                begin++;
            }
            array[end] = array[begin];
        }
        // 将选定值处放入合适位置，左边都比他小，右边都比他大
        array[begin] = value;
        return begin;
    }

    /**
     * 递归调用分治完成排序
     */
    private static void sort(int[] array, int begin, int end) {
        if (begin < end) {
            int position = partition(array, begin, end);
            sort(array, begin, position - 1);
            sort(array, position + 1, end);
        }
    }
}
