package com.jackie.cloud.jackiesimpleconsumermovie.controller;

import com.jackie.cloud.feign.UserFeignClient;
import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23 0023.
 */
@RestController
public class MovieController {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }


}
