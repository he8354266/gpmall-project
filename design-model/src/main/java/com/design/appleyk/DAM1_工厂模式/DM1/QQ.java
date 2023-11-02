package com.design.appleyk.DAM1_工厂模式.DM1;

/**
 * @Description //TODO
 * @Date 2023/10/30 14:12
 * @Author hy
 **/
public class QQ implements Chat {
    @Override
    public void chatting(String seqNo) {
        System.out.println("QQ chat -- " + seqNo);
    }
}
