package maysjl.com.cn.handwrittencode;

/**
 * @program: netty-demo
 * @description: 手写一个bitmap https://www.yuque.com/stao0lin/aze9xt/af3e2few5vwlgrny
 * @author: May's_JL
 * @create: 2025-11-08 23:59
 **/
public class Bitmap {
    private byte[] bits;
    private int size;

    //构造函数，指定位图（比特位数量）
    public Bitmap(int size) {
        this.size = size;
        //todo 为什么是数组长度要这么计算
        this.bits = new byte[(size + 7) /8];
    }

    //计算某一位为1
    public void set(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        bits[index/8] |= (1 << (index % 8));
    }

    // 清除某一位，将其设置为0
    public void clear (int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        bits[index/8] &= ~(1 << (index % 8));
    }

    // 检查某一位是否为1
    public boolean get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (bits[index/8] & (1 << (index % 8))) != 0;
    }

    //获取位图的大小（比特位数量）
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(16);

        bitmap.set(3);
        bitmap.set(7);

        System.out.println(bitmap.get(3));
        System.out.println(bitmap.get(7));
        System.out.println(bitmap.get(4));

        bitmap.clear(3);
        System.out.println(bitmap.get(3));
    }
}
