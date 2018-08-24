package com.chenzhuo.dao;

import com.chenzhuo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * User: cz
 * Date: 2017/12/27
 * Time: 10:43
 */
public interface UserDao {

    User findUserName(@Param("userName") String userName);
}
