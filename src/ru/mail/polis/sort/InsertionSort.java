package ru.mail.polis.sort;

/**
 * Created by Камилла on 18.11.2016.
 */
public class InsertionSort {
    public static int[] sort (int[]arr)
    {
        for(int i = 1; i < arr.length; i++){
            int currElem = arr[i];
            int prevKey = i - 1;
            while(prevKey >= 0 && arr[prevKey] > currElem){
                arr[prevKey+1] = arr[prevKey];
                prevKey--;
            }
            if (arr[prevKey+1] != currElem) {
                arr[prevKey+1]= currElem;
                            }
        }
        return arr;
    }
}
