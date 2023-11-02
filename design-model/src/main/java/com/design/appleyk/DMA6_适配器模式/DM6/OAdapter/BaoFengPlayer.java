package com.design.appleyk.DMA6_适配器模式.DM6.OAdapter;

import com.design.appleyk.DMA6_适配器模式.DM6.Mp3;
import com.design.appleyk.DMA6_适配器模式.DM6.Player;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:55
 * @Author hy
 **/
public class BaoFengPlayer implements Player {
    private Mp3 mp3;

    public BaoFengPlayer(Mp3 mp3) {
        this.mp3 = mp3;
    }

    public Mp3 getMp3() {
        return mp3;
    }

    public void setMp3(Mp3 mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void playMVs() {
        System.out.println("暴风影音实现播放MV功能");
    }

    @Override
    public void playMusics() {
        this.mp3.playMusics();
    }

    @Override
    public void playMovies() {
        System.out.println("暴风影音实现播放电影功能");
    }
}
