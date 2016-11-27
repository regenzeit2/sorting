package ru.mail.polis.sort;
import java.util.Random;
/**
 * Created by Камилла on 18.11.2016.
 */
public class QuickRandThreeSort {
    public static Random rnd = new Random();
    public static void doSort(int[] a, int b, int e) {
        int l=b;
        int r=e;
        int piv = a[l + rnd.nextInt(r - l + 1)];
        while (l<=r)
        {
            while (a[l]<piv) l++;
            while (a[r]>piv) r--;
            if (l<=r) Helper.swap(a, l++, r--);
        }
        if (b<r) doSort(a,b,r);
        if (e>l) doSort(a,l,e);
    }
    public static int[] sort(int[]a) {
        doSort(a,0,a.length-1);
        return a;
    }
}
