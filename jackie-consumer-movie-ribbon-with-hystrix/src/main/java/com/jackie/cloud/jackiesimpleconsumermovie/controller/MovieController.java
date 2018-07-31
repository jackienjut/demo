package com.jackie.cloud.jackiesimpleconsumermovie.controller;

import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFailBack")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://jackie-provider-user/simple/" + id, User.class);
    }

    public User findByIdFailBack(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }


    @GetMapping("/test")
    public String test() {
        return "test";
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

    @GetMapping("/ltest")
    public String test1() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("jackie-provider-user");
        System.out.println("111: " + serviceInstance.getHost() + ":" + serviceInstance.getPort() + ":" + serviceInstance.getServiceId());

        ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("jackie-provider-user2");
        System.out.println("222: " + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId());
        return "1";
    }
}
