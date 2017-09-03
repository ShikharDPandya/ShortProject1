package cs6301.g40;

import java.nio.IntBuffer;
import java.util.Arrays;
//import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by mukku on 8/27/2017.
 */

//
public class MergeInt {
    /**
     *
     * @param arr - Unsorted Array which has to be sorted
     * @param temp - Buffer Array
     *  This function calls "sort" function for "arr" array.
     *  It provides start and last index of array "arr" and buffer array
     *  "temp" to "sort" function.
     */
    public static void mergesort(int arr[], int temp[]) {
        int len = arr.length;
        sort(arr, 0, len - 1, temp);
    }

    /**
     *
     * @param arr - Unsorted Array which has to be sorted
     * @param first - initial index of array "arr" from where to start sorting
     * @param last - last index of array "arr" up to which sorting needs to be done
     * @param temp - Buffer Array
     *  The function recursively calls sort function for two halves of array "arr"  and merge them
     */
    public static void sort(int arr[], int first, int last, int temp[]) {
        if (first < last) {
            int middle = (last + first) / 2;
            sort(arr, first, middle, temp);
            sort(arr, middle + 1, last, temp);
            merge(arr, first, middle, last, temp);
        }
    }

    /**
     *
     * @param arr - The inputted array to merge
     * @param first - initial index of first portion of array "arr" to be merged
     * @param middle - final index of first portion of array "arr" to be merged
     * @param last - final index of second portion of array "arr" to be merged
     * @param temp - Buffer Array
     *
     * The function takes two different sorted portion of array and merge them as a sorted portion
     */
    public static void merge(int arr[], int first, int middle, int last, int temp[]) {
        // Copy everything to a temporary array
        for (int i = first; i <= last; i++)
            temp[i] = arr[i];

        int i = first;
        int j = middle + 1;
        int k = first;
        while (i <= middle && j <= last) {
            if (temp[i] < temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }

        while (i <= middle) arr[k++] = temp[i++];
    }


    public static void main(String[] args) {
        int n = 10000000;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] temp = new int[arr.length];
        //       List<Integer> ar = IntStream.of(arr).boxed().collect(Collectors.toList());
        Integer[] newArr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //   Shuffle.shuffle ( Arrays.stream( arr ).boxed().toArray( Integer[]::new ));

//        System.out.println(ar.toArray());
//        System.out.println("aa");
//        Integer[] newArr = new Integer[n];
//        ar.toArray(newArr);
//        System.out.println(newArr);
     /*   for (int i = 0; i < 10; i++)
            System.out.print(newArr1[i] + " ");
        System.out.println();*/

        Shuffle.shuffle(newArr1);
//        System.out.println(newArr);
//        for(int i=0;i<10;i++)
//            System.out.print(newArr1[i]+" ");
//        System.out.println();
        for (int i = 0; i < n; i++) {
            arr[i] = newArr1[i];
        }
      /*  for (int i = 0; i < 10; i++)
            System.out.print(arr[i] + " ");*/

        Timer t = new Timer();
        mergesort(arr, temp);
        System.out.println(t.end());

      /*  for (int i = 0; i < 10; i++)
            System.out.print(arr[i] + " ");*/


    }
}
