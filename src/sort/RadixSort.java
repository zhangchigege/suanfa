package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @program: suamfa
 * @description: 桶排序
 * @author: ZhangChi
 * @create: 2019-11-27 08:38
 **/
public class RadixSort {

    public static void main(String[] args) {
       /* int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);*/

        int[] arr = new int[800000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个0-80000数
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatStr1 = simpleDateFormat.format(date1);
        System.out.println("前时间" + formatStr1);
        radixSort(arr);
        Date date2 = new Date();
        String formatStr2 = simpleDateFormat.format(date2);
        System.out.println("后时间" + formatStr2);
    }

    static void radixSort(int[] arr) {
        // 获取数组中最大数的位数
        int max = arr[0]; // 假设
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 获取最大数是几位数
        int maxLength = (max + "").length();
        // 第一轮排序
        // 针对每个元素的个位进行排序
        // 定义一个二维数组,表示10个桶,每个桶就是一个一维数组
        // 1.二维数组包含一维数组
        // 2.为了防止在放入数的时候数据溢出,每个一维数组的(桶)的大小为arr.length
        // 3.基数排序是使用空间换时间算法
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中实际存放了多少个数据,定义一个一维数组记录各个桶每次放入数据的个数
        // bucketElementCounts[0]记录的就是bucket[0]桶的每次放入的数据的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的对应位的数
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序(一维数组的小标依次取出数据,放入原来的数组)
            int index = 0;
            // 遍历每一个桶,并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中存在数据,才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶(k:一维数组),放入数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第一轮处理后,需要将每个bucketElementCounts[k]归零
                bucketElementCounts[k] = 0;
            }
        }
    }

}
