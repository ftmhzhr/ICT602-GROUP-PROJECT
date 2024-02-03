package com.example.kasijadi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteActivity extends AppCompatActivity {

    EditText deleteName, deleteEmail, deleteUsername, deletePassword;
    Button deleteButton;
    String nameUser, emailUser, usernameUser, passwordUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        reference = FirebaseDatabase.getInstance().getReference("users");


        deleteButton = findViewById(R.id.deleteButton);

        showData();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DeleteActivity.this, "Delete", Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void showData(){

        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        usernameUser = intent.getStringExtra("username");
        passwordUser = intent.getStringExtra("password");

        deleteName.setText(nameUser);
        deleteEmail.setText(emailUser);
        deleteUsername.setText(usernameUser);
        deletePassword.setText(passwordUser);
    }
}