package com.geeks.emil_maldybaev_hw3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
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