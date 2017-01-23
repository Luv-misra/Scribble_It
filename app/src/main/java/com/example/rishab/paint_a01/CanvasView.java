package com.example.rishab.paint_a01;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.hardware.Camera;
import android.os.CountDownTimer;
import android.os.Process;
import android.text.LoginFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.start;

public class CanvasView extends View{

    int color_change_tracker;
    boolean again=true;
    public Bitmap mBitmap;
    float width = 7 ;
    public Canvas mCanvas;
    private Path mPath;
    private float mx, my;
    private static final float TOLERANCE =5;
    Context context;
    private Paint mPaint;
    public ArrayList<String> COLORS = new ArrayList<String>();
    public ArrayList<Path> PATHS = new ArrayList<Path>();
    public ArrayList<Paint> PAINTS = new ArrayList<Paint>();
    CountDownTimer countdowntimer;
    int shut_down_the_app;

    public void new_paint( )
    {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(width);
        mPaint.setColor(Integer.parseInt(COLORS.get(color_change_tracker++)));
        if(color_change_tracker>5)
        {
            color_change_tracker=0;
        }
    }
    public void control_timer( )
    {
          countdowntimer =  new CountDownTimer( 3000+100 , 3000 ) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    Log.i(" TAG ", " into finish ");
                    shut_down_the_app++;
                    if( shut_down_the_app >=2 )
                    {
                        countdowntimer.cancel();
                        Log.i(" TAG ", " ending this work ");


                        if(color_change_tracker!=0 && color_change_tracker!=1){
                            color_change_tracker-=2;
                        }else if(color_change_tracker==0){
                            color_change_tracker=4;
                        }else{
                            color_change_tracker=5;
                        }


                        Intent i = new Intent(getContext(), guessing.class);
                        i.putExtra("color",color_change_tracker);
                        context.startActivity(i);
                        Log.i(" TAG ", " returning from here " + Integer.toString(color_change_tracker));
                        return;
                    }
                    else if( mPath.isEmpty() )
                    {
                        Log.i("TAG", " path empty ");
                    }
                    else
                    {
                        shut_down_the_app = 0;
                        Log.i("TAG", " path NOT empty ");
                        PATHS.add(mPath);
                        PAINTS.add(mPaint);
                        mPaint = new Paint();
                        mPath = new Path();
                        new_paint();
                        if( PATHS.size()>1 )
                        {
                            PATHS.remove(0);
                            PAINTS.remove(0);
                        }
                    }
                    control_timer();
                }
          }.start();


    }


    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        shut_down_the_app=0;
        color_change_tracker=0;
        mPath= new Path();
        mPaint= new Paint();
        shut_down_the_app=0;
        COLORS.add(Integer.toString(Color.BLUE));
        COLORS.add(Integer.toString(Color.rgb(255,192,203)));
        COLORS.add(Integer.toString(Color.YELLOW));
        COLORS.add(Integer.toString(Color.rgb(255,165,0)));
        COLORS.add(Integer.toString(Color.GREEN));
        COLORS.add(Integer.toString(Color.RED));

        new_paint();
        control_timer();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        mCanvas =new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for( int i=0 ; i<PAINTS.size() ; i++ )
            canvas.drawPath(PATHS.get(i) , PAINTS.get(i));
        canvas.drawPath( mPath , mPaint );
    }

    private void startTouch(float x, float y){
        mPath.moveTo(x,y);
        mx=x;
        my=y;
    }

    private void moveTouch(float x,float y){
        if( mPath.isEmpty() )
        mPath.moveTo(mx,my);
        float dx = Math.abs(x-mx);
        float dy = Math.abs(y-my);
        if(dx >= TOLERANCE || dy >= TOLERANCE){

            mPath.quadTo(mx,my,(x+mx)/2,(y+my)/2);
            mx=x;
            my=y;
        }
    }

    public void clearCanvas(){
        mPath.reset();
        Log.i("TAG", "D");
        color_change_tracker=0;
        mPaint.setColor(Integer.parseInt(COLORS.get(color_change_tracker++)));
        PATHS.clear();
        PAINTS.clear();
        invalidate();
    }

    public void upTouch(){
        mPath.lineTo(mx,my);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if( event == null )
        {
            return false;
        }

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                startTouch(x,y);
                invalidate();
                break;

            case MotionEvent.ACTION_MOVE:
                moveTouch(x,y);
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }
}