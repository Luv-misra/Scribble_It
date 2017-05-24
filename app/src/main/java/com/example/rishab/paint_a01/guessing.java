package com.example.rishab.paint_a01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class guessing extends AppCompatActivity {


    int current_color;
    ArrayList<String> color;
    ArrayList<Integer> ques ;
    Random num = new Random();
    ImageButton but1;
    ImageButton but2;
    ImageButton but3;
    ImageButton but4;
    String Btn;
    TextView tv;
    int correctButNum;
    SharedPreferences sharedPreferences;
    TextView TV;
    CountDownTimer countdowntimer;
    boolean active=true;

    public void randomAdd(int correctColor){
        for(int i=1;i<=3;i++) {
            int next = num.nextInt(6);
            while (next == correctColor) {
                next = num.nextInt(6);
            }
            ques.add(next);
        }
    }

    public void addHighScore()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("highscore",Integer.toString(Score.score));
        editor.commit();
    }

    public void control_timer( )
    {
        countdowntimer =  new CountDownTimer( 1200 , 1200 ) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {

                Intent I=new Intent(guessing.this,MainActivity.class);
                finish();
                startActivity(I);
            }
        }.start();


    }
    public void matchAns(View view) {
        if(active){
            active=false;
            Vibrator vibrator;
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);
            Score S=new Score();
            Btn = view.getTag().toString();
            //Toast.makeText(this, Btn, Toast.LENGTH_SHORT).show();
            if(Btn.equals(Integer.toString(correctButNum)))
            {

                control_timer();
                Score.score++;
                String HighScore = sharedPreferences.getString("highscore","");
                int HIGHSCORE = Integer.parseInt(HighScore);

                if(Score.score>HIGHSCORE){
                    addHighScore();
                    S.Speech(this,"Congrats New Highscore");
                }
                else
                    S.Speech(this,"Congratulation You Won");
                TV.setText(""+Score.score);

                Toast.makeText(this,"You WON",Toast.LENGTH_LONG).show();
                ImageView iv=(ImageView)findViewById(R.id.imageView4);
                iv.setVisibility(View.VISIBLE);
                AnimationSet as=new AnimationSet(true);

                as.setFillEnabled(true);
                TranslateAnimation anim = new TranslateAnimation(
                        TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
                        TranslateAnimation.RELATIVE_TO_SELF,+0.8f,
                        TranslateAnimation.RELATIVE_TO_PARENT,0.0f,
                        TranslateAnimation.RELATIVE_TO_SELF,-0.5f
                );
                ScaleAnimation anims=new ScaleAnimation(
                        1f,0.2f,1f,0.2f
                );

            /*RotateAnimation rot =new RotateAnimation(
                    RotateAnimation.RELATIVE_TO_PARENT,
            );*/

                anim.setDuration(1000);
                anims.setDuration(1000);
                //rot.setDuration(1500);
                as.addAnimation(anims);
                as.addAnimation(anim);
                //as.addAnimation(rot);
                iv.setAnimation(as);
                //as.setFillAfter(true);
                iv.setVisibility(View.INVISIBLE);



            }
            else{
                S.Speech(this,"Oops You Lost");
                Toast.makeText(this,"You LOST",Toast.LENGTH_LONG).show();
                Intent I=new Intent(guessing.this,MainActivity.class);
                finish();
                startActivity(I);
            }
        }




    }


    public void addImg( int btnnum , int color , int number ){  //(0-3,0-5,1-)

        ImageButton btn=null;

        switch (btnnum){

            case 0:
                btn=but1;break;
            case 1:
                btn=but2;break;
            case 2:
                btn=but3;break;
            case 3:
                btn=but4;break;
        }

        switch(number){

            case 1:
                    if(color==4) {
                        btn.setImageResource(R.drawable.green1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }else if(color==3){
                        btn.setImageResource(R.drawable.orange1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }else if(color==0){
                        btn.setImageResource(R.drawable.blue1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }else if(color==2){
                        btn.setImageResource(R.drawable.yellow1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }else if(color==5){
                        btn.setImageResource(R.drawable.red1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }else if(color==1){
                        btn.setImageResource(R.drawable.pink1);
                        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }

                    break ;

            case 2:

                if(color==4) {
                    btn.setImageResource(R.drawable.green2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink2);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }

                break ;

            case 3:

                if(color==4) {
                    btn.setImageResource(R.drawable.green3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink3);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }

                break ;

            case 4:

                if(color==4) {
                    btn.setImageResource(R.drawable.green4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink4);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }

                break ;

            case 5:

                if(color==4) {
                    btn.setImageResource(R.drawable.green5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink5);
                    btn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }

                break ;



        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        ques = new ArrayList<Integer>();
        TextView tv=(TextView)findViewById(R.id.textView2);

        but1 =(ImageButton)findViewById(R.id.button1);
        but2 =(ImageButton)findViewById(R.id.button2);
        but3 =(ImageButton)findViewById(R.id.button3);
        but4 =(ImageButton)findViewById(R.id.button4);
        color = new ArrayList<String>();

        color.add("blue");
        color.add("pink");
        color.add("yellow");
        color.add("orange");
        color.add("green");
        color.add("red");

        current_color = this.getIntent().getIntExtra("color",0);
        TV=(TextView)findViewById(R.id.score);
        sharedPreferences = this.getSharedPreferences("com.example.rishab.paint_a01",Context.MODE_PRIVATE);
        TV.setText(""+Score.score);
        String colour="";
        switch(current_color) {

            case 0: tv.setBackgroundColor(Color.BLUE);colour="Blue";break;
            case 1: tv.setBackgroundColor(Color.rgb(255,192,203));colour="Pink";break;
            case 2: tv.setBackgroundColor(Color.YELLOW);colour="Yellow";break;
            case 3: tv.setBackgroundColor(Color.rgb(255,165,0));colour="Orange";break;
            case 4: tv.setBackgroundColor(Color.GREEN);colour="Green";break;
            case 5: tv.setBackgroundColor(Color.RED);colour="Red";break;
        }
        Score S=new Score();
        S.Speech(this,"Select "+colour+" Color");
        randomAdd(current_color);

        int b = num.nextInt(4);
        int c = num.nextInt(5)+1;




        for(int j=0,i=0;i<4;i++,j++){

            if(i==b){
                j--;
                correctButNum = b;
                addImg(b,current_color,c);
                continue;
            }

            int temp=num.nextInt(5)+1;
            addImg(i,ques.get(j),temp);

        }
    }

    public void onBackPressed(){
        // do something here and don't write super.onBackPressed()

        Intent I=new Intent(this,MainActivity.class);
        finish();
        startActivity(I);
    }
}
