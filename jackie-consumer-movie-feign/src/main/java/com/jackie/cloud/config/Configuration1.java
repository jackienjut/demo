package com.jackie.cloud.config;


import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/29 0029.
 */

@Configuration
public class Configuration1 {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
