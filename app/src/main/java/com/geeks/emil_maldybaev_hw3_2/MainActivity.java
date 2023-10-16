package com.geeks.emil_maldybaev_hw3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Я не правельно понел условие дз в чем суть этого кода он не прибовляет или отнимает значение к нулю,
    //оно прибавляет или отнимает к размеру шрифта нуля 10px во втором фрагменте показывается размер(Size)шрифта
    //удалю этот commit когда исправлю
    private Button btn_go_to_next;
    private boolean isShowingFirstFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        showFirstFragment();
    }

    private void initView() {
        btn_go_to_next = findViewById(R.id.btn_go_to_next);
        btn_go_to_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowingFirstFragment) {
                    showSecondFragment();
                } else {
                    showFirstFragment();
                }
            }
        });
    }

    private void showFirstFragment() {
        isShowingFirstFragment = true;
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new FirstFragment()).commit();
    }

    private void showSecondFragment() {
        isShowingFirstFragment = false;
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new SecondFragment()).commit();
    }
}