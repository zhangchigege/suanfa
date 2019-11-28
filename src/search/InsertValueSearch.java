package search;

/**
 * @program: suamfa
 * @description: 插值查找算法
 * @author: ZhangChi
 * @create: 2019-11-28 08:56
 **/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int search = insertValueSearch(arr, 0, arr.length - 1, 10);
        System.out.println(search);
    }

    /**
     * 插值算法要求数据有序
     *
     * @param arr     传入的数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 查找的值
     * @return 找到返回对应的索引, 找不到就返回-1
     */
    static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归查找
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
