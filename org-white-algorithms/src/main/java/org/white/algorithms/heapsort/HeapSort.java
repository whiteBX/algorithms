package org.white.algorithms.heapsort;

import java.util.Arrays;

/**
 * <p>堆排序(大根堆) </p >
 *
 * @author white
 * @version $Id: HeapSort.java, v 0.1 2018年05月29日 上午21:35:00 white Exp$
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = new int[]{54, 21, 32, 85, 65, 45, 12, 20, 35, 96};
        //构造完全二叉树
        heapSort.buildHeap(array);
        //排序
        heapSort.sortHeap(array);
        Arrays.stream(array).forEach(i -> System.out.print(i + ","));
    }

    /**
     * 构造完全二叉树
     */
    private void buildHeap(int[] array) {
        int lastParentIndex = getLastParentIndex(array.length);
        /*********************************************
         * 从最后一个父节点开始将树中最大值换到父节点上
         *********************************************/
        for (int i = lastParentIndex; i >= 0; i--) {
            buildTree(array, array.length, i);
        }
    }

    /**
     * 排序传入的父节点树及改动过的子树
     *
     * @param array
     * @param parentIndex
     */
    private void buildTree(int[] array, int maxIndex, int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        int rightChildIndex = getRightChildIndex(parentIndex);

        /***************************************************************
         * 左右节点最大值大于父节点则与父节点交换值并刷新交换后的子节点树
         **************************************************************/
        int maxValueIndex = parentIndex;
        if (leftChildIndex < maxIndex &&
                array[maxValueIndex] < array[leftChildIndex]) {
            maxValueIndex = leftChildIndex;
        }
        if (rightChildIndex < maxIndex &&
                array[maxValueIndex] < array[rightChildIndex]) {
            maxValueIndex = rightChildIndex;
        }

        if (maxValueIndex != parentIndex) {
            swapValue(array, maxValueIndex, parentIndex);
            buildTree(array, maxIndex, maxValueIndex);
        }
    }

    /**
     * 取堆的第一个节点和最后一个节点对换并重排剩下的树
     *
     * @param array
     */
    private void sortHeap(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swapValue(array, 0, i);
            buildTree(array, i, 0);
        }
    }

    /**
     * 取堆的最后一个父节点
     *
     * @param arrayLength 数组长度
     * @return 返回树的最后一个父节点坐标
     */
    private int getLastParentIndex(int arrayLength) {
        return (arrayLength >> 1) - 1;
    }

    /**
     * 获取左子节点的下标
     *
     * @param parentIndex
     * @return
     */
    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex << 1) + 1;
    }

    /**
     * 获取右子节点的下标
     *
     * @param parentIndex
     * @return
     */
    private int getRightChildIndex(int parentIndex) {
        return (parentIndex << 1) + 2;
    }

    /**
     * 交换数组中元素
     *
     * @param array
     * @param sourceIndex
     * @param targetIndex
     */
    private void swapValue(int[] array, int sourceIndex, int targetIndex) {
        int temp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = temp;
    }


}
