package maysjl.com.cn.handwrittencode;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-09 14:20
 **/
public class SimpleQueue<T> {
    private final T[] data;
    private int head;
    private int tail;
    private int size;

    public SimpleQueue(int capacity){
        this.data = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    //入队操作
    public synchronized void enqueue (T item){
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public synchronized T dequeue() {
        if (size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        T item = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size --;
        return item;
    }

    //查看队首元素但不移除
    public synchronized  T peek(){
        if (size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        return data[head];
    }


    //判断队列是否为空
    public synchronized boolean isEmpty(){
        return  size == 0;
    }

    //判断队列是否已满
    public synchronized boolean isFull(){
        return size == data.length;
    }

    public synchronized int size(){
        return size;
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>(5);

        //测试入队操作
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);


        // 测试队列满的情况
        System.out.println("Queue is full:" + queue.isFull());

        //测试出队操作
        System.out.println("Dequeue: "+ queue.dequeue());
        System.out.println("Dequeue: "+ queue.dequeue());

        //测试队列状态
        System.out.println("Queue size: "+ queue.size());

        //测试再次入队
        queue.enqueue(6);
        System.out.println("Dequeue: "+ queue.dequeue());
        System.out.println("Dequeue: "+ queue.dequeue());
        System.out.println("Dequeue: "+ queue.dequeue());
        System.out.println("Dequeue: "+ queue.dequeue());

        //队列应该为空
        System.out.println("Queue is empty: "+ queue.isEmpty());
    }
}
