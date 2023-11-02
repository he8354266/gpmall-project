package com.design.appleyk.DMA5_建造者模式.DM5;

/**
 * @Description //TODO
 * @Date 2023/11/1 11:38
 * @Author hy
 **/
public interface CakeBuilder {
    /**
     * 揉面
     */
    void knead();

    /**
     * 发酵
     */
    void ferment();

    /**
     * 烘烤
     *
     * @param minutes 烘烤的分钟数
     */
    void bake(int minutes);

    /**
     * 返回builder后的产品、结果  == 即行为和展示分离，你怎么制作的我不关心，我关心的是，什么时候能让我吃上蛋糕，哈哈
     *
     * @return
     */
    Cake getCake();
}
