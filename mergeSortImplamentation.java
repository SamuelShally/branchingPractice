//Merge sort implamentation 

import java.util.*;

class Runner
{
	public static void main(String[] args)
	{		

		// int[] arr = {32,7,5,2,6,11};
		int[] arr = {9,8,7,6,5,4,3,2,1};
		
		Sort test = new Sort();
		test.mergeSort(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
	}
}

class Sort
{
	//mergeSort takes the array and its length
	public static void mergeSort(int[] arr, int n)
	{
		//if length of the array is less than two return, for the reccursive implamentation
		if(n < 2)
		{
			return;
		}
		
		//using the array length to create two sub array sizes with mid and mid-n elements 
		int mid = n/2; 
		int[] l = new int[mid];
		int[] r = new int[n-mid];
		
		//fill the array with its respective elements
		for(int x = 0; x<mid; x++)
		{
			l[x] = arr[x];
		}
		
		
		//rememeber that mid is really the index of mid+1
		for(int x = mid; x < n; x++)
		{
			r[x-mid] = arr[x];
		}
		
		
		//recursive mergeSort calls
		mergeSort(l, mid);
		mergeSort(r, n-mid);
		
		merge(arr, l, r, mid, n-mid);
	}
	
	//Merge takes two sorted arrays
	public static void merge(int[] arr,int[] l,int[] r,int left,int right)
	{
		int i=0, j=0, k=0;
		
		//re-arange elements in array based on comparision in the two sorted sub-arrays
		while(i < left && j < right)
		{
			if(l[i] <= r[j])
			{
				arr[k] = l[i]; 
				k++; 
				i++;
			}
			else 
			{
				arr[k] = r[j]; 
				k++; 
				j++;
			}
			
		}
		//fill with the remainder of sorted largest elements. Only one of these while loops will ever execute
		while(i < left)
		{
			arr[k] = l[i]; 
			k++; 
			i++;			
		}
		while(j < right)
		{
			arr[k] = r[j]; 
			k++; 
			j++;
		}
	}
}

