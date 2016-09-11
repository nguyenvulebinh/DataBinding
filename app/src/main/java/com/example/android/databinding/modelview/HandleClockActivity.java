package com.example.android.databinding.modelview;

import android.view.View;
import android.widget.Toast;

import com.example.android.databinding.model.ClockModel;

/**
 * Created by nguyenbinh on 12/09/2016.
 */

public class HandleClockActivity {
    public void onClickReset(ClockModel model){
        model.reset();
    }

    public void onClickStart(ClockModel model){
        if(model.isStop()){
            model.setStop(false);
        }
        else {
            model.setStop(true);
        }
    }
}
