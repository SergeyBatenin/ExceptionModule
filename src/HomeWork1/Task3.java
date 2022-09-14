package HomeWork1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 3};
        int[] arr3 = {5, 1};

        System.out.println(Arrays.toString(subArrays(arr3, arr2)));
        System.out.println(Arrays.toString(subArrays(arr1, arr2)));
    }

    public static int[] subArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Размеры массивов неравны");
        } else {
            int[] result = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
            return result;
        }
    }
}
