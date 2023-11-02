package com.design.appleyk.DMA6_适配器模式.DM6;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:41
 * @Author hy
 **/
public interface Player {
    /**
     * 播放MV
     */
    public void playMVs();

    /**
     * 播放音乐 == 与Mp3播放音乐的功能【方法】名称一致
     */
    public void playMusics();

    /**
     * 播放电影
     */
    public void playMovies();
}
