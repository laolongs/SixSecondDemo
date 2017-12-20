package com.example.sixseconddemo.bean;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class EventPriceAndNum {
   public int price;
   public int num;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "EventPriceAndNum{" +
                "price=" + price +
                ", num=" + num +
                '}';
    }
}
