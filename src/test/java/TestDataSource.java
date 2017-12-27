import com.demo.quentin.domain.OptEwbVO;
import com.demo.quentin.domain.User;
import com.demo.quentin.service.IEwbService;
import com.demo.quentin.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 10:02 2017/12/19
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-mybatis.xml")
public class TestDataSource {
    @Autowired
    private IUserService userService;
    @Autowired
    private IEwbService ewbService;

    @Test
    public void getUser(){
        User user = userService.queryUserById(31);
        if (null != user) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void getEwb() {
        OptEwbVO ewb = ewbService.selectEwbByEwbNo("152469856321");
        if (null != ewb) {
            System.out.println("查询出运单信息为："+ewb.toString());
        }
    }
}
