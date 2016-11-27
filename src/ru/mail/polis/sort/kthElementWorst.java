package ru.mail.polis.sort;

import java.util.Arrays;


public class kthElementWorst {

    public static void kthElement(int[] a, int k) {
        int left = 0, right = a.length - 1;
        while (right > left) {
            int pivotIdx = getPivot(a);
            int idx = partition(a, left, right, pivotIdx);
            if (k < idx) right = idx - 1;
            else if (k > idx) left = idx + 1;
            else return;
        }
    }

    static int partition(int[] a, int left, int right, int pivot) {
        if (left > right) return right;
        int i = left, j = right, x = a[pivot];
        swap(a, j--, pivot);
        while (i <= j) {
            while (i <= j && a[i] < x) i++;
            while (i <= j && a[j] > x) j--;
            if (i >= j) break;
            swap(a, i++, j--);
        }
        swap(a, i, right);
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int getPivot(int[] a) {
        if (a.length <= 5) {
            Arrays.sort(a);
            return (a.length - 1) / 2;
        }
        int[] medians = new int[(a.length + 4) / 5];
        for (int i = 0; i < a.length; i += 5) {
            medians[i / 5] = getPivot(Arrays.copyOfRange(a, i, Math.min(i + 5, a.length)));
        }
        return getPivot(medians);
    }
}