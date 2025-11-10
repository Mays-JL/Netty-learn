package maysjl.com.cn.nettydemo;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-06 11:11
 **/
public class ApiTest {

    public static void main(String[] args) throws IOException {
        test("C:\\Users\\fuzhengwei\\Desktop\\测试传输文件1.txt");
        test("C:\\Users\\fuzhengwei\\Desktop\\netty-file.zip");
    }
    /**
     * 读取文件与notepad++ 比对
     *
     * @param fileUrl
     * @throws IOException
     */
    private static void test(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.seek(0);

        byte[] bytes = new byte[1024];
        int byteRead = randomAccessFile.read(bytes);

        System.out.println(fileUrl);
        System.out.println("读取文件长度：" + byteRead);
        for (byte b : bytes) {
            System.out.print(new BigInteger(1, new byte[]{b}).toString(16) + " ");
        }
        System.out.println("\r\n");
    }
}
