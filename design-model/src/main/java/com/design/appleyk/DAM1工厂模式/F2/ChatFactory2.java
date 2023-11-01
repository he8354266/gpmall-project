package com.design.appleyk.DAM1工厂模式.F2;

import com.design.appleyk.DAM1工厂模式.DM1.Chat;
import com.design.appleyk.DAM1工厂模式.DM1.QQ;
import com.design.appleyk.DAM1工厂模式.DM1.WeiXin;

/**
 * @Description //多方法工厂模式
 * @Date 2023/10/30 14:28
 * @Author hy
 **/
public class ChatFactory2 {
    public Chat createQQChat() {
        return new QQ();
    }

    public Chat createWeiXinChat() {
        return new WeiXin();
    }
}
