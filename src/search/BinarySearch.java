package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: suamfa
 * @description: 二分查找, 数组必须有序
 * @author: ZhangChi
 * @create: 2019-11-27 09:56
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 100, 100, 100, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 88);
        // System.out.println(index);
        List<Integer> binarySearch2 = binarySearch2(arr, 0, arr.length - 1, 88);
        System.out.println(binarySearch2);
    }

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找的值
     * @return 如果找到返回小标, 没有找到返回-1
     */
    static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 当left > right时,说明没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    // 查找出相同的数值
    // 再找到mid值时,不要马上返回,向mid索引值的左边扫描,将所有满组查找值的元素的下标加入到一个集合中ArrayList
    // 向mid索引值的右边扫描,同上步
    // 返回集合
    static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        // 当left > right时,说明没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> list = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                // 否则就把temp放入到集合中
                list.add(temp);
                temp -= 1;
            }
            list.add(mid); // 放入中间值
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                // 否则就把temp放入到集合中
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }
}
