package maysjl.com.cn.springdemo.bean;

import java.sql.SQLOutput;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-12 11:33
 **/
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息： "+ userDao.queryUserName(uId));
    }
}
