package com.example.igor.pizz_order_fragments.fragments;

import com.example.igor.pizz_order_fragments.R;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewOne implements Contract.IView {

    final String LOG_TAG = "myLogs";

    private Button btn1;
    private TextView status1;

    private Contract.IPresenter presenter;

    @Override
    public void init(View root) {
        btn1 = (Button) root.findViewById(R.id.btn);
        status1 = (TextView) root.findViewById(R.id.status);
        initListeners();
        Log.d(LOG_TAG, "ViewOne init_initListeners +1");
    }

    @Override
    public void setPresenter(Contract.IPresenter presenter) {
        this.presenter = presenter;
        Log.d(LOG_TAG, "ViewOne setPresenter +4");
    }


    protected void initListeners() {
      btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.btnClick();
                Log.d(LOG_TAG, "ViewOne initListeners_onClick_btnClick");
            }

        });}
    }