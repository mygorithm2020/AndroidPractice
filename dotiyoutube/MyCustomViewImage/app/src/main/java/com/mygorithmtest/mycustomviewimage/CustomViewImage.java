package com.mygorithmtest.mycustomviewimage;

import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomViewImage extends View {

    Paint paint;
    Bitmap cachebitmap;
    Canvas cacheCanvas;

    public CustomViewImage(Context context) {
        super(context);

        init(context);
    }

    public CustomViewImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public  void init(Context context){
        paint = new Paint();
    }

    // 뷰의 크기가 변경될때
    // 미리 메모리에 그려놓기 위해서
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        createCacheBitmap(w, h);
        testDrawing();
    }

    public void createCacheBitmap(int w, int h) {
        cachebitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        cacheCanvas = new Canvas();
        cacheCanvas.setBitmap(cachebitmap);
    }

    public void testDrawing(){
        Bitmap srcImg = BitmapFactory.decodeResource(getResources(), R.drawable.wifi4);
        cacheCanvas.drawBitmap(srcImg, 100, 100, paint);

        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);
        Bitmap inverseBitmap = Bitmap.createBitmap(srcImg, 0, 0, srcImg.getWidth(), srcImg.getHeight(), matrix, false);
        cacheCanvas.drawBitmap(inverseBitmap, 300, 300, paint);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (cachebitmap !=null) {
            canvas.drawBitmap(cachebitmap, 0, 0, null);
        }

    }
}
