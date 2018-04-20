package com.aboruo.algorithm.sort.selectSort;
/**
 * 类名称：SelectSortAlgo
 * 类描述：选择排序实现
 * @author aboruo
 * @date 2018年4月20日 下午7:26:53
 */
public class SelectSortAlgo {

	public static void main(String[] args) {
		/** 初始化排序数组 */
		int[] sourceArray = {10,2,5,1,8,7,6,9};
		selectSort(sourceArray);
		for(int i = 0;i < sourceArray.length;i++) {
			System.out.println(sourceArray[i]);
		}
	}
	/**
	 * @Title:selectSort
	 * @Description: 选择排序
	 * @author:aboruo
	 * @param sourceArray void
	 * @date 2018年4月20日 下午7:38:19
	 */
	public static void selectSort(int[] sourceArray) {
		int minMarkIndex = 0;
		int tempEle = 0;
		for(int i = 0;i < sourceArray.length;i++) {
			int currentMinEle = sourceArray[i];
			minMarkIndex = i;
			for(int j = i + 1;j < sourceArray.length;j++) {
				if(currentMinEle > sourceArray[j]) {
					currentMinEle = sourceArray[j];
					minMarkIndex = j;
				}
			}
			if(i != minMarkIndex) {
				tempEle = sourceArray[i];
				sourceArray[i] = sourceArray[minMarkIndex];
				sourceArray[minMarkIndex] = tempEle;
			}
		}
	}
}
