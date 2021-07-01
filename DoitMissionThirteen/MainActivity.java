package com.techtwon.doitmission_13_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    TextView textView;
    RecyclerView recyclerView;
    PersonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        textView = findViewById(R.id.textView);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new PersonAdapter();

        adapter.addItem(new Person("피아지","1990-01-01","010-1111-1111",R.drawable.img1));
        adapter.addItem(new Person("손아지","1990-11-01","010-1111-1234",R.drawable.img1));


        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택정보 : " + item.getName(),Toast.LENGTH_LONG).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem(new Person(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),R.drawable.img1));
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                textView.setText(adapter.getItemCount()+"명");
            }
        });

        textView.setText(adapter.getItemCount()+"명");

    }
}