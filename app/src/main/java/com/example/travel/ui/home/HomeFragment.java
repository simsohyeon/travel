package com.example.travel.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.travel.MainActivity;
import com.example.travel.R;
import com.example.travel.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstamceState) {
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.fragment_home, container, false);

        Button button = rootView.findViewById(R.id.suggest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(0);
            }
        });
        Button button1 = rootView.findViewById(R.id.festa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(1);
            }
        });
        Button button2 = rootView.findViewById(R.id.theme);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(2);
            }
        });
        Button button3 = rootView.findViewById(R.id.btn_spring);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(3);
            }
        });
        Button button4 = rootView.findViewById(R.id.btn_summer);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(4);
            }
        });
        Button button5 = rootView.findViewById(R.id.btn_fall);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(5);
            }
        });

        Button button6 = rootView.findViewById(R.id.btn_winter);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity=(MainActivity) getActivity();
                activity.onFragmentChanged(6);
            }
        });

        return rootView;


    }
}