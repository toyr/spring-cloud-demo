package com.example.springbootthirdpartemail.util;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xiegaobing
 * @description: 发送邮件的实体
 * @date 2023/1/9 3:36 下午
 */
@Data
public class SendMailModel implements Serializable {

    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 收件人邮箱
     */
    private String[] recipientMailbox;
    /**
     * 抄送人邮箱
     */
    private String[] ccMailbox;
    /**
     * 加密抄送人邮箱
     */
    private String[] bccMailbox;
    /**
     * 发送内容
     */
    private String sendContent;
    /**
     * 真实名称/附件路径
     */
    private Map<String, String> enclosures;
    /**
     * 是否为html
     */
    private boolean html;
}
