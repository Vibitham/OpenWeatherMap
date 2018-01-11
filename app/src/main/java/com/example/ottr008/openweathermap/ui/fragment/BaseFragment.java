package com.example.ottr008.openweathermap.ui.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vibitha on 7/3/17.
 */

public abstract class BaseFragment extends Fragment {
    private View parentView;

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutResource(), container, false);

        configView();
        return parentView;
    }

    protected final <T extends View> T getResId(@IdRes int resId) {
        if (parentView != null) {
            return (T) parentView.findViewById(resId);
        }
        return null;
    }

    protected abstract int getLayoutResource();

    protected abstract void configView();
}
