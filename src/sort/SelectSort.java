package sort;

import java.util.Arrays;

/**
 * @program: suamfa
 * @description: 选择排序
 * @author: ZhangChi
 * @create: 2019-11-20 15:04
 **/
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1};
        selectSort(arr);

    }

    // 选择排序
    static void selectSort(int[] arr) {
        // 使用逐步推导的方式进行选择排序
        // 算法: 先简单 --> 做复杂, 可以把一个复杂的算法拆分成简答的问题,在逐步解决
        // 进行第一轮:找到最小的数
        // 在推导的过程中,已经发现了一个规律,可以使用循环进行优化
        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    // 说明假定的最小值并不是最小的
                    // 重置
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (min != i) {
                // 将最小值放在arr[0],及交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第一轮后:" + Arrays.toString(arr));
        }
    }


}
