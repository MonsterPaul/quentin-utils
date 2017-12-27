package com.demo.quentin.utils;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auth Created by 杨国群
 * @Date Created in 13:26 2017/11/13
 * @Version 1.0
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        //请求地址
        String url = "http://localhost:8083/ane-job/100411.bizservice";
        //请求头
        Map<String, String> headerMap = new HashMap();
        headerMap.put("accept","*/*");
        headerMap.put("connection","keep-alive");//长连接

        //请求参数
        Map<String, String> paramMap = new HashMap();
        String params = "{\"siteCodes\":\"\",\"volumeStartDate\":\"2017-12-13\",\"volumeEndDate\":\"2017-12-14 11:00:00\"}";
        String digest = Base64.encodeBase64String(DigestUtils.md5Hex(params  + "ane"+ "123456").getBytes());
        String timestamp = "" + new Date().getTime();
        paramMap.put("params",params);
        paramMap.put("digest",digest);
        paramMap.put("timestamp",timestamp);

        //缓存
        CacheControl cacheControl = null;
        //回调
        Callback callback = new Callback() {
            public void onFailure(Call call, IOException e) {
                logger.error("Error:失败了",e);
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        };

        HttpUtils.getInstance().asyncPostFormRequest(url,headerMap,paramMap,cacheControl,callback,"");
    }


}
