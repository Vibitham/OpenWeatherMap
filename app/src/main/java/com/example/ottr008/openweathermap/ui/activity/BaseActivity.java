package com.example.ottr008.openweathermap.ui.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ottr008.openweathermap.R;


public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    protected final <T extends View> T getViewId(int viewId) {
        return (T) findViewById(viewId);
    }

    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        buildConfig();
    }

    protected abstract int getResourceLayout();

    protected abstract void buildConfig();

    public final void setToolbatTitle(String title) {
        toolbar.setTitle(title);
    }

    public final void toggleToolbar(boolean isHidden) {
        if (isHidden) {
            toolbar.setVisibility(View.GONE);
        }
    }
    public final void setToolbarIcons(int id)
    {
        toolbar.inflateMenu(id);
    }
}