package com.example.mail;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {
    private ImageView remove;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        remove=findViewById(R.id.logout);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sp.edit();
                editor.remove("userName");
                editor.remove("userPassword");
                editor.apply();
                openLoginActivity();
            }
        });
        MailListFragment fragmentList=new MailListFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.mailList,fragmentList)
                .commit();
    }
    public void openLoginActivity(){
        Intent intent =new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
