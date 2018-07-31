package com.jackie.cloud.jackiesimpleconsumermovie.controller;

import com.jackie.cloud.jackiesimpleconsumermovie.UserFeignClient;
import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/test")
    public User test(User user) {
        return userFeignClient.addUser(user);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("JACKIE-CONSUMER-MOVIE", false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance serviceInstance = this.discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }
}
