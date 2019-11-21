package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: suamfa
 * @description: 希尔排序
 * @author: ZhangChi
 * @create: 2019-11-21 09:00
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个0-80000数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr1 = simpleDateFormat.format(date1);
        System.out.println("前时间" + formatStr1);
        shellSort2(arr);
        Date date2 = new Date();
        String formatStr2 = simpleDateFormat.format(date2);
        System.out.println("后时间" + formatStr2);
        //System.out.println("排序后: " + Arrays.toString(arr));
    }

    /**
     * 使用交换法进行排序
     */
    static void shellSort(int[] arr) {
        // 希尔排序第一轮排序
        // 因为第一轮排序是将是个数据分成五组,
        // 根据分析,使用循环处理
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共有五组,每组有两个元素),步长为5
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素,说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println(Arrays.toString(arr));
        }

    }

    // 对交换式的希尔排序进行优化 -> 移位法
    static void shellSort2(int[] arr) {
        // 增量,并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素开始,逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i; // 待插入位置的下标
                int temp = arr[j]; // 记录待插入的数
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出whild后,就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }
}
