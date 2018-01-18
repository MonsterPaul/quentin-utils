import com.demo.quentin.utils.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 13:56 2018/1/18
 * @Version 1.0
 */
public class TestDateUtil {

    @Test
    public void testDateDiff() {
        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, 1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        try {
            System.out.println(DateUtils.getDiff(d, cal.getTime(), DateUtils.Type.Day));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
