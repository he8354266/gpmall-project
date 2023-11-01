package com.design.appleyk.DAM1工厂模式.DM1;

/**
 * @Description //TODO
 * @Date 2023/10/30 14:13
 * @Author hy
 **/
public class WeiXin implements Chat {
    @Override
    public void chatting(String seqNo) {
        System.out.println("使用微信进行聊天 -- " + seqNo);
    }
}
