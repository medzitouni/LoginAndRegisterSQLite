package com.dsi31g4.loginandregistersqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email , password ;
    private Button login ,register ;
    DatabaseHelper db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        email=findViewById(R.id.lemail);
        password=findViewById(R.id.lpass) ;
        login=findViewById(R.id.login) ;
        db=new DatabaseHelper(this);

        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();

                boolean checkEmailAndPassword=db.checkEmailAndPassword(Email,Password) ;
                if (Email.equals("") || Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "field are empty", Toast.LENGTH_SHORT).show();

                } else {
                    if (checkEmailAndPassword) {

                        Toast.makeText(getApplicationContext(), " Wrong  Email or password ", Toast.LENGTH_SHORT).show();
                    } else {

                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }) ;

    }
}