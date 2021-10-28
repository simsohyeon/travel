package com.example.travel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.travel.R;

public class ThemeFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstamceState) {
        return inflater.inflate(R.layout.fragment_theme, container, false);
    }



}
