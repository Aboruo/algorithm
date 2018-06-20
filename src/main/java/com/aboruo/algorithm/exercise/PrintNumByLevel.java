package com.aboruo.algorithm.exercise;
/**
 * 类名称：PrintNumByLevel
 * 类描述：按层级按格式打印一下字符，要求：层级可控
 *  1
	2*3
	4*5*6
	7*8*9*10
	7*8*9*10
	4*5*6
	2*3
	1
 * @author aboruo
 * @date 2018年6月12日 上午11:45:56
 */
public class PrintNumByLevel {
	public static void main(String[] args) {
		printNumByLevel(5);
	}
	/**
	 * @Title:printNumByLevel
	 * @Description: 按层级按格式打印一下字符，要求：层级可控
	 * @author:aboruo
	 * @param level void
	 * @date 2018年6月12日 上午11:48:00
	 */
	public static void printNumByLevel(int level) {
		int elem = 1;
		for(int i = 1 ;i <= level;i++) {
			int j = 1;
			String printStr = "";
			while(j <= i) {
				if(j == 1 && i == 1) {
					printStr += elem;
					elem++;
					break;
				}else {
					if(j == 1) printStr += elem;
					else
						printStr += "*" + elem;
				}
				elem++;
				j++;
			}
			System.out.println(printStr);
		}
		elem--;
		for(int i = level; i >= 1;i--) {
			int j = 1;
			String printStr = "";
			while(j <= i) {
				if(j == 1 && i == 1) {
					printStr += elem;
					break;
				}else {
					if(j == i) {
						printStr = elem + printStr;
					}else {
						printStr = "*" + elem + printStr;
					}
				}
				elem--;
				j++;
			}
			System.out.println(printStr);
		}
	}
}
