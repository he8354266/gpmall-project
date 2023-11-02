package com.design.appleyk.DMA6_适配器模式;

import com.design.appleyk.DMA6_适配器模式.DM6.CAdapter.QQPlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.IAdapter.APlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.IAdapter.AbstractPlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.IAdapter.BPlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.IAdapter.CPlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.Mp3;
import com.design.appleyk.DMA6_适配器模式.DM6.OAdapter.BaoFengPlayer;
import com.design.appleyk.DMA6_适配器模式.DM6.Player;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:57
 * @Author hy
 **/
public class AdapterTest {
    public static void main(String[] args) {
        useAdapterOfClass();
        useAdapterOfObject();
        useAdapterOfInterFace();
    }

    private static void useAdapterOfClass() {
        Player qqPlayer = new QQPlayer();
        qqPlayer.playMusics();
        qqPlayer.playMVs();
        qqPlayer.playMovies();
        System.out.println("============分割线");
    }

    private static void useAdapterOfObject() {
        Mp3 mp3 = new Mp3("SONY NW-ZX300A");
        BaoFengPlayer baoFengPlayer = new BaoFengPlayer(mp3);
        baoFengPlayer.playMusics();
        baoFengPlayer.playMVs();
        baoFengPlayer.playMovies();
    }


    private static void useAdapterOfInterFace() {
        AbstractPlayer aPlayer = new APlayer();
        aPlayer.show();

        AbstractPlayer bPlayer = new BPlayer();
        bPlayer.show();

        AbstractPlayer cPlayer = new CPlayer();
        cPlayer.show();
    }
}
