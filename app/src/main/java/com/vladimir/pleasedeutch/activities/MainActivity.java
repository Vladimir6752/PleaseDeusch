package com.vladimir.pleasedeutch.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vladimir.pleasedeutch.databinding.ActivityMainBinding;
import com.vladimir.pleasedeutch.utilities.WordCardChanger;
import com.vladimir.pleasedeutch.utilities.WordModelChanger;

public class MainActivity extends AppCompatActivity {

    public static ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        WordModelChanger.init(binding);
        WordCardChanger.init(binding);
    }
}