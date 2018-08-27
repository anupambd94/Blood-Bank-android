package com.example.anupa.bloodbank;


import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.anupa.bloodbank.R.id.etEmail;
import static com.example.anupa.bloodbank.R.id.etPass;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Register;
    private EditText Name,Blood,Email,Pass,Mobile;
    private TextView tvLogin;
    private DbHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DbHelper(this);

        Register=(Button) findViewById(R.id.btnRegister);
        tvLogin=(TextView) findViewById(R.id.tvLogin);

        Name=(EditText) findViewById(R.id.etFname);
        Blood=(EditText) findViewById(R.id.etBloodGroup);
        Email=(EditText) findViewById(etEmail);
        Pass=(EditText) findViewById(etPass);
        Mobile=(EditText) findViewById(R.id.etMobile);

        Register.setOnClickListener(this);
        tvLogin.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnRegister:register();
                break;
            case R.id.tvLogin:startActivity(new Intent(RegisterActivity.this,LoginActivity.class);finish();
                break;
            default:

        }
    }

    private void register(){
        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        if(email.isEmpty()&& pass.isEmpty())
        {
            displayToast("username/password is empty");
        }
        else{db.addUser(email,pass);
            displayToast("user registered");
            finish();}
    }

    private void displayToast(String message)
    {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}