package search;

import com.sun.org.apache.regexp.internal.REUtil;
import sun.net.www.http.Hurryable;

import java.util.Arrays;

/**
 * @program: suamfa
 * @description: 斐波那契数列查找(黄金分割)
 * @author: ZhangChi
 * @create: 2019-11-28 09:38
 **/

public class FibonacciSearch {

    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 12345));
    }

    // 需要使用到斐波那契数列,先获取到一个斐波那契数列
    // 使用非递归的方式获取
    static int[] fib() {
        // 创建
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    // 非递归斐波那契查找算法

    /**
     * @param arr
     * @param key 查找的值
     * @return 返回对应下标, 如果没有返回-1
     */
    static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int mid = 0; // 存放mid值
        int f[] = fib(); // 获取斐波那契数列
        // 获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k]可能大于数组的长度,因此需要使用Arrays构造一个新的数组指向a[]
        // 不足的部分使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 需要使用arr数组的最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 使用while循环处理,找到我们的数key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) { // 向数组的前面查找
                high = mid - 1;
                // 1.全部元素 = 前面的元素 + 后面元素
                // 2.f[k] = f[k-1]+f[k-2]
                // 3.因为前面有f[k-1]个元素,可以继续拆分f[k-1] = f[k-2] + f[k-3]
                // 即在f[k-1] 的前面继续查找 k--
                // 下次循环 mid = f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) { // 向数组的右面查找
                low = mid + 1;
                // 1.全部元素 = 前面的元素 + 后面元素
                // 2.f[k] = f[k-1]+f[k-2]
                // 3.因为后面我们有 f[k-2]个元素,所以可以继续拆分f[k-1] = f[k-3] + f[k-4]
                // 4.即再f[k-2]的前面可以急促进行查找 k-=2
                // 下次循环 mid = f[k-1-2]-1
                k -= 2;
            } else { // 找到了
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
