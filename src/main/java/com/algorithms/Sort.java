package com.algorithms;

import java.util.Arrays;

public class Sort {

	/**
	 * Time Complexity : O(n^2)
	 * @param arr
	 * @return
	 */
	public int[] bubbleSort(int[] arr){

		for(int i=0; i<arr.length-1; i++){
			for(int j=0; j<arr.length-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		return arr;
	}

	/**
	 * Time Complexity : O(n^2)
	 * @param arr
	 * @return
	 */
	public int[] selectionSort(int[] arr){

		for(int i=0; i<arr.length; i++){
			int min = i;
			for(int j=i+1; j<arr.length; j++){
				if(arr[j]< arr[min]){
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		return arr;
	}

	public int[] insertionSort(int[] arr){

		for(int i=1; i< arr.length; i++){

			int target = arr[i];
			int j = i - 1;

			while(j>=0 && target < arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = target;
		}

		return arr;
	}

	public static void main(String[] args){

		int[] arr = {4, 7, 18, 55, 75, 22, 1};

		Sort sort = new Sort();

		Arrays.sort();

		// System.out.println(Arrays.toString(sort.bubbleSort(arr)));

		// System.out.println(Arrays.toString(sort.selectionSort(arr)));

		System.out.println(Arrays.toString(sort.insertionSort(arr)));
	}
}
