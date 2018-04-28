package com.aboruo.algorithm.sort.quickSort;
/**
 * 类名称：QuickSortAlgo
 * 类描述：快速排序算法实现-测试类
 * @author aboruo
 * @date 2018年4月25日 上午10:37:18
 */
public class QuickSortAlgo {

	public static void main(String[] args) {
		int[] testArray = new int[] {4, 3, 6, 1, 2, 5,20,19,17,15,16,13};
		quickSort(testArray, 0, 0, testArray.length - 1);
		for(int i = 0;i < testArray.length;i++) {
			System.out.println(testArray[i]);
		}
	}
	/**
	 * @Title:quickSort
	 * @Description: 快速排序方法
	 * @author:aboruo
	 * @param sortedArray 被排序的数组
	 * @param markIndex 基准数或标兵的位置
	 * @param startIndex 排序部分起始位置
	 * @param endIndex 排序部分结束位置
	 * @date 2018年4月25日 上午10:37:02
	 */
	public static void quickSort(int[] sortedArray,int markIndex,int startIndex,int endIndex) {
		if(markIndex > sortedArray.length) return;
		if(startIndex >= endIndex) return;
		int markEle = sortedArray[markIndex];
		int i = startIndex;
		int j = endIndex;
		int tmpEle = markEle + 1;
		while(i < markIndex || j > markIndex) {
			/** 1 从数组尾部开始向前移动查找 小于基准数的元素 */
			while(tmpEle > markEle && j > markIndex) {
				tmpEle = sortedArray[j--];
			}
			if(tmpEle < markEle && j >= markIndex) {
				/** 从尾部开始找到 小于 基准数的元素,找到的元素 与 基准数交换位置，重新标记 */
				int tailIndex = j + 1;
				sortedArray[markIndex] = sortedArray[tailIndex];
				sortedArray[tailIndex] = markEle;
				markIndex = tailIndex;
			}
			
			/** 2 从数组头部开始 查找 大于基准数的元素 */
			while(tmpEle < markEle && i < markIndex) {
				tmpEle = sortedArray[i++];
			}
			if(tmpEle > markEle &&  i <= markIndex) {
				/** 从头部开始找到 大于 基准数的元素,找到的元素 与 基准数交换位置，重新标记 */
				int headIndex = i - 1;
				sortedArray[markIndex] = sortedArray[headIndex];
				sortedArray[headIndex] = markEle;
				markIndex = headIndex;
			}
		}
		
		/** 3 递归进行排序 */
		//基准数前半部分进行排序
		if(markIndex > startIndex) {
			quickSort(sortedArray, startIndex, startIndex, markIndex - 1);
		}
		
		//基准数后半部分进行排序
		if(markIndex < endIndex) {
			quickSort(sortedArray, markIndex + 1, markIndex + 1, endIndex);
		}
	}
}
