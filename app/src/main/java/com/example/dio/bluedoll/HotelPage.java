package com.example.dio.bluedoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HotelPage extends AppCompatActivity {

    Button bookButton, locationButton, unbookButton;

    public void book(View view){
        Toast.makeText(this, "A room has been booked!", Toast.LENGTH_SHORT).show();
    }

    public void unbook(View view){
        Toast.makeText(this, "Your room has been unbooked", Toast.LENGTH_SHORT).show();
    }

    public void location(View view){
        Toast.makeText(this, "Your location has been set (replace this later)", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_page);
    }
}
