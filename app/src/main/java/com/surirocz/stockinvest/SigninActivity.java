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

public class SigninActivity extends AppCompatActivity {

    private Button btnSignin;
    private EditText edtEmail, edtPassword;
    private TextView txvBtnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btnSignin = findViewById(R.id.btn_signin);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        txvBtnsignup = findViewById(R.id.txv_btn_signup);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start log in process
                if (!isEmpty(getTxt(edtEmail)) && !isEmpty(getTxt(edtPassword))){
                    initSignin(getTxt(edtEmail).toLowerCase().trim(),getTxt(edtPassword));
                }else{
                    Toast.makeText(SigninActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txvBtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start sign up screen
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(SigninActivity.this,android.R.anim.fade_in,android.R.anim.fade_out);
                startActivity(intent,options.toBundle());
                finish();
            }
        });

    }

    private void initSignin(String email, String password) {

    }

    private String getTxt(EditText e){
        return e.getText().toString();
    }

}