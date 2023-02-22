package HvLLAssignment;

import java.util.Arrays;

public class Q1_ArraySum {
    public static void main(String[] args) {
        int[] arr = {25,35,12,4,36,48};
        for (int i = 1; i <arr.length ; i++) {
            arr[i]=arr[i]+arr[i-1];

        }
        System.out.println(Arrays.toString(arr));
    }
}
