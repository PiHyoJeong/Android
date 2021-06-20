package org.techtown.doitmissionseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"로그인화면입니다.",Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            EditText inputLogin = findViewById(R.id.inputLogin);
            EditText inputPassword = findViewById(R.id.inputPassword);

            @Override
            public void onClick(View v) {

                    if(inputLogin.getText().toString().equals("")||inputPassword.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),"아이디와 비밀번호를 확인하세요",Toast.LENGTH_LONG).show();


                }else{
                        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                        startActivity(intent);
                    }
            }
        });


    }

}