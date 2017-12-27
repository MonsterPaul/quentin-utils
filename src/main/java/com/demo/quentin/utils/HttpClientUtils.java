package com.demo.quentin.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 14:24 2017/12/27
 * @Version 1.0
 */
public class HttpClientUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    //默认采用的http协议的HttpClient对象
    private static HttpClient client;

    //不可实例化
    private HttpClientUtils() {
        initHttpClient();
    }

    void initHttpClient() {
        client = HCB.getInstance().build();
    }

    public static HttpClientUtils getInstance() {
        return HttpClientUtilsHelper.httpClientUtils;
    }

    public static class HttpClientUtilsHelper{
        private static HttpClientUtils httpClientUtils = new HttpClientUtils();
    }

    /**
     * 以Post方式，请求资源或服务
     *
     * @param config 请求参数配置
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:46
     * @version 1.0
     */
    public static String post(HttpConfig config) {
        config.method("POST");
        return send(config);
    }

    /**
     * 请求资源或服务
     *
     * @param config 请求参数配置
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:42
     * @version 1.0
     */
    public static String send(HttpConfig config) {
        return fmt2String(execute(config), config.outenc());
    }

    /**
     * 转化为字符串
     *
     * @param resp     响应对象
     * @param encoding 编码
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:40
     * @version 1.0
     */
    private static String fmt2String(HttpResponse resp, String encoding) {
        String body = "";
        try {
            if (resp.getEntity() != null) {
                // 按指定编码转换结果实体为String类型
                body = EntityUtils.toString(resp.getEntity(), encoding);
                logger.info(body);
            } else {//有可能是head请求
                body = resp.getStatusLine().toString();
            }
            EntityUtils.consume(resp.getEntity());
        } catch (Exception e) {
            logger.error("HttpClientUtils.fmt2String转化字符串异常：", e);
        } finally {
            close(resp);
        }
        return body;
    }


    /**
     * 请求资源或服务
     *
     * @param config 请求参数配置，返回HttpResponse对象
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:40
     * @version 1.0
     */
    private static HttpResponse execute(HttpConfig config) {
        config.client(client);//获取链接
        HttpResponse resp = null;
        try {
            //创建请求对象
            HttpRequestBase request = new HttpPost(config.urls());
            //设置header信息
            request.setHeaders(config.headers());

            //判断是否支持设置entity(仅HttpPost、HttpPut、HttpPatch支持)
            if (HttpEntityEnclosingRequestBase.class.isAssignableFrom(request.getClass())) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                //装填参数
                HttpEntity entity = map2HttpEntity(nvps, config.map(), config.inenc());
                //设置参数到请求对象中
                ((HttpEntityEnclosingRequestBase) request).setEntity(entity);

                //请求参数打印
                {
                    logger.info("请求地址：" + config.urls());
                    if (nvps.size() > 0) {
                        logger.info("请求参数：" + nvps.toString());
                    }
                    if (config.json() != null) {
                        logger.info("请求参数：" + config.json());
                    }
                }
            } else {
                int idx = config.urls().indexOf("?");
                logger.info("请求地址：" + config.urls().substring(0, (idx > 0 ? idx : config.urls().length())));
                if (idx > 0) {
                    logger.info("请求参数：" + config.urls().substring(idx + 1));
                }
            }
            //执行请求操作
            resp = config.client().execute(request);

            if (config.isReturnRespHeaders()) {
                //获取所有response的header信息
                config.headers(resp.getAllHeaders());
            }

            //获取结果实体
            return resp;

        } catch (Exception e) {
            logger.error("Http请求失败：", e);
        }
        return resp;
    }

    /**
     * 拼接参数
     *
     * @param nvps
     * @param map
     * @param encoding
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:29
     * @version 1.0
     */
    public static HttpEntity map2HttpEntity(List<NameValuePair> nvps, Map<String, Object> map, String encoding) {
        HttpEntity entity = null;
        if (map != null && map.size() > 0) {
            // 拼接参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        return entity;
    }

    /**
     * 尝试关闭response
     *
     * @param resp HttpResponse对象
     * @Author: guoqun.yang
     * @Date: 2017/12/27 16:37
     * @version 1.0
     */
    private static void close(HttpResponse resp) {
        try {
            if (resp == null) return;
            //如果CloseableHttpResponse 是resp的父类，则支持关闭
            if (CloseableHttpResponse.class.isAssignableFrom(resp.getClass())) {
                ((CloseableHttpResponse) resp).close();
            }
        } catch (IOException e) {
            logger.error("关闭response异常：", e);
        }
    }
}
