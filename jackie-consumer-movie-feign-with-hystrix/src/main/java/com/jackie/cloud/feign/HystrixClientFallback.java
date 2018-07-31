package com.jackie.cloud.feign;

import com.jackie.cloud.jackiesimpleconsumermovie.entity.User;
import feign.Param;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
public class HystrixClientFallback implements UserFeignClient  {
    @Override
    public User findById(@Param("id") Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
