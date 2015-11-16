package com.fission.testapp;

/**
 * Created by fission on 10/9/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fission on 3/18/2015.
 */
public class Login extends Activity {

    LoginDataBaseAdapter loginDataBaseAdapter;

    private EditText edtPassword;
    private Button btnlogin;
    private EditText edtUserName;


    TextView btnAccount1;
    TextView forgotpassword;
    public EditText txtFirstName;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        txtFirstName = (EditText) findViewById(R.id.edtfirstname1);

        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUserName = (EditText) findViewById(R.id.edtUserName);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnAccount1 = (TextView) findViewById(R.id.btnAccount1);
        forgotpassword = (TextView) findViewById(R.id.forgotpassword);
        btnAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAccount1.setPaintFlags(btnAccount1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                Intent i = new Intent(Login.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotpassword.setPaintFlags(forgotpassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                Intent i = new Intent(Login.this, ForgotActivity.class);
                startActivity(i);

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();





                if (edtUserName.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_SHORT).show();

                } else if (edtPassword.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                }

                String storedUsername = loginDataBaseAdapter.getSinlgeEntry(email);
                String storedPassword = loginDataBaseAdapter.getSinlgeEntryData(email);

                System.out.println("NAME===>" + storedUsername + "" + storedPassword);

                if (edtPassword.getText().toString().equals(storedPassword)) {
                    Intent i = new Intent(Login.this, MainActivity.class);
                   // i.putExtra("username", storedUsername);
                    Bundle bundle = new Bundle();

                    bundle.putString("username",storedUsername);
                    i.putExtras(bundle);
                    startActivity(i);



                }

                else {
                    Toast.makeText(getApplicationContext(), "please Register", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }




    @Override
    protected void onStop() {
        super.onStop();
//
        edtUserName.setText("");
        edtPassword.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnAccount1.setPaintFlags(0);
        forgotpassword.setPaintFlags(0);
    }

}



