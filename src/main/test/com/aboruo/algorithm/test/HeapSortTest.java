package com.aboruo.algorithm.test;

import com.aboruo.algorithm.sort.heapSort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : aboruo
 * @name : HeapSortTest
 * @description :
 * @date : 2022/5/17 19:37
 */
public class HeapSortTest {
    @Test
    public void test() {
        int[] array = {3,2,4,1,5,9,8,7,100,99,98,34,56,21,19,18,17,16,22,3,2,1};
        HeapSort.heapSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
