package queue;

import java.util.Scanner;

/**
 * @program: suamfa
 * @description: 使用数组模拟队列
 * @author: ZhangChi
 * @create: 2019-11-14 16:20
 **/
public class ArrayQueue {

    public static void main(String[] args) {
        // 创建队列
        ArrayQueuePojo a = new ArrayQueuePojo(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(heaf): 查看头部数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    a.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.exit(0);
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    a.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = a.getQueue();
                        System.out.println("取出的数据:" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = a.headQueue();
                        System.out.println("队列头的数据是:" + headQueue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
            }
        }
    }
}

class ArrayQueuePojo {
    private int maxSize; // 最大容量
    private int front; // 头指针
    private int rear; // 尾指针
    private int[] arr; // 该数组用于存放数据,模拟队列

    public ArrayQueuePojo(int maxSize, int front, int rear, int[] arr) {
        this.maxSize = maxSize;
        this.front = front;
        this.rear = rear;
        this.arr = arr;
    }

    // 创建队列的构造器
    public ArrayQueuePojo(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头,分析出是指向队列头的前一个位置
        rear = -1; // 指向队列尾部的数据(就是队列的最后一个数据)
    }

    // 判断队列是否已满
    boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断对了是否为空
    boolean isEmpty() {
        return rear == front;
    }

    void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满,不能添加数据");
            return;
        }
        rear++;  // 让rear后移
        arr[rear] = n;
    }

    // 出列
    int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++; // 后移
        return arr[front];
    }

    // 显示队列的所有数据
    void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据, 不是取出数据
    int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}
