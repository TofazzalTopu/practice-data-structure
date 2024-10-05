package com.example.practice.datastructure.model.searchAndSort;
import java.util.*;

public class Search {

}

// How to perform Bubble Sort in Java?
class BubbleSort {
    public static void main(String[] args) {
        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        for(int i=0;i<10;i++)
        {
            for (int j=0;j<10;j++)
            {
                if(a[i]<a[j])
                {
                    int temp = a[i];
                    a[i]=a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println("Printing Sorted List ...");
        for(int i=0;i<10;i++)
        {
            System.out.println(a[i]);
        }
    }
}

class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};
        int item, location = -1;
        System.out.println("Enter the item which you want to search");
        Scanner sc = new Scanner(System.in);
        item = sc.nextInt();
        location = binarySearch(arr,0,9,item);
        if(location != -1)
            System.out.println("the location of the item is "+location);
        else
            System.out.println("Item not found");
    }
    public static int binarySearch(int[] a, int beg, int end, int item)
    {
        int mid;
        if(end >= beg)
        {
            mid = (beg + end)/2;
            if(a[mid] == item)
            {
                return mid+1;
            }
            else if(a[mid] < item)
            {
                return binarySearch(a,mid+1,end,item);
            }
            else
            {
                return binarySearch(a,beg,mid-1,item);
            }
        }
        return -1;
    }
}

class SelectionSort {
    public static void main(String[] args) {
        int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        int i,j,k,pos,temp;
        for(i=0;i<10;i++)
        {
            pos = smallest(a,10,i);
            temp = a[i];
            a[i]=a[pos];
            a[pos] = temp;
        }
        System.out.println("\nprinting sorted elements...\n");
        for(i=0;i<10;i++)
        {
            System.out.println(a[i]);
        }
    }
    public static int smallest(int a[], int n, int i)
    {
        int small,pos,j;
        small = a[i];
        pos = i;
        for(j=i+1;j<10;j++)
        {
            if(a[j]<small)
            {
                small = a[j];
                pos=j;
            }
        }
        return pos;
    }
}
