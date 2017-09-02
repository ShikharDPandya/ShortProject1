/**
 * Created by mukku on 8/28/2017.
 */
package cs6301.g40;

public class InsertionSort {
    static<T extends Comparable<? super T>> void nSquareSort(T[] arr){
        for(int i=1; i<arr.length; i++){
            int k=i;
            for(int j=i-1; j>-1;j--){
                if(arr[k].compareTo(arr[j])<0){
                    T temp = arr[k];
                    arr[k] = arr[j];
                    arr[j]=temp;
                    k=j;
                }
            }
        }
    }


    public static void main(String [] args){
        int n =20;
      Integer [] inums = new Integer[n];
        for(int i=0; i<n; i++) {
            inums[i] = new Integer(i);
        }

        for(int i=0;i<20;i++)
            System.out.print(inums[i]+" ");

        System.out.println();
        Shuffle.shuffle(inums);

        for(int i=0;i<20;i++)
            System.out.print(inums[i]+" ");

        System.out.println();
        Timer t = new Timer();
        nSquareSort(inums);
        System.out.println(t.end());

        for(int i=0;i<20;i++)
            System.out.print(inums[i]+" ");
    }
}
