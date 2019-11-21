package sort;/**
 * @program: suamfa
 * @description: 插入排序
 * @author: ZhangChi
 * @create: 2019-11-20 16:35
 **/

import java.util.Arrays;

/**
 * @program: suamfa
 * @description: 插入排序
 * @author: ZhangChi
 * @create: 2019-11-20 16:35
 **/
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -2, 89};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void insertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            // 定义一个待插入的数
            insertValue = arr[i];
            // 定义一个待插入数的索引
            insertIndex = i - 1; // 即arr[1]前的下标
            // 给insertValue找到插入的位置
            // 保证在给insertValue找插入位置时不越界
            // insertValue < arr[insertIndex]待插入的数还没有找到插入位置
            // 需要将insertIndex往后移动
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出循环时,说明插入的位置找到了 insertIndex+1
            // 判断是否需要变动位置
            if (insertValue + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }


}
