package maysjl.com.cn.nettydemo.domain;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-10 17:43
 **/
public class Constants {

    //Constants.FileStatus {0开始、1中间、2结尾、3完成}
    public static class FileStatus {
        public static int BEGIN = 0;
        public static int CENTER = 1;
        public static int END = 2;
        public static int COMPLETE = 3;
    }


    // 0传输文件‘请求’、1文件传输‘指令‘、2文件传输’数据‘
    public static class TransferType {
        public static int REQUEST = 0;
        public static int INSTRUCT = 1;
        public static int DATA = 2;
    }
}
