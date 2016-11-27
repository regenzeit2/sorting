package ru.mail.polis.sort;

/**
 * Created by Камилла on 18.11.2016.
 */
public class LSD {
    public static long[] sort (long[] a) {
        final int r = 10;
        int d = String.valueOf(a[0]).length();
        for (int k = 0; k < d; k++) {
            int[] count = new int[r];
            for (long x : a) count[digit(x, k)]++;
            for (int i = 1; i < r; i++) {
                count[i] += count[i - 1];
            }
            long[] res = new long[a.length];
            for (int i = a.length - 1; i >= 0; i--) {
                res[--count[digit(a[i], k)]] = a[i];
            }
            System.arraycopy(res,0,a,0,a.length);
        }
        return a;
    }
    public static int digit(long x, int k) {
        String s = Long.toString(x);
        return Integer.parseInt(""+s.charAt(s.length()-k-1));
    }

}
