package com.example.sixseconddemo.bean;

/**
 * Created by 郭金龙 on 2017/12/20.
 */

public class EventCheck {
    public boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "EventCheck{" +
                "checked=" + checked +
                '}';
    }
}
