package com.example.dio.bluedoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewAllDollActivity extends AppCompatActivity {

    String[] menu = {"ImageView", "TextView", "View", "Edit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_doll);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_view_all_doll, menu);

        ListView listView = (ListView)findViewById(R.id.dollList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                return true;
            case R.id.add_new_doll:
                Intent intent = new Intent(this, ModifyDollActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
