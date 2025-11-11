package maysjl.com.cn.nettydemo.web;

import maysjl.com.cn.nettydemo.server.NettyServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: netty-demo
 * @description:
 * @author: May's_JL
 * @create: 2025-11-11 10:43
 **/
@Controller
public class NettyController {
    @Resource
    private NettyServer nettyServer;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name", "xiaohao");
        return "index";
    }
}
