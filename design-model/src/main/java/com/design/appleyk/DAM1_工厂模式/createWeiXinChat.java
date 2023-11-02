package com.design.appleyk.DAM1_工厂模式;

import com.design.appleyk.DAM1_工厂模式.DM1.Chat;
import com.design.appleyk.DAM1_工厂模式.F1.ChatFactory1;
import com.design.appleyk.DAM1_工厂模式.F2.ChatFactory2;
import com.design.appleyk.DAM1_工厂模式.F3.ChatFactory3;

/**
 * @Description //TODO
 * @Date 2023/10/30 14:43
 * @Author hy
 **/
public class createWeiXinChat {
    public static void main(String[] args) {
        ChatFactory1 chatFactory1 = new ChatFactory1();
        String seqNo = "1";
        Chat weiXin = chatFactory1.createChat("WeiXin");
        weiXin.chatting(seqNo);
        Chat qq1 = chatFactory1.createChat("QQ");
        qq1.chatting(seqNo);

        ChatFactory2 chatFactory2 = new ChatFactory2();
        seqNo = "2";
        Chat weiXinChat = chatFactory2.createWeiXinChat();
        weiXinChat.chatting(seqNo);
        Chat qqChat = chatFactory2.createQQChat();
        qqChat.chatting(seqNo);

        seqNo = "3";
        Chat weiXinChat1 = ChatFactory3.createWeiXinChat();
        weiXinChat1.chatting(seqNo);
        Chat qqChat1 = ChatFactory3.createQQChat();
        qqChat1.chatting(seqNo);
    }
}
