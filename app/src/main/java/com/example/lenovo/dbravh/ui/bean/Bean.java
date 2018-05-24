package com.example.lenovo.dbravh.ui.bean;

/**
 * Created by lenovo
 * on 2018/5/9.
 * at 北京
 */

public class Bean {
    private String name;
    private int img;

    public Bean() {
    }

    public Bean(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
