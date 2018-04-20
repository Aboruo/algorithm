package com.aboruo.algorithm.sort.insertSort;
/**
 * 类名称：InsertSortAlgo
 * 类描述：插入法排序
 * @author aboruo
 * @date 2018年4月20日 下午7:49:38
 */
public class InsertSortAlgo {

	public static void main(String[] args) {
		/** 初始化排序数组 */
		int[] sourceArray = {10,2,5,1,8,7,6,9};
		int[] resultArray = insertSort(sourceArray);
		for(int i = 0;i < resultArray.length;i++) {
			System.out.println(resultArray[i]);
		}
	}
	/**
	 * @Title:insertSort
	 * @Description: 插入排序
	 * @author:aboruo
	 * @param sourceArray
	 * @return int[]
	 * @date 2018年4月20日 下午8:24:17
	 */
	public static int[] insertSort(int[] sourceArray) {
		int[] resultArray = new int[sourceArray.length];
		for(int i = 0; i < sourceArray.length;i++) {
			int sourceEle = sourceArray[i];
			if(i == 0) {
				resultArray[i] = sourceEle; //如果是第一个元素直接插入到目的数组的第一个元素中
				continue;
			}
			resultArray[i] = sourceArray[i];
			for(int j = i;j > 0;j--) {
				if(sourceArray[i] < resultArray[j-1] ) {
					int tempEle = resultArray[j-1];
					resultArray[j-1] = sourceArray[i];
					resultArray[j] = tempEle;
				}else {
					break;
				}
			}
		}
		return resultArray;
	}
}
