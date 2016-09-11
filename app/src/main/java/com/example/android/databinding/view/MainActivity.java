package com.example.android.databinding.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.databinding.R;
import com.example.android.databinding.databinding.ClockBinding;
import com.example.android.databinding.model.ClockModel;
import com.example.android.databinding.modelview.HandleClockActivity;


public class MainActivity extends AppCompatActivity {
    ClockModel model;
    HandleClockActivity handle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClockBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        model = new ClockModel("00:00", true);
        handle = new HandleClockActivity();
        binding.setMyClockModel(model);
        binding.setMyClockHandel(handle);
    }
}
