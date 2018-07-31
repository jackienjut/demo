package com.jackie.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {


    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
