package com.design.appleyk.DMA6_适配器模式.DM6.IAdapter;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:51
 * @Author hy
 **/
public class BPlayer extends AbstractPlayer {
    @Override
    public void playMVs() {
        System.out.println("B实现播放MV的功能");
    }

    @Override
    public void show() {
        playMovies();
        playMusics();
        playMVs();
    }
}
