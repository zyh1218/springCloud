package cn.demo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangyh
 * @CreateTime: 2017年06月20日09:47:51
 * @Description:统一异常处理, 将controller继承该类, 即可
 */
public abstract class AbstractController {


    @ExceptionHandler({Exception.class})
    public Map<String, String> exceptionHandler(Exception e, WebRequest req) {
        System.err.println("=================");
        System.err.println(req.toString());
        System.err.println(req.getRemoteUser());
        System.err.println(req.getContextPath());
        System.err.println("=============");
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "0");
        map.put("msg", e.getMessage());
        return map;
    }
}
