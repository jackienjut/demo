package com.jackie.cloud.jackiediscoveryeurekar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaHAApplication {


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[ ] args){
        SpringApplication.run(EurekaHAApplication.class ,args);
    }
}
