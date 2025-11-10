package maysjl.com.cn.leetcode;

import java.util.Arrays;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-09 22:46
 **/
public class main {
    public static void main(String[] args) {
        int num1 =5;
        int num2 =4;
        System.out.println(countOperations(num1,num2));
    }

    public static int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0){
            return 0;
        }
        if (num1 > num2 ){
            return 1+countOperations(num2,num1 - num2);
        }else {
            return 1+countOperations(num1,num2-num1);
        }
    }

}
