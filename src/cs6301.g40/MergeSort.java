package cs6301.g40;

import java.util.InputMismatchException;

/**
 * Created by mukku on 8/26/2017.
 */
public class MergeSort {
    static<T extends Comparable<? super T>> void mergeSort(T[] arr, T[] tmp){
        int len = arr.length;
        sort(arr,0,len-1,tmp);
    }
    static<T extends Comparable<? super T>> void sort(T[] arr, int first, int last, T [] temp){
        if(first < last) {
            int middle = (last + first) / 2;
            sort(arr, first, middle, temp);
            sort(arr, middle + 1, last, temp);
            merge(arr,first,middle,last,temp);
        }
    }

    static<T extends Comparable<? super T>> void merge(T[] arr, int first, int middle, int last,T[] temp){
        for(int i=first; i<=last; i++ )
            temp[i] = arr[i];

        int i = first;
        int j = middle+1;
        int k = first;
        while(i<=middle && j <=last){
            if(temp[i].compareTo(temp[j])<0) arr[k++]=temp[i++];
            else arr[k++]=temp[j++];
        }

        while(i<=middle) arr[k++] = temp[i++];
    }
    public static void main(String [] args){
        int n = 20;
        Integer[] inums = new Integer[n];
        for(int i=0; i<n; i++) {
            inums[i] = new Integer(i);
        }
        Shuffle.shuffle(inums);
        //     T <Integer> [] arr = new T <Integer>(inums);
        Integer [] temp = new Integer[inums.length];
        for(int i=0;i<20;i++)
            System.out.print(inums[i]+" ");

        System.out.println();
        Timer t = new Timer(); // start timer
    //    System.out.println(t.end());
    //    t.start();
        mergeSort(inums,temp);

        System.out.println(t.end());  // timer end

      for(int i=0;i<20;i++)
            System.out.print(inums[i]+" ");
        System.out.println();

  /*      int n = 10;
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) {
            arr[i] = new Integer(i);
        }
        Shuffle.printArray(arr, "Before:");
        Shuffle.shuffle(arr);
        Shuffle.printArray(arr, "After:");*/

    }
}
