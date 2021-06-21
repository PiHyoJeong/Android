package org.techtown.sampleactionbar1two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        actionBar.setLogo(R.drawable.home);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int curId = item.getItemId();
       switch(curId){
           case R.id.menu_refresh:
               Toast.makeText(this,"새로고침 메뉴가 선택됐습니다.",Toast.LENGTH_LONG).show();
               break;
           case R.id.menu_search:
               Toast.makeText(this,"검색 메뉴가 선택됐습니다.",Toast.LENGTH_LONG).show();
               break;
           case R.id.menu_settings:
               Toast.makeText(this,"설정 메뉴가 선택됐습니다.",Toast.LENGTH_LONG).show();
               break;
           default:
               break;
       }
       return super.onOptionsItemSelected(item);
    }
}