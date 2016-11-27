package ru.mail.polis.sort;

/**
 * Created by Камилла on 18.11.2016.
 */
public class MSDBinNums { //ИСПРАВИТЬ
    public static void sort (int[] a, int[]res, int left, int right, int r) {
        int d= String.valueOf(a[0]).length();
        if (r>20 || left >=right) return;
        int[] count = new int[11];
        for (int i = left; i <= right; i++) {
            count[digit(a[i], r)]++;
        }
        for (int i = 1; i < 11; i++) {
            count[i] += count[i - 1];
        }
        for (int i = right; i >= left; i--) {
            res[left + --count[digit(a[i], r)]] = a[i];
        }
        System.arraycopy(res, left, a, left, right - left + 1);
        for (int i = 0; i < d; i++) {
            sort(a, res, left + count[i], left + count[i + 1] - 1, r + 1);
        }
    }
    public static int digit(int x, int k) {
        String s = Integer.toString(x);
        return Integer.parseInt(""+s.charAt(k-1));
    }
}
