import com.demo.quentin.utils.HCB;
import com.demo.quentin.utils.HttpClientUtils;
import com.demo.quentin.utils.HttpConfig;
import org.apache.http.client.HttpClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 9:44 2017/12/22
 * @Version 1.0
 */
public class TestUtils {

    /**
     * 测试糊涂工具类
     */
    @Test
    public void testHttpClient() {
        String url = "http://localhost:8080/ane-job/100219.bizservice";
        //插件式配置生成HttpClient时所需参数（超时、连接池、ssl、重试）
        HCB hcb = HCB.getInstance()
                .timeOutConfig(3000, false)//超时
                .retry(3);                   //重试3次

        HttpClient client = hcb.build();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.getInstance()
                .urls(url)                    //设置请求的url
                .map(map)            //设置请求参数，没有则无需设置
                .encoding("utf-8") //设置请求和返回编码，默认就是Charset.defaultCharset()
                .client(client)                                                        //如果只是简单使用，无需设置，会自动获取默认的一个client对象
                .inenc("utf-8")                                                    //设置请求编码，如果请求返回一直，不需要再单独设置
                .inenc("utf-8")                                                    //设置返回编码，如果请求返回一直，不需要再单独设置
                //.json("json字符串")												//json方式请求的话，就不用设置map方法，当然二者可以共用。
                //.context(HttpCookies.custom().getContext()) 		//设置cookie，用于完成携带cookie的操作
                //.out(new FileOutputStream("保存地址"))			 	//下载的话，设置这个方法,否则不要设置
                //.files(new String[]{"d:/1.txt","d:/2.txt"})					//上传的话，传递文件路径，一般还需map配置，设置服务器保存路径
                ;

        String result2 = HttpClientUtils.getInstance().post(config);    //post请求
        System.out.println("返回结果："+result2);

    }
}
