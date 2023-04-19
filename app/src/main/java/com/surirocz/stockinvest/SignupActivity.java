package com.surirocz.stockinvest;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignup;
    private EditText edtUsername, edtEmail, edtPassword;
    private TextView txvBtnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = findViewById(R.id.btn_signup);
        edtUsername = findViewById(R.id.edt_username);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        txvBtnsignin = findViewById(R.id.txv_btn_signin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start log in process
                if (!isEmpty(getTxt(edtUsername)) && !isEmpty(getTxt(edtEmail)) && !isEmpty(getTxt(edtPassword))){
                    initSignup(getTxt(edtEmail).toLowerCase().trim(),getTxt(edtPassword));
                }else{
                    Toast.makeText(SignupActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txvBtnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start sign up screen
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(SignupActivity.this,android.R.anim.fade_in,android.R.anim.fade_out);
                startActivity(intent,options.toBundle());
                finish();
            }
        });

    }

    private void initSignup(String email, String password) {

    }

    private String getTxt(EditText e){
        return e.getText().toString();
    }

}