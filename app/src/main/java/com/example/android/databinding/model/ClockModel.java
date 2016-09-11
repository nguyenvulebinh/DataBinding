package com.example.android.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.example.android.databinding.BR;

/**
 * Created by nguyenbinh on 12/09/2016.
 */

public class ClockModel extends BaseObservable {
    @Bindable
    public String time;
    @Bindable
    public boolean stop;

    private int count;

    public ClockModel(String time, boolean isstop) {
        this.time = time;
        this.stop = isstop;
        count = 0;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean isstop) {
        this.stop = isstop;
        if(!stop){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!stop) {
                        try {
                            count++;
                            Log.d("ClockModel", ""+count+": stop = " + stop);
                            setTime(count / 60 + ":" + count % 60);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.d("ClockModel", "Out");
                }
            }).start();
        }
        notifyPropertyChanged(BR.stop);
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    public void reset() {
        count = 0;
        setTime("00:00");
    }
}
