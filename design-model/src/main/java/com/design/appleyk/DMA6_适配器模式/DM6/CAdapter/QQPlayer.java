package com.design.appleyk.DMA6_适配器模式.DM6.CAdapter;

import com.design.appleyk.DMA6_适配器模式.DM6.Mp3;
import com.design.appleyk.DMA6_适配器模式.DM6.Player;

/**
 * @Description //TODO
 * @Date 2023/11/1 16:00
 * @Author hy
 **/
public class  QQPlayer extends Mp3 implements Player {
    @Override
    public void playMVs() {
        System.out.println("QQ播放器实现播放MV功能");
    }


    @Override
    public void playMovies() {
        System.out.println("QQ播放器实现播放电影功能");
    }
}
