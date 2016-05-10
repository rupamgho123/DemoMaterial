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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new MainAdapter());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


//        int screenSize = getResources().getConfiguration().screenLayout &
//                Configuration.SCREENLAYOUT_SIZE_MASK;
//
//        switch(screenSize) {
//            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
//                Toast.makeText(this, "XLarge screen", Toast.LENGTH_LONG).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_LARGE:
//                Toast.makeText(this, "Large screen", Toast.LENGTH_LONG).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
//                Toast.makeText(this, "Normal screen",Toast.LENGTH_LONG).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_SMALL:
//                Toast.makeText(this, "Small screen",Toast.LENGTH_LONG).show();
//                break;
//            default:
//                Toast.makeText(this, "Screen size is neither large, normal or small" , Toast.LENGTH_LONG).show();
//        }

        int density= getResources().getDisplayMetrics().densityDpi;

        switch(density)
        {
            case DisplayMetrics.DENSITY_LOW:
                Toast.makeText(this, "LDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                Toast.makeText(this, "MDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_HIGH:
                Toast.makeText(this, "HDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                Toast.makeText(this, "XHDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                Toast.makeText(this, "XXHDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                Toast.makeText(this, "XXXHDPI", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class MainListHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MainListHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    private class MainAdapter extends RecyclerView.Adapter<MainListHolder>{

        @Override
        public MainListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,parent,false));
        }

        @Override
        public void onBindViewHolder(MainListHolder holder, int position) {
            holder.textView.setText(""+position);
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }
}
