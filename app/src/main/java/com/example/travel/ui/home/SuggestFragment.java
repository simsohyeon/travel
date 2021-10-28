package com.example.travel.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.travel.MainActivity;
import com.example.travel.R;

public class SuggestFragment extends Fragment {

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstamceState) {
        return inflater.inflate(R.layout.fragment_suggest, container, false);
    }
}
