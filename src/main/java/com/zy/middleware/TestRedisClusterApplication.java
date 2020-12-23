
package com.zy.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRedisClusterApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(TestRedisClusterApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
