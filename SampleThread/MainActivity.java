package org.techtown.thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int value = 0;

    TextView textView;
    MainHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();
            }
        });
        handler = new MainHandler();
    }

    class BackgroundThread extends Thread {

        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                value += 1;
                Log.d("Thread", "value : " + value);

                Message message = handler.obtainMessage(); //obtainMessage를 호출하면 메시지 객체를 반환받는다.
                Bundle bundle = new Bundle(); //key value 형태 데이터를 담을 수 있다.
                bundle.putInt("value", value);
                message.setData(bundle);

                handler.sendMessage(message); //메시지 큐에 넣기
            }
        }


    }

    class MainHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) { //callback 메소드. sendMessage를 호출하면 handleMessage가 호출된다.
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            textView.setText("value 값 : " + value);
        }
    }
}