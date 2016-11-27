package ru.mail.polis.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HelperLSD {

    private static final Random r = ThreadLocalRandom.current();

    public static void swap(long[] a, int i, int j) {
        long x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static long[] gen(int n) {
        long[] a = new long[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = n*(r.nextInt(9999-1000)+1000);
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            HelperLSD.swap(a, i, j);
        }
        return a;
    }
}
