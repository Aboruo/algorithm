package com.aboruo.algorithm.sort.heapSort;


/**
 * @author : aboruo
 * @name : HeapSort
 * @description : 排序算法-堆排序，代码中采用大顶堆算法进行排序
 * <p>
 *     堆分类：
 *     1. 大顶堆：每个节点的值都大于或者等于它的左右子节点的值；
 *     2. 小顶堆：每个节点的值都小于或者等于它的左右子节点的值。
 * </p>
 * 详细介绍-./HeapSortRead.md
 * @date : 2022/5/17 16:42
 */
public class HeapSort {
    public static void heapSort(int[] array) {
        if(array == null || array.length <= 1) return;
        buildMaxHeap(array, array.length);
    }

    private static void buildMaxHeap(int[] array, int end) {
        if(end <= 0) return;

        int lastNonLeafIndex = end / 2 - 1;
        for(int i = lastNonLeafIndex; i >= 0; i--) {
            heaps(array, i, end);
        }
        swap(array, 0, end - 1);
        buildMaxHeap(array, end - 1);
    }

    private static void heaps(int[] array, int parentIndex, int end) {
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;
        int largeIndex = parentIndex;
        if(leftIndex < end && array[largeIndex] < array[leftIndex]) {
            largeIndex = leftIndex;
        }
        if(rightIndex < end && array[largeIndex] < array[rightIndex]) {
            largeIndex = rightIndex;
        }

        if(largeIndex != parentIndex) {
            swap(array, largeIndex, parentIndex);
            heaps(array, largeIndex, end);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
