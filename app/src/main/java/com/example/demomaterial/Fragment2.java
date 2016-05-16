package com.example.demomaterial;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by rupam.ghosh on 10/05/16.
 */
public class Fragment2 extends BaseFragment {

    public static Fragment2 getInstance(){
        return new Fragment2();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main2,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set a toolbar to replace the action bar.
        toolbar.setBackgroundColor(Color.BLUE);
        //view.findViewById(R.id.image).setBackgroundColor(Color.BLUE);
        toolbar.setTitle("fragment 2");
        toolbar.setTitleTextColor(Color.WHITE);
        AppCompatActivity act = (AppCompatActivity)getActivity();
        act.setSupportActionBar(toolbar);
        LinearLayout recyclerView = (LinearLayout) view.findViewById(R.id.recycler_view);
        //recyclerView.setAdapter(new MainAdapter());
        //LinearLayoutManager llm = new LinearLayoutManager(getContext());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(llm);
        view.findViewById(R.id.fabButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity act = (MainActivity)getActivity();
                act.openFragment1();
            }
        });
        for(int i =0 ;i< 40;i++){
            recyclerView.addView(LayoutInflater.from(view.getContext()).inflate(R.layout.list_item_layout,null,false));
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

    @Override
    public boolean shouldShowNavigationView() {
        return false;
    }
}