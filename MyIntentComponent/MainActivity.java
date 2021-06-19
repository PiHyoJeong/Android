package org.techtown.intentcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("org.techtown.intentcomponent",
                        "org.techtown.intentcomponent.MenuActivity");
                intent.setComponent(name);
                startActivityForResult(intent,101);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101){
            if(data != null){
                String name = data.getStringExtra("name");
                if(name!=null){
                    Toast.makeText(this,"응답으로 받은 데이터 : " + name,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}