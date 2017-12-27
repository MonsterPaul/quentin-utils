package com.demo.quentin.service;

import com.demo.quentin.domain.User;
import com.demo.quentin.db.DataSource;
import com.demo.quentin.db.DataSourceEnum;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 14:32 2017/12/19
 * @Version 1.0
 */
@DataSource(name= DataSourceEnum.predb)
public interface IUserService {
    User queryUserById(Integer id);
}
