package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: suamfa
 * @description: 冒泡排序
 * @author: ZhangChi
 * @create: 2019-11-20 14:08
 **/
public class BubbleSort {

    public static void main(String[] args) {
        //int arr[] = {3, 9, -1, 10, -2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个0-80000数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr1 = simpleDateFormat.format(date1);
        System.out.println("前时间" + formatStr1);
        bubbleSort(arr);
        Date date2 = new Date();
        String formatStr2 = simpleDateFormat.format(date2);
        System.out.println("前时间" + formatStr2);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

    // 将前面的冒泡封装成一个方法
    static void bubbleSort(int[] arr) {
        int temp = 0; // 临时变量,交换用
        boolean flag = false; // 表示变量,表示是否进行过交换
        // 时间复杂度O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            // 为了容易理解,把冒泡排序的过程进行展示
            // 第一趟排序,就是将最大的数排到最后
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 判断连个数
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                // 在一趟排序中一次交换都没有发生
                break;
            } else {
                flag = false; // 重置flag,进行下次判断
            }
            // System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序
     *
     * @param a -- 待排序的数组
     * @param n -- 数组的长度
     */
    static void bubbleSort1(int[] a, int n) {
        int i, j;
        for (i = n - 1; i > 0; i--) {
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {

                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序 (改进版)
     *
     * @param a -- 待排序的数组
     * @param n -- 数组的长度
     */
    static void bubbleSort2(int[] a, int n) {
        int i, j;
        int flag;                 // 标记
        for (i = n - 1; i > 0; i--) {
            flag = 0;            // 初始化标记为0
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // 交换a[j]和a[j+1]
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;

                    flag = 1;    // 若发生交换，则设标记为1
                }
            }
            if (flag == 0) {
                break;            // 若没发生交换，则说明数列已有序。
            }
        }
    }

    static void bubbleSort3(int[] a, int n) {
        int temp; // 作为第三位交换数
        int low = 0; // 低位数
        int hignt = n - 1;// 高位数
        while (low < hignt) {
            // 双向遍历比较
            // 从低位开始比较
            for (int i = low; i < hignt; ++i) { // 正向冒泡,确定最大值
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            --hignt;
            // 从高位开始
            for (int j = hignt; j > low; --j) { // 反向冒泡,确定最小值
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            ++low;
        }
    }

    /**
     * 冒泡排序
     *
     * @param a -- 待排序的数组
     * @param n -- 数组的长度
     */
    static void bubbleSort4(int[] a, int n) {
        int temp;//交换数位
        int endPoit = n - 1; //代表最后一个需要比较的元素的下标
        while (endPoit > 0) {
            int pos = 1;
            for (int i = 1; i <= endPoit; i++) {
                if (a[i - 1] > a[i]) {
                    temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    pos = i; //下标元素位i的元素与下标位i-1的元素发生了数据交换
                }
            }
            endPoit = pos - 1;//下一轮排序时只对下标小于pos的元素排序
        }
    }

}
