package com.example.demomaterial;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        openFragment1();
    }

    public void openFragment1(){
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,Fragment1.getInstance()).commit();
    }

    public void openFragment2(){
        getSupportFragmentManager().beginTransaction().replace(R.id.contentFragment,Fragment2.getInstance()).commit();
    }
}
