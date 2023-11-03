package com.design.appleyk.DMA9_外观模式.DM9.ModuleB;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:54
 * @Author hy
 **/
public class SubSystemC {
    public void sayHello(){
        System.out.println("欢迎进入Appleyk's 基于电影知识图谱的人工智能系统 =====>"+this);
        System.out.println("关于系统的介绍请参考博文：https://blog.csdn.net/Appleyk/article/details/80422055");
    }
    @Override
    public String toString(){
        return "人工智能系统，模块B，子系统C，欢迎界面";
    }
}
