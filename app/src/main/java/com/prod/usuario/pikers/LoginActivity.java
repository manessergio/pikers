package com.prod.usuario.pikers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prod.usuario.pikers.OpenHelper.SQLite_OpenHelper;
import com.prod.usuario.pikers.view.ContainerActivity;
import com.prod.usuario.pikers.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    TextView clickHereTextView;
    Button loginButton;
    EditText usernameEditText, passwordEditText;
    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1", null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        clickHereTextView = (TextView) findViewById(R.id.createHere);
        loginButton = (Button) findViewById(R.id.loginButton);
        usernameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);


        clickHereTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.OpenDB();
                boolean existeUser = helper.UserExists(usernameEditText.getText().toString(),passwordEditText.getText().toString());
                helper.CloseDB();
                if (existeUser){
                    Intent intent = new Intent (getApplicationContext(), ContainerActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.UserPassIncorrect),Toast.LENGTH_LONG).show();
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                }


            }
        });
    }
}
