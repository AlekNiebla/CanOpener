package com.example.jesusalejandro.spaceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {
    Button btnInicio, btnRegister;
    EditText username, password;
    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, new LoginRepoImpl());

        btnInicio = findViewById(R.id.sign_in);
        btnRegister = findViewById(R.id.register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btnInicio.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void login(boolean isAuthorized) {
        if (isAuthorized) startActivity(new Intent(LoginActivity.this, Activity_menu.class));
        else Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void register(User user) {
        Toast.makeText(this, "User registered", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in:
                presenter.login(new User(username.getText().toString(), password.getText().toString()));
                break;
            case R.id.register:
                presenter.register(new User(username.getText().toString(), password.getText().toString()));
                break;

        }
    }
}
