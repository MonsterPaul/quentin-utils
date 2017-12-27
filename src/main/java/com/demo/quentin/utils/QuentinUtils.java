package com.demo.quentin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * @Auth Created by 杨国群
 * @Date Created in 11:22 2017/11/13
 * @Version 1.0
 */
public class QuentinUtils {
    private static final Logger logger = LoggerFactory.getLogger(QuentinUtils.class);

    /**
     * 比较两个 List 的值是否相等
     *
     * @Author: 杨国群
     * @Date:   2017/11/13 11:25
     * @param   a
     * @param   b
     * @version 1.0
     */
    public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if (a.size() != b.size())
            return false;
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i)))
                return false;
        }
        return true;
    }
}
