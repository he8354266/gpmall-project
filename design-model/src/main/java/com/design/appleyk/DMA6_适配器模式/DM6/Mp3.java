package com.design.appleyk.DMA6_适配器模式.DM6;

/**
 * @Description //TODO
 * @Date 2023/11/1 15:38
 * @Author hy
 **/
public class Mp3 {
    private String name = "";

    public Mp3() {
    }

    public Mp3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playMusics() {
        System.out.println("Mp3 -- "+this.name+"播放歌曲");
    }
}
