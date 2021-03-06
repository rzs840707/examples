package com.youthlin.example.rpc.provider.service;

import com.youthlin.example.rpc.api.IHelloService;
import com.youthlin.example.rpc.bean.User;
import com.youthlin.rpc.annotation.Rpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 创建: youthlin.chen
 * 时间: 2017-11-26 22:21
 */
@Rpc
public class HelloService implements IHelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "(" + name.length() + ")";
    }

    @Override
    public void save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user == null");
        }
        LOGGER.info("SAVE");
        USERS.add(user);
    }

    @Override
    public List<User> findAll() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
        return Collections.unmodifiableList(USERS);
    }

    @Override
    public void clear() {
        USERS.clear();
    }

    public void aLongTimeMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
