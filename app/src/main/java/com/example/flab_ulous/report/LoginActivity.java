package com.example.flab_ulous.report;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.flab_ulous.API.APIController;
import com.example.flab_ulous.API.APIInstance;
import com.example.flab_ulous.API.Oauth;
import com.example.flab_ulous.preferences.AppPreferences;
import com.example.flab_ulous.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ImageView backButton;
    EditText edUsername, edPassword;
    Button btnLogin;
    String username, password;

    private APIController apiController;
    private AppPreferences appPreferences;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        apiController = APIInstance.getRetrofitInstance().create(APIController.class);
        appPreferences = new AppPreferences(getApplication());

        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.username);

        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edUsername.getText().toString();
                password = edPassword.getText().toString();
                login(username, password);
            }
        });

    }
    private void login(String username, String password) {

        apiController.login(Constants.AUTHORIZATION,username, password).enqueue(new Callback<Oauth>() {
            @Override
            public void onResponse(Call<Oauth> call, Response<Oauth> response) {
                Log.e("on Login Success", "Thumbs up!");
                appPreferences.setIsUserLoggedIn(true);
                startActivity(new Intent(LoginActivity.this,DashBoardActivity.class));
                finish();
            }

            @Override
            public void onFailure(Call<Oauth> call, Throwable t) {
                Log.e("on Login Error", "Thumbs down! " + t.getMessage());
            }
        });
    }
}
