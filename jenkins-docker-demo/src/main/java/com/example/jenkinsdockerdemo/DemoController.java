package com.example.jenkinsdockerdemo;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("jenkins-docker-demo")
public class DemoController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("test1")
    public String test1() {
        return "test1";
    }

    /**
     * 测试本地redis
     */
    @GetMapping("test2")
    public String test2() {
        redisTemplate.opsForValue().set("test2", String.valueOf((int) (Math.random() * 100)));
        return redisTemplate.opsForValue().get("test2");
    }

    /**
     * 测试优雅关机1 - 子线程(经过测试会立即关机)
     */
    @GetMapping("test3/{num}")
    public String test3(@PathVariable Integer num) {
        new Thread(() -> {
            try {
                log.info("{} 准备 sleep {}", Thread.currentThread().getName(), num);
                for (int i = 0; i < num; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    log.info("{} sleep {}", Thread.currentThread().getName(), i);
                }
                log.info("{} 完成 sleep", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return "ok";
    }


    /**
     * 测试优雅关机2 - 主线程
     */
    @GetMapping("test4/{num}")
    public String test4(@PathVariable Integer num) {
        try {
            log.info("{} 准备 sleep {}", Thread.currentThread().getName(), num);
            for (int i = 0; i < num; i++) {
                TimeUnit.SECONDS.sleep(1);
                log.info("{} sleep {}", Thread.currentThread().getName(), i);
            }
            log.info("{} 完成 sleep", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
