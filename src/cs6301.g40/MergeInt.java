package cs6301.g40;
import java.nio.IntBuffer;
import java.util.Arrays;
//import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created by mukku on 8/27/2017.
 */
public class MergeInt {

    public static void mergesort(int arr [], int temp []){
        int len = arr.length;
        sort(arr,0,len-1,temp);
    }

    public static void sort(int arr [], int first , int last, int temp []){
        if(first < last) {
            int middle = (last + first) / 2;
            sort(arr, first, middle, temp);
            sort(arr, middle + 1, last, temp);
            merge(arr,first,middle,last,temp);
        }
    }

    public static void merge(int arr [], int first , int middle , int last, int temp []){
        for(int i=first; i<=last; i++ )
            temp[i] = arr[i];

        int i = first;
        int j = middle+1;
        int k = first;
        while(i<=middle && j <=last){
            if(temp[i]<temp[j]) arr[k++]=temp[i++];
            else arr[k++]=temp[j++];
        }

        while(i<=middle) arr[k++] = temp[i++];
    }
    public static void main (String [] args){
        int n =10;
        int [] arr = new int[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = i;
        }
        int [] temp = new int [arr.length];
 //       List<Integer> ar = IntStream.of(arr).boxed().collect(Collectors.toList());
        Integer[] newArr1 = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
    //   Shuffle.shuffle ( Arrays.stream( arr ).boxed().toArray( Integer[]::new ));

//        System.out.println(ar.toArray());
//        System.out.println("aa");
//        Integer[] newArr = new Integer[n];
//        ar.toArray(newArr);
//        System.out.println(newArr);
        for(int i=0;i<10;i++)
            System.out.print(newArr1[i]+" ");
        System.out.println();

        Shuffle.shuffle(newArr1);
//        System.out.println(newArr);
//        for(int i=0;i<10;i++)
//            System.out.print(newArr1[i]+" ");
//        System.out.println();
        for (int i = 0; i < n; i++) {
            arr[i] =  newArr1[i];
        }
        for(int i=0;i<10;i++)
            System.out.print(arr[i]+" ");

        Timer t = new Timer();
        mergesort(arr,temp);
        System.out.println(t.end());

        for(int i=0;i<10;i++)
            System.out.print(arr[i]+" ");


    }
}
