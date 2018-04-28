package com.aboruo.algorithm.sort.mergeSort;
/**
 * 类名称：MergeSortAlgo
 * 类描述：归并排序实现测试类
 * @author aboruo
 * @date 2018年4月23日 上午11:24:53
 */
public class MergeSortAlgo {

	public static void main(String[] args) {
		int[] testArray = new int[] {4, 3, 6, 1, 2, 5,20,19,17,15,16,13};
		mergeSort(testArray, 0, 1);
		for(int i = 0; i < testArray.length;i++) {
			System.out.println(testArray[i]);
		}
	}
	/**
	 * @Title:mergeSort
	 * @Description:TODO
	 * @author:aboruo
	 * @param sourceArray 要进行排序的数组
	 * @param startIndex 起始位置
	 * @param eleNums 每次归并的有序集合长度
	 * @date 2018年4月23日 下午2:12:31
	 */
	public static void mergeSort(int[] sourceArray,int startIndex,int eleNums) {
		int size = sourceArray.length;
		int parts = size / (eleNums << 1); //数组根据有序集合长度*2(因为是两两合并)，可以划分为几部分
		int leftEles = size % (eleNums << 1);//有序集合两两合并时，原数组剩余元素数量
		/** 1. 判断排序是否完成 */
		if(parts == 0) return;
		for(int i = 0;i < parts;i++) {
			int mergeOneStart = i * 2 * eleNums;
			int mergeTwoEnd = mergeOneStart + 2 * eleNums - 1;
			merge(sourceArray, mergeOneStart, mergeOneStart + eleNums, mergeTwoEnd);
		}
		
		if(leftEles != 0) {
			merge(sourceArray, size - leftEles - 2 * eleNums, size - leftEles, size - 1);
		}
		mergeSort(sourceArray, 0, eleNums << 1);
	}
	/**
	 * @Title:merge
	 * @Description: 对两个有序数组进行合并
	 * @author:aboruo
	 * @param sourceArray 要排序的数组
	 * @param mergeOneStart 有序数组1 的 下标起始位置
	 * @param mergeTwoStart 有序数组2 的 下标起始位置
	 * @param mergeTwoEnd 有序数组2 的 下标结束位置
	 * @date 2018年4月23日 下午2:36:21
	 */
	public static void merge(int[] sourceArray,int mergeOneStart,int mergeTwoStart,int mergeTwoEnd) {
		int[] tmp = new int[mergeTwoEnd - mergeOneStart + 1]; //临时数组
		int m1Index = mergeOneStart;
		int m2Index = mergeTwoStart;
		int tmpIndex = 0;
		
		/** 循序进行比较 */
		while(m1Index < mergeTwoStart && m2Index <= mergeTwoEnd) {
			if(sourceArray[m1Index] < sourceArray[m2Index]) {
				tmp[tmpIndex++] = sourceArray[m1Index];
				m1Index++;
			}else {
				tmp[tmpIndex++] = sourceArray[m2Index];
				m2Index++;
			}
		}
		
		/** 检查有序数组1是否有剩余元素,如果有追加到临时数组尾部 */
		while(m1Index < mergeTwoStart) {
			tmp[tmpIndex++] = sourceArray[m1Index++];
		}
		
		/** 检查有序数组2是否有剩余元素,如果有追加到临时数组尾部 */
		while(m2Index <= mergeTwoEnd) {
			tmp[tmpIndex++] = sourceArray[m2Index++];
		}
		
		/** 将排序完成的临时数组拷贝到原数组中 */
		System.arraycopy(tmp, 0, sourceArray, mergeOneStart, tmp.length);
	}
}
