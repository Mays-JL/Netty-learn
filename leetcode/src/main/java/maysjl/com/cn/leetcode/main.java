package maysjl.com.cn.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-09 22:46
 **/
public class main {
    public static void main(String[] args) {

    }

    public int findRepeatDocument(int[] documents) {
        Arrays.sort(documents);
        for (int i = 0 ; i < documents.length - 1; i ++ ){
            if (documents[i] == documents[i+ 1]){
                return documents[i];
            }
        }
        return  -1;
    }

}
