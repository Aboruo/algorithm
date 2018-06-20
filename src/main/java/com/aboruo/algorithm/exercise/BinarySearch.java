package com.aboruo.algorithm.exercise;

public class BinarySearch {

	public static void main(String[] args) {
		/** 定已数组元素 */
		int[] sourceArray = {3,20,19,38,4,2,7,24,23,30,5};
		/** 1. 先将数组进行排序 */
		quickSort(sourceArray, 0, 10);
		for(int i = 0;i < sourceArray.length - 1;i++) {
			System.out.println(sourceArray[i]);
		}
		/** 2. 二分法查找数组元素 */
		int index = binarySearch(sourceArray, 19);
		System.out.println("元素下标位置为：" + index);
	}
	/**
	 * @Title:quickSort
	 * @Description: 快速排序方法
	 * @author:aboruo
	 * @param sourceArray
	 * @param headIndex
	 * @param tailIndex void
	 * @date 2018年6月14日 下午4:49:52
	 */
	public static void quickSort(int[] sourceArray,int headIndex,int tailIndex) {
		int comparedIndex = headIndex; //参照数位置
		int tailIndexBak = tailIndex;
		int comparedNum = sourceArray[comparedIndex]; //参照数
		if(headIndex >= tailIndex) return;
		while(headIndex < tailIndex) {
			/** 先从尾部哨兵开始移动 */
			while(tailIndex > headIndex) {
				if(sourceArray[tailIndex] >= comparedNum) {
					tailIndex--;
				}else {
					break;
				}
			}
			/** 从头部哨兵开始移动 */
			while(headIndex < tailIndex) {
				if(sourceArray[headIndex] <= comparedNum) {
					headIndex++;
				}else {
					break;
				}
			}
			
			/** 头部哨兵找到了 > 参照数的元素，尾部哨兵找到了 < 参照数的元素，两个哨兵位置的元素做交换 */
			if(headIndex < tailIndex) {
				int tmp = sourceArray[headIndex];
				sourceArray[headIndex] = sourceArray[tailIndex];
				sourceArray[tailIndex] = tmp;
			}else if(headIndex == tailIndex) {
				/** 两个哨兵相遇证明本次查找完毕，哨兵位置元素和参照数做交换 */
				int tmp = sourceArray[headIndex];
				sourceArray[headIndex] = comparedNum;
				sourceArray[comparedIndex] = tmp;
			}
		}
		/** 对哨兵位置前半部分数组元素和后半部分数组元素分别做递归排序 */
		quickSort(sourceArray, comparedIndex, --tailIndex); //前半部分做排序
		quickSort(sourceArray, ++headIndex, tailIndexBak);
	}
	/**
	 * @Title:binarySearch
	 * @Description: 二分法查找元素位置
	 * @author:aboruo
	 * @param sourceArray
	 * @param ele
	 * @return int
	 * @date 2018年6月14日 下午5:33:34
	 */
	public static int binarySearch(int[] sourceArray,int ele) {
		int retIndex = 0;
		/** 定义数组起始，中间，结尾位置 */
		int midleIndex = sourceArray.length >> 1;
		int headIndex = 0;
		int tailIndex = sourceArray.length - 1;
		while(headIndex <= tailIndex) {
			if(sourceArray[midleIndex] > ele) {
				tailIndex = midleIndex - 1;
				midleIndex = (headIndex + tailIndex) >> 1;
			}else if(sourceArray[midleIndex] < ele) {
				headIndex = midleIndex + 1;
				midleIndex = (headIndex + tailIndex) >> 1;
			}else {
				retIndex = midleIndex;
				break;
			}
		}
		return retIndex;
	}
}
