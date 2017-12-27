package com.demo.quentin.service.impl;

import com.demo.quentin.domain.User;
import com.demo.quentin.domain.mapper.UserMapper;
import com.demo.quentin.service.IUserService;
import com.demo.quentin.db.DataSource;
import com.demo.quentin.db.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 14:33 2017/12/19
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @DataSource(name = DataSourceEnum.predb)
    public User queryUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
