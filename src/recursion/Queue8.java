package recursion;

/**
 * @program: suamfa
 * @description: 解决八皇后问题
 * @author: ZhangChi
 * @create: 2019-11-19 14:20
 **/
public class Queue8 {

    // 定义一个max表示共有多少皇后
    int max = 8;
    // 定义一个数组,保存皇后防止 位置的结果
    int array[] = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        // 测试八皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法",count);
    }

    // 编写一个方法,放置第N个房后
    // check是每一次递归是,进入到check中都有for循环,因此会有回溯
    private void check(int n) {
        if (n == max) { // n = 8,相当于在放置最后一个皇后(第九个)
            // 表示前八个皇后已经放好了
            print();
            return;
        }
        // 依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇(n)放到该行的第一列
            array[n] = i;
            // 判断当放置第N个皇后到i列时,是否冲突
            if (judge(n)) {
                // 不冲突
                // 接着放N+1个皇后,即开始递归
                check(n + 1);
            }
            // 如果冲突,就继续执行array[n] = i 即将第N个皇后,放置在本行的后移一个位置
        }
    }


    // 查看当我们放置第N个皇后,就去检测该皇后是否和前面已经放置的皇后冲突

    /**
     * @param n 放置的第N个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n]说明在同一列,判断第N个皇后是否和前面的N-1个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第N个皇后是否和第I个皇后是否在同一斜线
            // 没有必要判断是否在同一行,因为每次N都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }

        }
        return true;
    }

    // 将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
