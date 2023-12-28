package com.mygorithmtest.myview;

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
    public MyButton(@NonNull  Context context) {
        super(context);

        init(context);
    }

    // 이 버튼을 가지고 우리가 xml로 화면을 구성하니까 그 안에 MyButton을 추가할때 속성들이 넘어옴
    public MyButton(@NonNull  Context context, @Nullable  AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);

        // sp 단위를 생성후 가져올 수 있음 xml 파일에서 단위를 가져오는것 이런식으로 하면 밑에 px단위로 자동으로 바꿔서 넣어줌
        float testSize = getResources().getDimension(R.dimen.text_size);
        // px 단위임
        setTextSize(testSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("Mybutton", "onDraw 호출됨");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Mybutton", "onTouchEvent 호출됨");

        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);
                break;
        }
        invalidate();
        return  true;
    }
}
