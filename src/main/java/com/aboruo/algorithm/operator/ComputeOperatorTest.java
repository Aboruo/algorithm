package com.aboruo.algorithm.operator;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComputeOperatorTest {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		int operateNum = -10;
		System.out.println(Integer.highestOneBit(11));
		System.out.println(Math.min(10, 33));
		System.out.println(true ^ false);
		Map<String, String> map = new HashMap<>();
		map = new ConcurrentHashMap<>();
		map.put("test", "aaaa");
		String altThreshold = java.security.AccessController.doPrivileged(
                new sun.security.action.GetPropertyAction(
                    "jdk.map.althashing.threshold"));
		System.out.println(altThreshold);
		System.out.println("-10左移两位后结果：" + moveOperate(operateNum, 2, 0));
		System.out.println("-10右移两位后结果：" + moveOperate(operateNum, 2, 1));
		System.out.println("-10无符号右移两位结果：" + moveOperate(operateNum, 2, 2));
		System.out.println("-10无符号右移两位结果：" + Integer.toBinaryString(moveOperate(operateNum, 2, 2)));
	}
	public static int moveOperate(int operateNum,int offset,int moveType) {
		switch (moveType) {
		case 0: // 左移
			operateNum = operateNum << offset;
			break;
		case 1: // 右移
			operateNum = operateNum >> offset;
			break;
		case 2: //无符号右移
			operateNum = operateNum >>> offset;
			break;
		default:
			break;
		}
		return operateNum;
	}
}	
