package com.design.appleyk.DMA6_适配器模式.DM6.IAdapter;

import com.design.appleyk.DMA6_适配器模式.DM6.Player;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:48
 * @Author hy
 **/
public abstract class AbstractPlayer implements Player {
    @Override
    public void playMVs() {

    }

    @Override
    public void playMusics() {

    }

    @Override
    public void playMovies() {

    }

    public abstract void show();
}
