package com.geeks.emil_maldybaev_hw3_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private TextView tvSize;
    private float textSize = 50.0f;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        textSize = preferences.getFloat("textSize", 50.0f);
        tvSize = view.findViewById(R.id.tv_size);
        tvSize.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        tvSize.setText(String.valueOf(textSize));

        return view;
    }
}