package com.aboruo.algorithm.sort.quickSort;

public class QuickSortPrac2 {

	public static void main(String[] args) {
		int[] sourceArray = {3,20,19,38,4,2,7,24,23,30,3};
		quickSort(sourceArray, 0, 10);
		for(int i = 0;i < sourceArray.length - 1;i++) {
			System.out.println(sourceArray[i]);
		}
	}
	public static void quickSort(int[] sourceArray,int headIndex,int tailIndex) {
		if(headIndex >= tailIndex) {
			return;
		}
		int comparedNum = sourceArray[headIndex]; //参照标准数
		int comparedIndex = headIndex;
		int tailIndexBak = tailIndex;
		while(headIndex < tailIndex) {
			/** 先从尾部开始移动 */
			while(tailIndex > headIndex) {
				if(sourceArray[tailIndex] >= comparedNum) {
					tailIndex--;
				}else {
					break;
				}
			}
			/** 从头部开始移动 */
			while(headIndex < tailIndex) {
				if(sourceArray[headIndex] <= comparedNum) {
					headIndex++;
				}else {
					break;
				}
			}
			if(headIndex < tailIndex) {
				/** 前半部分符合条件的元素 和 后半部分符合条件的元素 互换位置 */
				int tmp = sourceArray[tailIndex];
				sourceArray[tailIndex] = sourceArray[headIndex];
				sourceArray[headIndex] = tmp;
			} else if(headIndex == tailIndex) {
				/** 说明本次查找完成---> 参照数和标兵此时所指元素进行交换 */
				int tmp = sourceArray[tailIndex];
				sourceArray[tailIndex] = comparedNum;
				sourceArray[comparedIndex] = tmp;
			}
		}
		quickSort(sourceArray, comparedIndex, tailIndex - 1); //数组前半部分快速排序
		quickSort(sourceArray, headIndex + 1, tailIndexBak);//数组后半部分快速排序
	}
}
