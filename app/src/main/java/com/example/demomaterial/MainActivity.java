package com.example.demomaterial;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void openFragment1(){
        getSupportFragmentManager().beginTransaction().replace(,Fragment1.getInstance()).commit();
    }

//    private void openFragment2(){
//        getSupportFragmentManager().beginTransaction().replace(,Fragment1.getInstance()).commit();
//    }
}
