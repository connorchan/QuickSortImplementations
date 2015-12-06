import java.io.*;
import java.util.Scanner;

public class CourseraQuickSort {
	
	public static int count1st;
	public static int countLast;
	public static int countMed;
	
	public static void quickSortFirst(int[] inarr, int left, int right) {
		if (left < right) {
			count1st += (right - left - 1);
			int pivot = partitionFirst(inarr, left, right);
			quickSortFirst(inarr, left, pivot);
			quickSortFirst(inarr, pivot + 1, right);
		}
	}
	
	public static void quickSortLast(int[] inarr, int left, int right) {
		if (left < right) {
			countLast += (right - left - 1);
			int pivot = partitionLast(inarr, left, right);
			quickSortLast(inarr, left, pivot);
			quickSortLast(inarr, pivot + 1, right);
		}
	}
	
	public static void quickSortMed(Integer[] inarr, int left, int right) {
		if (left < right) {
			countMed += (right - left - 1);
			int pivot = partitionMed(inarr, left, right);
			quickSortMed(inarr, left, pivot);
			quickSortMed(inarr, pivot + 1, right);
		}
	}
	
	public static int partitionFirst(int[] inarr, int left, int right) {
		int pivot = inarr[left];
		int i = left + 1;
		
		for(int j = left + 1; j < right; j++) {
			if (inarr[j] < pivot) {
				swap(inarr, i, j);
				i++;
			}
		}
		swap(inarr, left, i - 1);
		return i - 1;
	}
	
	public static int partitionLast(int[] inarr, int left, int right) {
		int pivot = inarr[right - 1];
		inarr[right - 1] = inarr[left];
		inarr[left] = pivot;
		int i = left + 1;
		
		for(int j = left + 1; j < right; j++) {
			if (inarr[j] < pivot) {
				swap(inarr, i, j);
				i++;
			}
		}
		swap(inarr, left, i - 1);
		return i - 1;
	}
	
	public static int partitionMed(Integer[] inarr, int left, int right) {
		int x = inarr[left];
		int y = inarr[right - 1];
		int length = right - left;
		int mid;
		if (length % 2 == 0) {
			mid = inarr[left + (length/2 - 1)];
		}
		else
			mid = inarr[left + (length/2)];
		
		int pivot = median(x, y, mid);
		int pivInd = java.util.Arrays.asList(inarr).indexOf(pivot);
		
		inarr[pivInd] = inarr[left];
		inarr[left] = pivot;
		
		int i = left + 1;
		
		for(int j = left + 1; j < right; j++) {
			if (inarr[j] < pivot) {
				listSwap(inarr, i, j);
				i++;
			}
		}
		listSwap(inarr, left, i - 1);
		return i - 1;
	}
	
	public static int median(int x, int y, int z) {
		//find the median of three unordered elements
		if ((x - y) * (z - x) >= 0) {
			return x;
		}
		else if ((y - x) * (z - y) >= 0) {
			return y;
		}
		else
			return z;
	}
	
	public static void swap(int[] inarr, int i, int j) {
		//function for swapping values in an array
		int tmp = inarr[i];
		inarr[i] = inarr[j];
		inarr[j] = tmp;
	}
	
	public static void listSwap(Integer[] inarr, int i, int j) {
		int tmp = inarr[i];
		inarr[i] = inarr[j];
		inarr[j] = tmp;
	}
	
	public static void main(String[] args) {
		try
		{
			Scanner scanner = new Scanner(new File("qs.txt"));
			//To test the median pivot case, uncomment line 124, comment out 123, change function call on 131
			//Integer [] tstin = new Integer [10000];
			int [] tstin = new int[10000];
			int i = 0;
			while(scanner.hasNextInt())
			{
			     tstin[i++] = scanner.nextInt();
			}
			quickSortFirst(tstin, 0, tstin.length);
			System.out.println(count1st);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("Nope lol");
		}
	}
}