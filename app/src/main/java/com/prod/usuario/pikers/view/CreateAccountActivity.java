package com.prod.usuario.pikers.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prod.usuario.pikers.LoginActivity;
import com.prod.usuario.pikers.OpenHelper.SQLite_OpenHelper;
import com.prod.usuario.pikers.R;

public class CreateAccountActivity extends AppCompatActivity {

    Button buttonJoinUs;
    TextView email,name,username,password;

    SQLite_OpenHelper helper = new SQLite_OpenHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolBar(getResources().getString(R.string.createaccount),true);

        buttonJoinUs = (Button) findViewById(R.id.JoinUsButton);
        email = (TextView) findViewById(R.id.emailEditText);
        name = (TextView) findViewById(R.id.nameEditText);
        username = (TextView) findViewById(R.id.userNameEditText);
        password = (TextView) findViewById(R.id.passwordfirstEditText);

        buttonJoinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.OpenDB();
                helper.InsertUser(email.getText().toString(),
                                  username.getText().toString(),
                                  password.getText().toString(),
                                  name.getText().toString());
                helper.CloseDB();

                Toast.makeText(getApplicationContext(),
                               getResources().getString(R.string.user_saved1)+ " " +
                                           username.getText().toString() + " " +
                                           getResources().getString(R.string.user_saved2),
                               Toast.LENGTH_LONG)
                               .show();

                ClearFields();
            }
        });

    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void ClearFields(){
        email.setText("");
        username.setText("");
        name.setText("");
        password.setText("");
    }
}
