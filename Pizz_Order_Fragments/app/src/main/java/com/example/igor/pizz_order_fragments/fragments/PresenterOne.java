package com.example.igor.pizz_order_fragments.fragments;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.igor.pizz_order_fragments.MainActivity;
import com.example.igor.pizz_order_fragments.R;
import com.example.igor.pizz_order_fragments.fragments.ViewOne;

public class PresenterOne extends AppCompatActivity implements Contract.IPresenter {

    final String LOG_TAG = "myLogs";

    private Contract.IView view;
    private FragmentOne fragment;
    private Button btn1;
    private TextView status1;
    private String order = "Замовити";
    private String reject = "Відхилити замовлення";

    private static final String TEST_BROADCAST_CHANGE_STATUS =
            "TEST_BROADCAST_CHANGE_STATUS";

    public PresenterOne(Contract.IView view, FragmentOne fragment) {
        this.view = view;
        this.fragment = fragment;
        Log.d(LOG_TAG, "PresenterOne PresenterOne(constr.) +3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn);
        status1 = (TextView) findViewById(R.id.status);
        initListeners();
        Log.d(LOG_TAG, "PresenterOne onCreate");
    }

    @Override
    public void btnClick() {
        btn1.setTag(1);
        btn1.setText(reject);

        Intent intent = new Intent(TEST_BROADCAST_CHANGE_STATUS);
        sendBroadcast(intent);
        Log.d(LOG_TAG, "PresenterOne btnClick");
//        final int status =(Integer) v.getTag();
//
//        if(status == 1) {
//            btn1 .setText(reject);
//            v.setTag(0);
//        } else {
//            btn1 .setText(order);
//            v.setTag(1);
//        }

    }

    private void initListeners() {

        btn1.setTag(1);
        btn1.setText(reject);

        Log.d(LOG_TAG, "PresenterOne initListeners");

        btn1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick (View v) {

                Intent intent = new Intent(TEST_BROADCAST_CHANGE_STATUS);
                sendBroadcast(intent);

                final int status =(Integer) v.getTag();

                if(status == 1) {
                    btn1 .setText(reject);
                    v.setTag(0);
                } else {
                    btn1 .setText(order);
                    v.setTag(1);
                }
                Log.d(LOG_TAG, "PresenterOne onClick");
            }

        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        initReceivers();
        Log.d(LOG_TAG, "PresenterOne onResume_initReceivers");
    }

    @Override
    protected void onPause() {
        unregisterReceivers();
        super.onPause();
        Log.d(LOG_TAG, "PresenterOne onPause_unregisterReceivers");
    }


    private void initReceivers() {
        IntentFilter statusIntentFiler = new IntentFilter(TEST_BROADCAST_CHANGE_STATUS);
        registerReceiver(mStatusReceiver, statusIntentFiler);
        Log.d(LOG_TAG, "PresenterOne initReceivers");
    }


    private void unregisterReceivers() {
        unregisterReceiver(mStatusReceiver);

        Log.d(LOG_TAG, "PresenterOne unregisterReceivers");
    }

    BroadcastReceiver mStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (status1.getText().equals("Не замовлено")) {
                status1.setText("Замовлено");
            } else {
                status1.setText("Не замовлено");
            }
            Log.d(LOG_TAG, "PresenterOne onReceive");
        }

    };

}