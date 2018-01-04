import com.demo.quentin.utils.HttpClientUtils;
import com.demo.quentin.utils.ServiceBeanMessage;
import com.demo.quentin.utils.WebServiceClientUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 9:44 2017/12/22
 * @Version 1.0
 */
public class TestUtils {

    private static Logger logger = LoggerFactory.getLogger(TestUtils.class);

    /**
     * 测试糊涂工具类
     */
    @Test
    public void testHttpClient() {
        String url = "http://localhost:8080/ane-job/100219.bizservice";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ewbNo", "433122");
        params.put("siteId", "4545");
        HttpClientUtils.getInstance().sendPostReq(url, params, "utf-8");
    }

    @Test
    public void cxfWs() {
        String url = "http://localhost:8080/services/NE8Service?wsdl";
        String nameSpace = "http://web.operation.ne.chengfeng.com/";
        String bindingNameStr = "NE8ServiceServiceSoapBinding";
        String servicename = "NE8ServiceService";
        String method = "callNE8LogicToString";
        String str = "[{\"waybilllist\":\"[{\"ewbNo\": \"5712000\",\"siteName\": \"萧山分拨中心\"},{\"siteCode\": \"5392001\",\"siteName\": \"临沂分拨中心\"}]\",\"posVoucherNo\":\"1111111\",\"terminalNo\":\"212121\"}]";
        byte[] k = {1, 1, 1, 1, 1, 1};
        ServiceBeanMessage serviceBeanMessage = new ServiceBeanMessage();
        serviceBeanMessage.setLoginUser("admin");
        serviceBeanMessage.setLoginPwd("admin");
        serviceBeanMessage.setIp("192.168.1.8");
        serviceBeanMessage.setServerCode("200101");
        serviceBeanMessage.setParams(str);
        serviceBeanMessage.setScanParams(k);
        serviceBeanMessage.setStates("1");


        //调用WebService
        WebServiceClientUtils.executeService(url, nameSpace, bindingNameStr, method, serviceBeanMessage);
    }


}
