package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by Камилла on 18.11.2016.
 */
public class MergeSort {
    public static int[] sort(int[]arr) {
        int len = arr.length;
        int n = 1;
        int shift;
        int two_size;
        int[] arr2;
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + two_size));
                for (int i = 0; i < n + two_size; ++i)
                    arr[shift + i] = arr2[i];
                shift += n * 2;
            }
            n *= 2;
        }
        return arr;
    }
    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }
}
