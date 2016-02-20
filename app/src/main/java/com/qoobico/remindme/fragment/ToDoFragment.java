package com.qoobico.remindme.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qoobico.remindme.R;

public class ToDoFragment extends AbstractTabFragment {

    private static final int LAYOUT= R.layout.fragment_example;
    private View view;
    private String title;
    private Context context;

    public static ToDoFragment getInstance(Context context) {
        Bundle args=new Bundle();
        ToDoFragment fragment = new ToDoFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_time_to_do));
        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(LAYOUT,container,false);
        return view;
    }
}
