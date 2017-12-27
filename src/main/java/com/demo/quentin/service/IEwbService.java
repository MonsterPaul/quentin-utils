package com.demo.quentin.service;

import com.demo.quentin.domain.OptEwbVO;
import com.demo.quentin.db.DataSource;
import com.demo.quentin.db.DataSourceEnum;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 10:46 2017/12/27
 * @Version 1.0
 */
@DataSource(name = DataSourceEnum.lbdb)
public interface IEwbService {

    /**
     * 根据运单号获取运单信息
     * @Author: guoqun.yang
     * @Date:   2017/12/27 10:46
     * @param   ewbNo
     * @version 1.0
     */
    OptEwbVO selectEwbByEwbNo(String ewbNo);
}
