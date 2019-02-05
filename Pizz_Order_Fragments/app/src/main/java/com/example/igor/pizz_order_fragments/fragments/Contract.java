package com.example.igor.pizz_order_fragments.fragments;

import android.view.View;

public interface Contract {


    interface IView {
        void init(View root);

        void setPresenter(IPresenter presenter);
    }

    interface IPresenter {
        void btnClick();
    }
}