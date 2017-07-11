package com.algo.search;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.algo.util.In;
import com.algo.util.StdIn;
import com.algo.util.StdOut;

/**
 * 简化版二分搜索
 * 
 * @author peige
 */
public class EasyBinarySearch {
	
	public static int rank(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if(key > a[mid])
				low = mid+1;
			else if(key < a[mid])
				high = mid-1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		String fileName = "data\\BinarySearch.txt";
		int[] whitelist = new In(fileName).readAllInts();
		Arrays.sort(whitelist);
		System.out.println(Arrays.toString(whitelist));
		while(!StdIn.isEmpty()) {
			// 读取键值，如果不存在白名单中则将其打印
			int key = StdIn.readInt();
			if(rank(key, whitelist) < 0) {
				StdOut.println(key);
			}
		}
	}
}







