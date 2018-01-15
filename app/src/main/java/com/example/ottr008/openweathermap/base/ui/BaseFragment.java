package com.example.ottr008.openweathermap.base.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ottr008.openweathermap.datalayer.api.ServiceConstants;

import static android.content.Context.MODE_PRIVATE;

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

    public SharedPreferences getSharedPref(String name,int mode){
      return getActivity().getSharedPreferences(name, mode);
    }
}
