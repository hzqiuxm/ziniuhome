package com.ziniu.data.entity;

/**
 * 可播放的资源
 * Created by yeoman on 2017/10/25.
 */
public class PlayableRes extends DownableRes {

    protected int playCnt;

    public int getPlayCnt() {
        return playCnt;
    }

    public void setPlayCnt(int playCnt) {
        this.playCnt = playCnt;
    }

    @Override
    public String toString() {
        return "Res{" +
                "bucket='" + bucket + '\'' +
                ", fileKey='" + fileKey + '\'' +
                ", url='" + url + '\'' +
                ", fsize=" + fsize +
                ", downCnt=" + downCnt +
                ", playCnt=" + playCnt +
                '}';
    }
}
