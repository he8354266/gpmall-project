package com.design.appleyk.DAM1工厂模式.F3;

import com.design.appleyk.DAM1工厂模式.DM1.Chat;
import com.design.appleyk.DAM1工厂模式.DM1.QQ;
import com.design.appleyk.DAM1工厂模式.DM1.WeiXin;

/**
 * @Description //TODO
 * @Date 2023/10/30 14:35
 * @Author hy
 **/
public class ChatFactory3 {
    public static Chat createQQChat() {
        return new QQ();
    }

    public static Chat createWeiXinChat() {
        return new WeiXin();
    }
}
