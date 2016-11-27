package ru.mail.polis.sort;

/**
 * Created by Камилла on 18.11.2016.
 */
public class InsertionBinSort {
    public static int[] sort (int[]a) {
        int n = a.length;
        int k;
        for (int i = 1; i < n; i++) {
            int temp=a[i];
            k = binarySearchLeft(a, a[i],i);
            System.arraycopy(a,k,a,k+1,i-k);
            a[k]=temp;
        }
        return a;
    }

    public static int binarySearchLeft(int[] a, int key, int right) {
        int left=-1;
        while (left<right-1) {
            int mid = (left + right) / 2;
            if (a[mid] < key)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
}
