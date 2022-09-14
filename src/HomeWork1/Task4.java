package HomeWork1;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 3};
        int[] arr3 = {5, 1};
        int[] arr4 = {5, 0};

        System.out.println(Arrays.toString(divArrays(arr3, arr2)));
        //System.out.println(Arrays.toString(divArrays(arr1, arr2)));
        System.out.println(Arrays.toString(divArrays(arr3, arr4)));
    }

    public static int[] divArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Размеры массивов неравны");
        } else {
            int[] result = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                try {
                    result[i] = arr1[i] / arr2[i];
                } catch (RuntimeException e) {
                    throw new RuntimeException("Произошло деление на 0");
                }
            }
            return result;
        }
    }
}
