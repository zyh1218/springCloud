package cn.demo.service1.client.fallback.factory;

import cn.demo.service1.client.Service0Client;
import cn.demo.service1.controller.Service1Controller;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zhangyh
 * @CreateTime: 2017年06月20日09:47:51
 * @Description:
 */
@Component
public class Service0FallbackFactory implements FallbackFactory<Service0Client> {

    @Override
    public Service0Client create(final Throwable cause) {
        System.out.println("create:" + cause);
        return new Service0Client() {
            @Override
            public String test(@PathVariable("userId") String userId, @PathVariable("sleepSec") int sleepSec) {
                return "create fallback:" + userId + "," + sleepSec;
            }

            @Override
            public String user(Service1Controller.User user) {
                return "create fallback:" + user.toString();
            }
        };
    }
}
