package com.fission.testapp;

/**
 * Created by fission on 10/9/2015.
 */


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ForgotActivity extends Activity {
    private EditText mETUserName;
    private EditText mETEmail;
    private Button mBtnRetrievePassword;
    private TextView mBtnRegister;
    private String Password;
    private String emailPattern;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotactivity);

        SharedPreferences prefs = getSharedPreferences("your_file_name",
                MODE_PRIVATE);
        final String username = prefs.getString("username", "null");

        Password = prefs.getString("password", "null");
        mETUserName = (EditText) findViewById(R.id.edtUserName1);

        mBtnRetrievePassword = (Button) findViewById(R.id.btnpassword1);
        mBtnRegister = (TextView) findViewById(R.id.btnAccount3);

        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBtnRegister.setPaintFlags(mBtnRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                Intent i = new Intent(ForgotActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        mBtnRetrievePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mETUserName.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show();
                } else if (mETUserName.getText().toString().equals(username)) {



                    Toast.makeText(getApplicationContext(), "Your password is " + Password, Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "You don't have account please register", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBtnRegister.setPaintFlags(0);
    }
}



