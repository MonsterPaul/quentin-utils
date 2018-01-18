import com.demo.quentin.utils.mail.Email;
import com.demo.quentin.utils.mail.MailSender;
import com.demo.quentin.utils.mail.SmtpServer;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

/**
 * @Auth Created by guoqun.yang
 * @Date Created in 14:42 2018/1/18
 * @Version 1.0
 */
public class TestEmailSender {

    public void testSendEmail() {
        // 这个类主要是设置邮件
        Email mailInfo = new Email();
        mailInfo.setMailServerHost(SmtpServer.SMTP_163.get("smtp"));
        mailInfo.setMailServerPort(SmtpServer.SMTP_163.get("port"));
        mailInfo.setValidate(true);
        mailInfo.setFromNickName("xdemo网站");
        mailInfo.setUserName("goofy0205@163.com"); // 实际发送者
        mailInfo.setPassword("*******");// 您的邮箱密码
        mailInfo.setFromAddress("goofy0205@163.com"); // 设置发送人邮箱地址
        mailInfo.setToAddress("****@qq.com"); // 设置接受者邮箱地址,多个收件人逗号隔开
        mailInfo.setSubject("Ant测试");
        mailInfo.setContent("<a href='http://www.xdemo.org'>xdemo</a><img src='http://www.xdemo.org.img.800cdn.com/wp-content/uploads/2014/03/logo1.png'></img>");
        mailInfo.setAttachments(new ArrayList<File>() {
            {
                add(new File("D:\\xx.TTF"));
                add(new File("D:\\xx.html"));
            }
        });
        // 这个类主要来发送邮件
        MailSender sms = new MailSender();
        try {
            //sms.sendTextMail(mailInfo); // 发送文体格式
            sms.sendHtmlMail(mailInfo); // 发送html格式
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
