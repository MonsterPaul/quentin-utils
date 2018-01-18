import com.demo.quentin.utils.CaptchaUtils;
import org.junit.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.demo.quentin.utils.CaptchaUtils.getCaptchaImage;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 13:36 2018/1/18
 * @Version 1.0
 */
public class TestCaptcha {

    @Test
    public void testCreateCaptcha() {
        for(int i=0;i<10;i++){
            Object[] obj=getCaptchaImage(150, 50, 35, 50, 500, true,true, CaptchaUtils.ComplexLevel.MEDIUM);
            System.out.println("验证码"+obj[1]);
            new File("C:\\test").mkdir();
            try {
                ImageIO.write((BufferedImage)obj[0],"jpg",new File("C:\\test\\"+System.currentTimeMillis()+".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
