package queue;

import java.util.Scanner;

/**
 * @program: suamfa
 * @description: 环形队列
 * @author: ZhangChi
 * @create: 2019-11-15 09:44
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建队列
        ClrcleArray a = new ClrcleArray(3);
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

class ClrcleArray {
    private int maxSize; // 最大容量
    private int front; // 头指针
    private int rear; // 尾指针
    private int[] arr; // 该数组用于存放数据,模拟队列

    public ClrcleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    boolean isEmpty() {
        return rear == front;
    }

    // 添加数据
    void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        // 添加数据
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取数据
    int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列所有数据
    void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 获取当前队列有效数据个数
    int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列头数据
    int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
