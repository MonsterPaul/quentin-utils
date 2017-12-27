package com.demo.quentin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类，验证数据是否符合规范
 *
 * @Auth Created by 杨国群
 * @Date Created in 11:22 2017/11/13
 * @Version 1.0
 */
public class RegexUtils {

    /**
     * 判断字符串是否符合正则表达式
     *
     * @param str
     * @param regex
     * @Author: 杨国群
     * @Date: 2017/11/15 21:08
     * @version 1.0
     */
    public static boolean find(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        boolean b = m.find();
        return b;
    }

    /**
     * 判断输入的字符串是否符合Email格式
     *
     * @param email
     * @Author: 杨国群
     * @Date: 2017/11/15 21:08
     * @version 1.0
     */
    public static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(email).matches();
    }

    /**
     * 判断输入的字符串是否为纯汉字
     *
     * @param value
     * @Author: 杨国群
     * @Date: 2017/11/15 21:09
     * @version 1.0
     */
    public static boolean isChinese(String value) {
        Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
        return pattern.matcher(value).matches();
    }

    /**
     * 判断是否为浮点数，包括double和float
     *
     * @param value
     * @Author: 杨国群
     * @Date: 2017/11/15 21:09
     * @version 1.0
     */
    public static boolean isDouble(String value) {
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
        return pattern.matcher(value).matches();
    }

    /**
     * 判断是否为整数
     *
     * @param value
     * @Author: 杨国群
     * @Date: 2017/11/15 21:10
     * @version 1.0
     */
    public static boolean isInteger(String value) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(value).matches();
    }
}
