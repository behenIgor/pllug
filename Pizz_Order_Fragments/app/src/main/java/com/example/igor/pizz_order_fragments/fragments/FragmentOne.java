package com.example.igor.pizz_order_fragments.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.igor.pizz_order_fragments.R;


public class FragmentOne extends android.support.v4.app.Fragment {
    final String LOG_TAG = "myLogs";
    private View root;

    private Contract.IView view;
    private Contract.IPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_one, container, false);

        initView(root);
        initPresenter();
        Log.d(LOG_TAG, "FragmentOne onCreateView +6");
        return root;
    }

    private void initView(View root) {
        view = (Contract.IView) new ViewOne();
        view.init(root);
        Log.d(LOG_TAG, "FragmentOne initView + 2");
    }

    private void initPresenter() {
        presenter = (Contract.IPresenter) new PresenterOne(view, this);
        view.setPresenter(presenter);
        Log.d(LOG_TAG, "FragmentOne initPresenter +5");
    }

}