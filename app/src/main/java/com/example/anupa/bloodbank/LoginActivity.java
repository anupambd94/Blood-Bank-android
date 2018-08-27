package com.example.anupa.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anupa.bloodbank.R;

import static com.example.anupa.bloodbank.R.id.etEmail;
import static com.example.anupa.bloodbank.R.id.etPass;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

 
    private Button Login, Register;
    private EditText Email, Pass;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session=new Session(this);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);

        Email = (EditText) findViewById(R.id.etEmail);
        Pass = (EditText) findViewById(R.id.etPass);

        Login.setOnClickListener(this);
        Register.setOnClickListener(this);

        if(session.loggedin())
        {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            default:
        }
    }

    private void login() {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        if (db.getUser(email, pass)) {
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "wrong email/pass", Toast.LENGTH_SHORT).show();
        }

    }
}
