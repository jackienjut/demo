package com.jackie.cloud.feign;

import com.jackie.cloud.config.Configuration1;
import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
@FeignClient(value = "jackie-provider-user" ,configuration = Configuration1.class)
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}" , method = RequestMethod.GET)
    public User findById(@Param("id") Long id);
}
