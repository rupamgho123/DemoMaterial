package com.example.demomaterial;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by rupam.ghosh on 10/05/16.
 */
public abstract class BaseFragment extends Fragment {

    protected Toolbar toolbar;

    public boolean shouldShowNavigationView(){
        return true;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ActivityFragementInteractionListener listener = (ActivityFragementInteractionListener)getActivity();
        listener.initToolBar(toolbar);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ActivityFragementInteractionListener listener = (ActivityFragementInteractionListener)getActivity();
        listener.lockOrUnlockDrawer(!shouldShowNavigationView());
    }
}
