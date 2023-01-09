package com.example.springbootthirdpartemail.utils;

import com.example.springbootthirdpartemail.config.DeployParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;

/**
 * @author xiegaobing
 * @description:
 * @date 2023/1/9 3:41 下午
 */
@Component
public class SendMailUtil {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(SendMailModel model) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件标题
        helper.setSubject(model.getSubject());
        //发送者邮箱
        helper.setFrom(DeployParameter.MAIL_USERNAME);
        helper.setTo(model.getRecipientMailbox());
        //抄送人
        if (model.getCcMailbox() != null && model.getCcMailbox().length != 0) {
            helper.setCc(model.getCcMailbox());
        }
        //加密抄送
        if (model.getBccMailbox() != null && model.getBccMailbox().length != 0) {
            helper.setBcc(model.getBccMailbox());
        }
        //发送日期
        helper.setSentDate(new Date());
        //发送内容
        if (model.isHtml()) {
            helper.setText(model.getSendContent(), true);
        } else {
            helper.setText(model.getSendContent());
        }
        if (model.getEnclosures() != null && !model.getEnclosures().isEmpty()) {
            //通过keySet取出map数据[Iterator遍历]
            System.out.println("-------[Iterator循环遍历]通过keySet取出map数据---------");
            //map.keySet()得到的是set集合，可以使用迭代器遍历
            Iterator<String> it = model.getEnclosures().keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                //预览文件
                helper.addAttachment(key, new File(model.getEnclosures().get(key)));
                System.out.println("key值：" + key + " value值：" + model.getEnclosures().get(key));
            }
        }
//        helper.addAttachment("2.jpg", new File("E:\\pic\\2.jpg"));//预览文件
//        helper.addInline("p01",new FileSystemResource(new File("E:\\pic\\2.jpg")));//配合前端可以直接预览图片
//        helper.addInline("p02",new FileSystemResource(new File("E:\\pic\\2.jpg")));
        javaMailSender.send(mimeMessage);
    }
}
