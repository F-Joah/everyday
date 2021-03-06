package com.neo.data.N20200403;

import java.util.Scanner;
/**
 * 环形队列
 * @author Joah
 * @time 2020/4/3 15:25
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        /**
         * 创建一个队列
         *  这里设置的 arrMaxSize = 4 ，可是，最大空间是 3
         */
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop)
        {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("---------------------------------------------------------------------------------------");
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    arrayQueue.showQueue();;
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头部数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出....");
    }
}

/**
 * 环形队列
 */
class CircleArrayQueue
{
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头
     * front 的初始值 = 0
     */
    private int front;

    /**
     * 队列尾
     * rear 的初始值 = 0
     */
    private int rear;

    /**
     * 模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     * @param arrMaxSize
     */
    public CircleArrayQueue(int arrMaxSize)
    {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull()
    {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty()
    {
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n)
    {
        // 1、首先判断队列是否已满
        if ( isFull())
        {
            System.out.println("队列已满，不能添加数据...");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将 rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队列
     */
    public int getQueue()
    {
        // 1、判断队列是否为空
        if (isEmpty())
        {
            System.out.println("队列为空，不能取出数据...");
            throw new RuntimeException("队列为空，不能取出数据...");
        }
        // 分析 front 是指向队列的第一个元素
        // 1、先把 front 对应的值，保存到一个临时变量
        int value = arr[front];
        // 2、将 front 后移
        front = (front + 1) % maxSize;
        // 3、将临时保存的变量返回
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue()
    {
        // 1、判断是否为空
        if (isEmpty())
        {
            System.out.println("队列为空，不能遍历...");
            return;
        }
        // 2、从 front 开始遍历，遍历多少个元素

        for (int i = front; i < front + size(); i++)
        {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出当前有效数据的个数
     */
    public int size()
    {
        return (rear + maxSize - front) % maxSize;
    }


    /**显示队列的头数据，不是取出数据*/
    public int headQueue()
    {
        if ( isEmpty())
        {
            System.out.println("空空空...");
            throw new RuntimeException("空空空...");
        }
        return arr[front];
    }

}
