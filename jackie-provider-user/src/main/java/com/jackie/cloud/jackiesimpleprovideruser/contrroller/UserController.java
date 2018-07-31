package com.jackie.cloud.jackiesimpleprovideruser.contrroller;

import com.jackie.cloud.jackiesimpleprovideruser.dao.UserReposity;
import com.jackie.cloud.jackiesimpleprovideruser.enity.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
@RestController
public class UserController {

    @Autowired
    private UserReposity userReposity;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return this.userReposity.findOne(id);
    }


    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("JACKIE-PROVIDER-USER", false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance instanceInfo = this.discoveryClient.getLocalServiceInstance();
        return instanceInfo;
    }
}
