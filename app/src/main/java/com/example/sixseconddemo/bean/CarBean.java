package com.example.sixseconddemo.bean;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class CarBean {
    String title;
    String img;
    String price;
    boolean checked;
    int num=1;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CarBean(){

    }
    public CarBean(String title, String img, String price) {
        this.title = title;
        this.img = img;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarBean{" +
                "title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
