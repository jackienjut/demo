package com.jackie.cloud.jackiesimpleprovideruser.dao;

import com.jackie.cloud.jackiesimpleprovideruser.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/7/19 0019.
 */
@Repository
public interface UserReposity extends JpaRepository<User ,Long> {
}
