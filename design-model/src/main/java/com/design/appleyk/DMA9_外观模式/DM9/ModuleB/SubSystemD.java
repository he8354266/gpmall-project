package com.design.appleyk.DMA9_外观模式.DM9.ModuleB;

/**
 * @Description //TODO
 * @Date 2023/11/3 13:54
 * @Author hy
 **/
public class SubSystemD {
    public void working(){
        System.out.println("亲爱的用户，以下是你18年截止到今天看的电影的大数据统计结果：=====>"+this);
        System.out.println("《《《《 ========== 》》》》》\n爱情动作片：10次\n" +
                "恐怖片：1次\n" +
                "喜剧片：6次\n" +
                "总花费：680.5元\n" +
                "《《《《 ========== 》》》》》");
    }
    @Override
    public String toString(){
        return "人工智能系统，模块B，子系统D，开始工作";
    }
}
