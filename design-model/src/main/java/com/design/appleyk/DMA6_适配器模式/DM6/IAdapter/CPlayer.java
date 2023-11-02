package com.design.appleyk.DMA6_适配器模式.DM6.IAdapter;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:52
 * @Author hy
 **/
public class CPlayer extends AbstractPlayer {
    @Override
    public void playMVs() {
        System.out.println("C实现播放MV的功能");
    }


    @Override
    public void playMusics() {
        System.out.println("C实现播放音乐的功能");
    }


    @Override
    public void playMovies() {
        System.out.println("C实现播放电影的功能");
    }

    @Override
    public void show() {
        playMovies();
        playMusics();
        playMVs();
    }
}
