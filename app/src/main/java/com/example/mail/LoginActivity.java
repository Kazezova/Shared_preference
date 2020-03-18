package com.example.mail;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    String name, password;
    private Button button;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button=findViewById(R.id.login);
        final EditText text1 = findViewById(R.id.userName);
        final EditText text2=findViewById(R.id.userPassword);
        sp = getSharedPreferences("login",MODE_PRIVATE);

//        if(sp.getBoolean("logged",false)){
//            openMainActivity();
//        }
        if(sp.contains("userName") && sp.contains("userPassword")){
            openMainActivity();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=text1.getText().toString();
                password=text2.getText().toString();
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("userName",name);
                editor.putString("userPassword",password);
                editor.apply();
                openMainActivity();
//                sp.edit().putBoolean("logged",true).apply();
            }
        });
    }
    public void openMainActivity(){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
