package com.example.dio.bluedoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();

    EditText emailedit, passedit;
    TextView emailview, passview;
    Button LoginButton;

    public void launchLogin(View view){
        emailedit = (EditText)findViewById(R.id.emailLogin);
        passedit = (EditText)findViewById(R.id.passLogin);

        final String Email = emailedit.getText().toString();
        final String Pass = passedit.getText().toString();

        int login = -1;

        for (int i = 0; i < Database.user.size(); i++){
            if (Email.isEmpty() || Pass.isEmpty()){
                login = 0;
                break;
            }

            else if (!Email.equals(Database.user.get(i).getEmail())){
                login = 1;
                break;
            }

            else if (!Pass.equals(Database.user.get(i).getPass())) {
                login = 2;
                break;
            }

            else {
                login = 3;
                break;
            }
        }

        switch (login){
            case 0:
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Email is incorrect", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent intent = new Intent(getApplicationContext(), HotelPage.class);
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void launchReg(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}


