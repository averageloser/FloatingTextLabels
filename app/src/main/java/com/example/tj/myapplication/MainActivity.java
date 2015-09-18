package com.example.tj.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = (EditText) findViewById(R.id.login_edit_text);

        passwordEditText = (EditText) findViewById(R.id.password_edit_text);

        loginButton =  (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new LoginVerifier());
    }

   private class LoginVerifier implements View.OnClickListener {
        int count = 0; //how many time user clicked the login button.

       @Override
       public void onClick(View v) {
           count++;

           if (count <= 1) {
               passwordEditText.setError("Invalid password.");
               passwordEditText.setText("");
           } else {
               Snackbar.make(loginButton, "Password accepted.  Please wait...", Snackbar.LENGTH_LONG).show();
           }
       }
   }
}
