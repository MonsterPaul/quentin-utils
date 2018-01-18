import com.demo.quentin.domain.OptEwbVO;
import com.demo.quentin.utils.ReflectUtils;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 16:20 2018/1/18
 * @Version 1.0
 */
public class TestReflect {

    @Test
    public void testGetType() {
        try {
            Class clazz = OptEwbVO.class;
            Method[] methods = clazz.getMethods();
            for (int i = 0;i <=methods.length;i++) {
                Method method = methods[i];
                int x =  ReflectUtils.getMethodModifier(OptEwbVO.class, method.getName());
                System.out.println("===="+x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllFields() {
        String[] strs = ReflectUtils.getFields(OptEwbVO.class);
        if (strs != null && strs.length > 0) {
            for (int i = 0;i < strs.length ; i++) {
                System.out.println(strs[i]);
            }
        }
    }
}
