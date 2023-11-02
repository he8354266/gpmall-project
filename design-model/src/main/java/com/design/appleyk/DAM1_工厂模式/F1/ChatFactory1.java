package com.design.appleyk.DAM1_工厂模式.F1;

import com.design.appleyk.DAM1_工厂模式.DM1.Chat;
import com.design.appleyk.DAM1_工厂模式.DM1.QQ;
import com.design.appleyk.DAM1_工厂模式.DM1.WeiXin;

/**
 * @Description //单方法工厂模式
 * @Date 2023/10/30 14:15
 * @Author hy
 **/
public class ChatFactory1 {
    public Chat createChat(String tools) {
        if ("QQ".equals(tools)) {
            return new QQ();
        } else if ("WeiXin".equals(tools)) {
            return new WeiXin();
        } else {
            return null;
        }
    }
}
