package com.example.demomaterial;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        return inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set a toolbar to replace the action bar.
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.BLUE);
        toolbar.setTitle("fragment 2");
        AppCompatActivity act = (AppCompatActivity)getActivity();
        act.setSupportActionBar(toolbar);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new MainAdapter());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
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