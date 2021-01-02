package com.dsi31g4.loginandregistersqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Email ,pass,cpass ;
    Button btnRegister ,btnLogin ;
    DatabaseHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new DatabaseHelper(this) ;
        Email=findViewById(R.id.email) ;
        pass=findViewById(R.id.pass) ;
        cpass=findViewById(R.id.cpass) ;
        btnLogin=findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), LoginActivity.class) ;
                startActivity(intent);
            }
        });

        btnRegister=findViewById(R.id.register) ;
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =Email.getText().toString() ;
                String password =pass.getText().toString() ;
                String cpassword =cpass.getText().toString() ;
                if(email.equals("")||password.equals("")||cpassword.equals("")){
                    Toast.makeText(getApplicationContext(),"fielde are empty",Toast.LENGTH_SHORT).show();

                }else {
                    if(password.equals(cpassword)){
                        boolean chekmail=db.chekmail(email) ;
                        if(chekmail==true){
                            boolean insert =db.insert(email,password);
                            if(insert==true){

                                Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();

                            }


                        }else {
                            Toast.makeText(getApplicationContext(),"Email Already existe",Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"pass do not match",Toast.LENGTH_SHORT).show();

                    }


                }


            }
        });


    }
}