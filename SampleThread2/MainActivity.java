package org.techtown.thread2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
    }

    class BackgroundThread extends Thread{
        int value = 0;

        public void run() {
            for (int i = 0; i < 100; i++) {
                try {Thread.sleep(1000);} catch (InterruptedException e) {}
                value += 1;
                Log.d("Thread","value : " + value);

                handler.post(new Runnable() { //post 메소드로 전달되는 Runnable 객체는 스레드의 작업 결과물로 만들어지는 데이터를 처리해야한다. 따라서 결과물을 화면에 보여주어야하는 부분이 있을 경우 new 연산자로 Runnable 인터페이스를 구현하는 새로운 객체를 만들어서 사용한다.
                    @Override
                    public void run() {
                        textView.setText("value : " + value);
                    }
                });

            }
        }
    }
}