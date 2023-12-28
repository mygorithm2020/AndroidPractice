package com.mygorithmtest.mymultitouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class ImageDisplayView extends View {

    private static final String TAG = "ImageDisplay";

    Paint paint;
    Matrix matrix;
    Canvas mCanvas;
    Bitmap mBitmap;

    int lastX;
    int lastY;

    float displayWidth = 0.0F;
    float displayHeight = 0.0F;

    int displayCenterX = 0;
    int displayCenterY = 0;

    public float startX;
    public float startY;

    float oldDistance = 0.0F;

    int oldPointerCount = 0;
    boolean isScrolling = false;
    float distanceThreshold = 3.0F;

    float scaleRatio;
    float totalScaleRatio;

    public ImageDisplayView(Context context) {
        super(context);

        init(context);
    }

    public ImageDisplayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        paint = new Paint();
        matrix = new Matrix();

        lastX = -1;
        lastY = -1;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w>0 && h>0) {
            newImage(w, h);
        }
    }
    public void newImage(int width, int height) {
        Bitmap img = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(img);

        mBitmap = img;
        mCanvas = canvas;

        displayWidth = (float)width;
        displayHeight = (float) height;

        displayCenterX = width/2;
        displayCenterY = height/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, 0, 0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getAction();

        // 터치 갯수 세는것
        int pointerCount = event.getPointerCount();
        Log.d(TAG, "pointer Count : " + pointerCount);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (pointerCount == 1) {
                    float curX = event.getX();
                    float curY = event.getY();

                    startX = curX;
                    startY = curY;
                } else if (pointerCount == 2) {
                    oldDistance = 0.0F;
                    isScrolling = true;
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if (pointerCount == 1) {
                    if (isScrolling) {
                        return true;
                    }
                    float curX = event.getX();
                    float curY = event.getY();

                    if (startX == 0.0F) {
                        startX = curX;
                        startY = curY;

                        return true;
                    }

                    float offsetX = startX - curX;
                    float offsetY = startY - curY;

                    if (oldPointerCount == 2) {

                    } else {
                        Log.d(TAG, "ACTION_MOVE : " + offsetX + ", " + offsetY);

                        if (totalScaleRatio > 1.0F) {
                            moveImage(-offsetX, -offsetY);
                        }
                        startY = curY;
                        startX = curX;
                    }


                } else if (pointerCount ==2) {
                    float x1 = event.getX(0 );
                    float y1 = event.getY(0 );
                    float x2 = event.getX(1 );
                    float y2 = event.getY(1 );

                    float dx = x1- x2;
                    float dy = y1 - y2;
                    //float distance = new Double(Math.sqrt(new Float(dx*dx + dy*dy)));

                    float outScaleRatio = 0.0F;
                    // 여기서부턴 더 못쓰겠다 너무 많네;;; 약 3분쯤
                }

            case MotionEvent.ACTION_UP:
                lastY = -1;
                lastX = -1;
                break;

        }
    }
}
