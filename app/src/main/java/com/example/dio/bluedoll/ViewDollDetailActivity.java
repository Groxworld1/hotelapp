package com.example.dio.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDollDetailActivity extends AppCompatActivity {

    TextView nameDoll, descDoll;

    public void dollDB(){
        int i = 0;

        nameDoll = (TextView)findViewById(R.id.dollNameText);
        descDoll = (TextView)findViewById(R.id.dollDescText);

        final String name = Database.dolls.get(i).getName();
        final String desc = Database.dolls.get(i).getDesc();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doll_detail);
    }
}
