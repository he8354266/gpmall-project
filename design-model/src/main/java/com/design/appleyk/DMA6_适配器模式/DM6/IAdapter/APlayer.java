package com.design.appleyk.DMA6_适配器模式.DM6.IAdapter;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:49
 * @Author hy
 **/
public class APlayer extends AbstractPlayer {
    @Override
    public void playMusics() {
        System.out.println("A实现播放音乐的功能");
    }

    @Override
    public void show() {
        playMovies();
        playMusics();
        playMVs();
    }
}
