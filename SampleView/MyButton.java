package org.techtown.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        setBackgroundColor(Color.CYAN); //background 색상
        setTextColor(Color.BLUE); //text 색상
        float textSize = getResources().getDimension(R.dimen.text_size); //픽셀 단위에서 sp 단위로 바꾸기 위해 변수 설정
        setTextSize(textSize);
    }


    //onMeasure

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //호출되는 시점을 보려면 Log를 출력할 수 있다.
        Log.d("MyButton","onDraw 호출됨");
        //어떤 상황이 되면 직접 그릴 수 있도록 Canvas 객체가 전달된다.

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyButton","onTouchEvent 호출됨");

        //손가락이 눌렀다 떼질 때
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLUE);
                break;
        }
        invalidate(); //화면에 보이는 것이 유효하지 않다는 의미이다. 이걸 호출하면 reDraw 한다.화면을 그릴 때마다 onDraw를 호출한다.
        return true;
    }
}
