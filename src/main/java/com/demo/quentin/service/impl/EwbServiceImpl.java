package com.demo.quentin.service.impl;

import com.demo.quentin.domain.OptEwbVO;
import com.demo.quentin.domain.mapper.OptEwbVOMapper;
import com.demo.quentin.service.IEwbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 10:46 2017/12/27
 * @Version 1.0
 */
@Service
public class EwbServiceImpl implements IEwbService {
    @Autowired
    private OptEwbVOMapper optEwbVOMapper;

    public OptEwbVO selectEwbByEwbNo(String ewbNo) {
        return optEwbVOMapper.selectByEwbNo(ewbNo);
    }
}
