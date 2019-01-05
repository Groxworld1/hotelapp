package com.example.dio.bluedoll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifyDollActivity extends AppCompatActivity {

    EditText nameEdit, descEdit;
    Spinner dollImg;
    Button save, delete;

    public void saveDoll(View view) {
        nameEdit = (EditText) findViewById(R.id.nameEdit);
        descEdit = (EditText) findViewById(R.id.descEdit);
        dollImg = (Spinner) findViewById(R.id.dollImage);
        save = (Button) findViewById(R.id.saveButton);
        delete = (Button) findViewById(R.id.deleteButton);

        final String Name = nameEdit.getText().toString();
        final String Desc = descEdit.getText().toString();

        int login = -1;

        for (int i = 0; i < Database.dolls.size(); i++) {
            if (Name.isEmpty() || Desc.isEmpty()) {
                login = 0;
                break;
            } else if (Name.equals(Database.dolls.get(i).getName())) {
                login = 1;
                break;
            } else if (!dollImg.isSaveEnabled()) {
                login = 2;
                break;
            } else {
                login = 3;
                break;
            }
        }

        switch (login) {
            case 0:
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Name is already taken, choose a new one", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "Image must be chosen", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Database.dolls.add(new DollDatabase(Name, Desc));
                Toast.makeText(this, "Creation successful", Toast.LENGTH_SHORT).show();
                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_doll);
    }
}