package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: suamfa
 * @description: 快速排序
 * @author: ZhangChi
 * @create: 2019-11-21 10:43
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个0-80000数
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr1 = simpleDateFormat.format(date1);
        System.out.println("前时间" + formatStr1);
        quickSort(arr, 0, arr.length - 1);
        Date date2 = new Date();
        String formatStr2 = simpleDateFormat.format(date2);
        System.out.println("后时间" + formatStr2);
    }

    static void quickSort(int[] arr, int left, int right) {
        int l = left; // 左下标
        int r = right;// 右下标
        //  中间值
        int pivot = arr[(l + r) / 2];
        int temp = 0; // 临时变量,交换时使用
        // while循环的目的是让比pivot值小的值放到左边, 比其大的放到右边
        while (l < r) {
            // 在pivot左边一直找,找到大于或者等于pivot的值
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot右边一直找,找到小于或者等于pivot的值
            while (arr[r] > pivot) {
                r -= 1;
            }
            // 如果 l >= r 说明pivot的左右两边的值,已经按照左边全部是小于等于pivot的值,右边相反
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果交换完后,发现 arr[l] == pivot 的值,r--,前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            // 如果交换完后,发现 arr[] == pivot 的值,l++,前移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l == r , 必须让 l++,r--,否则会出栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
