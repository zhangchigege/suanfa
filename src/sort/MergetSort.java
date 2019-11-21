package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: suamfa
 * @description: 归并排序
 * @author: ZhangChi
 * @create: 2019-11-21 13:39
 **/
public class MergetSort {
    public static void main(String[] args) {
        /*int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));*/

        int[] arr = new int[80000000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个0-80000数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr1 = simpleDateFormat.format(date1);
        System.out.println("前时间" + formatStr1);
        mergeSort(arr, 0, arr.length-1, temp);
        Date date2 = new Date();
        String formatStr2 = simpleDateFormat.format(date2);
        System.out.println("后时间" + formatStr2);


    }

    static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; // 中间索引
            // 向左递归继续分
            mergeSort(arr, left, mid, temp);
            // 向右递归继续分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     * @param arr   待排序数组
     * @param left  左边有序序列的初始索引
     * @param right 右边有序序列的初始索引
     * @param mid   中间索引
     * @param temp  中转数组
     */
    static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left; // 初始化 i ,代表左边有序序列的初始索引
        int j = mid + 1; // 代表右边有序序列的初始索引
        int t = 0; // 执指向 temp 数组的当前索引
        // 先把左右两边(已经有序)的数据按照规则填充到temp数组,直到左右两边的有序序列有一边处理完毕为止
        while (i <= mid && j <= right) {
            // 如果左边的有序序列的当前元素,小于等于右边有序序列的当前元素
            // 将左边的当前元素,填充到temp数组
            // 然后将两边数组的索引依次后移
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else { // 反之,将右边有序序列的当前元素,填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // 将有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) { // 左边的有序序列有剩余的元素
            // 全部填充到 temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) { // 右边的有序序列有剩余的元素
            // 全部填充到 temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // 将 temp 数组重新拷贝到 arr
        // 并不是每次都拷贝所有数据
        t = 0;
        int tempLeft = left; //
        while (tempLeft <= right) { // 第一次合并时,tempLeft=0,right=1
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
