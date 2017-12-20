package com.example.sixseconddemo.view;

import com.example.sixseconddemo.bean.FenLeiRight;
import com.example.sixseconddemo.bean.FenleiLeft;

import java.util.List;

/**
 * Created by 李倩 on 2017/12/20.
 */

public interface FenleiLeftView {
    public void showFeiLeft(List<FenleiLeft> flist);
    public void showFeiRight(List<FenLeiRight> rlist);
}
