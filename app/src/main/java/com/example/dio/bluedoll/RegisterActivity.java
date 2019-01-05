package com.example.dio.bluedoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText emailedit, nameedit, passedit, conpassedit;
    TextView emailview, nameview, passview, conpassview;
    CheckBox toscheck;
    Button RegButton;

    public void returnLogin(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void login(View view){
        emailedit = (EditText)findViewById(R.id.emailReg);
        nameedit = (EditText)findViewById(R.id.nameReg);
        passedit = (EditText)findViewById(R.id.passReg);
        conpassedit = (EditText)findViewById(R.id.confirmpass);
        toscheck = (CheckBox)findViewById(R.id.tos);

        final String Name = nameedit.getText().toString();
        final String Email = emailedit.getText().toString();
        final String Pass = passedit.getText().toString();
        final String Confirm = conpassedit.getText().toString();

        int login = -1;

        for (int i = 0; i < Database.user.size(); i++){
            if (Email.isEmpty()){
                login = 0;
                break;
            }

            else if (!Email.contains("@")){
                login = 1;
                break;
            }

            else if (!Email.endsWith(".com") || !Email.endsWith(".co.id") || !Email.endsWith(".org")){
                login = 2;
                break;
            }

            else if (!Email.contains("@.")){
                login = 1;
                break;
            }

            else if (!Email.equals(Database.user.get(i).getEmail())){
                login = 3;
                break;
            }

            else if (Name.isEmpty()){
                login = 0;
                break;
            }

            else if (Pass.isEmpty()){
                login = 0;
                break;
            }

            else if (Pass.length() < 6){
                login = 4;
                break;
            }

            else if (Pass.matches("[a-zA-Z0-9]+")){
                login = 5;
                break;
            }

            else if (!toscheck.isChecked()){
                login = 6;
                break;
            }

            else{
                login = 7;
                break;
            }
        }

        switch (login){
            case 0:
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Email format is incorrect", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Domain must be '.com', '.co.id', or '.org'", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this, "Email is already taken", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Password too short, must be above six characters", Toast.LENGTH_LONG).show();
                break;
            case 5:
                Toast.makeText(this, "Password must have at least one letter and one number", Toast.LENGTH_LONG).show();
                break;
            case 6:
                Toast.makeText(this, "You must agree to our Terms and Condition", Toast.LENGTH_LONG).show();
                break;
            case 7:
                Database.user.add(new UserDatabase(Name, Pass, Email));
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                Toast.makeText(this, "Registration success", Toast.LENGTH_SHORT).show();
                break;
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    };
}
