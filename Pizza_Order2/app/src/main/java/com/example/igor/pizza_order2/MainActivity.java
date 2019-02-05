package com.example.igor.pizza_order2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView status1;
    private String order = "Замовити";
    private String reject = "Відхилити замовлення";

    private static final String TEST_BROADCAST_CHANGE_STATUS =
            "TEST_BROADCAST_CHANGE_STATUS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        status1 = findViewById(R.id.status);

        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        initReceivers();
    }

    @Override
    protected void onPause() {
        unregisterReceivers();
        super.onPause();
    }


    private void initListener() {
        final Button btn1 = (Button) findViewById(R.id.btn);
            btn1.setTag(1);
            btn1.setText(reject);

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
                }
            });
    }


    private void initReceivers() {
        IntentFilter statusIntentFiler = new IntentFilter(TEST_BROADCAST_CHANGE_STATUS);
        registerReceiver(mStatusReceiver, statusIntentFiler);}


        private void unregisterReceivers() {
        unregisterReceiver(mStatusReceiver);
    }

    BroadcastReceiver mStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (status1.getText().equals("Не замовлено")) {
                status1.setText("Замовлено");
            } else {
                status1.setText("Не замовлено");
            }
        }

    };

}

