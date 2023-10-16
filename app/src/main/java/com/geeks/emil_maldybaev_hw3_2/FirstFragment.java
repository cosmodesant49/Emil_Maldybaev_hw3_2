package com.geeks.emil_maldybaev_hw3_2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private Button btn_plus_one;
    private Button btn_minus_one;
    private TextView etText;
    //Я не правельно понел условие дз, в чем суть этого кода: он не прибовляет или отнимает значение к нулю,
    //оно прибавляет или отнимает к размеру шрифта нуля 10px во втором фрагменте показывается размер(Size)шрифта

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void initListener() {
        btn_minus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentTextSize = etText.getTextSize();
                etText.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentTextSize - 10);

                SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                preferences.edit().putFloat("textSize", currentTextSize - 10).apply();
            }
        });
        btn_plus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentTextSize = etText.getTextSize();
                etText.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentTextSize + 10);
                SharedPreferences preferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                preferences.edit().putFloat("textSize", currentTextSize + 10).apply();
            }
        });

    }
    private void initView(View view) {
        btn_plus_one = view.findViewById(R.id.btn_plus_one);
        btn_minus_one = view.findViewById(R.id.btn_minus_one);
        etText = view.findViewById(R.id.tv_zero);
    }
}