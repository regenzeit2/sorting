package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by Камилла on 18.11.2016.
 */
public class kthElement {
    Random random = new Random();
    public static void kthElement(int[]a, int k, Random random) {
        int left=0, right=a.length-1;
        while (right>left) {
            int pivotIdx = left+random.nextInt(right-left+1);
            int idx = partition(a,left,right,pivotIdx);
            if (k<idx) right=idx-1;
            else if (k>idx) left = idx+1;
            else return;
        }
    }
    static int partition(int[]a, int left, int right, int pivot) {
        if (left>right) return right;
        int i=left, j=right, x=a[pivot];
        Helper.swap(a,j--,pivot);
        while (i<=j) {
            while (i<=j && a[i]<x) i++;
            while (i<=j && a[j]>x) j--;
            if (i>=j) break;
            Helper.swap(a,i++, j--);
        }
        Helper.swap(a,i,right);
        return i;
    }

}