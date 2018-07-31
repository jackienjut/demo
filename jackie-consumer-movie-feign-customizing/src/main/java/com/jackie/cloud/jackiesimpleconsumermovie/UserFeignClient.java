package com.jackie.cloud.jackiesimpleconsumermovie;

import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
@FeignClient("jackie-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}")
    public User findById(@PathVariable("id") Long id);


    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public User addUser(@RequestBody User user) ;
}
