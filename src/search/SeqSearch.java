package search;

/**
 * @program: suamfa
 * @description: 线性查找
 * @author: ZhangChi
 * @create: 2019-11-27 09:45
 **/
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int i = seqSearch(arr, 11);
        if (i == -1) {
            System.out.println("没有找到");
        }
    }

    /**
     * 实现的线性查找找到一个满足条件的就返回
     *
     * @param arr
     * @param value
     * @return
     */
    static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
