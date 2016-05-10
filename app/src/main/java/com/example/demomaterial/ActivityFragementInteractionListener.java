package com.example.demomaterial;

import android.support.v7.widget.Toolbar;

/**
 * Created by anshul.garg on 10/05/16.
 */
public interface ActivityFragementInteractionListener {
    void initToolBar(Toolbar toolbar);
    void lockOrUnlockDrawer(boolean doLock);
}
