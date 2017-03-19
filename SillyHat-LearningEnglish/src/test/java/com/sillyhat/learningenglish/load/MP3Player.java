package com.sillyhat.learningenglish.utils;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * MP3解析
 * @author 徐士宽
 * @date 2017/3/17 18:03
 */
public class MP3Player {

    public MP3Player(String filename) {
        this.filename = filename;
    }

    public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(buffer);
            player.play();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        MP3Player mp3 = new MP3Player("H:\\KuGou\\赵英俊 - 大王叫我来巡山.mp3");
        mp3.play();

    }

    private String filename;
    private Player player;

}
