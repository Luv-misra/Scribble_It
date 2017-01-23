package com.example.rishab.paint_a01;

import android.content.Context;
import android.graphics.Color;
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



    public void randomAdd(int correctColor){
        for(int i=1;i<=3;i++) {
            int next = num.nextInt(6);
            while (next == correctColor) {
                next = num.nextInt(6);
            }
            ques.add(next);
        }
    }

    public void matchAns(View view) {

        Btn = view.getTag().toString();
        //Toast.makeText(this, Btn, Toast.LENGTH_SHORT).show();
        if(Btn.equals(Integer.toString(correctButNum)))
        {
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
                    }else if(color==3){
                        btn.setImageResource(R.drawable.orange1);
                    }else if(color==0){
                        btn.setImageResource(R.drawable.blue1);
                    }else if(color==2){
                        btn.setImageResource(R.drawable.yelow1);
                    }else if(color==5){
                        btn.setImageResource(R.drawable.red1);
                    }else if(color==1){
                        btn.setImageResource(R.drawable.pink1);
                    }

                    break ;

            case 2:

                if(color==4) {
                    btn.setImageResource(R.drawable.green2);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange2);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue2);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow2);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red2);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink2);
                }

                break ;

            case 3:

                if(color==4) {
                    btn.setImageResource(R.drawable.green3);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange3);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue3);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow3);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red3);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink3);
                }

                break ;

            case 4:

                if(color==4) {
                    btn.setImageResource(R.drawable.green4);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange4);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue4);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow4);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red4);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink4);
                }

                break ;

            case 5:

                if(color==4) {
                    btn.setImageResource(R.drawable.green5);
                }else if(color==3){
                    btn.setImageResource(R.drawable.orange5);
                }else if(color==0){
                    btn.setImageResource(R.drawable.blue5);
                }else if(color==2){
                    btn.setImageResource(R.drawable.yellow5);
                }else if(color==5){
                    btn.setImageResource(R.drawable.red5);
                }else if(color==1){
                    btn.setImageResource(R.drawable.pink5);
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

        switch(current_color) {

            case 0: tv.setBackgroundColor(Color.BLUE);break;
            case 1: tv.setBackgroundColor(Color.rgb(255,192,203));break;
            case 2: tv.setBackgroundColor(Color.YELLOW);break;
            case 3: tv.setBackgroundColor(Color.rgb(255,165,0));break;
            case 4: tv.setBackgroundColor(Color.GREEN);break;
            case 5: tv.setBackgroundColor(Color.RED);break;
        }
        randomAdd(current_color);

        int b = num.nextInt(4);
        int c = num.nextInt(5)+1;




        for(int j=0,i=0;i<4;i++,j++){

            if(i==b){
                j--;
                correctButNum = b;
                //Toast.makeText(getApplicationContext(), Integer.toString(b)+" "+Integer.toString(current_color)+" "+Integer.toString(c), Toast.LENGTH_SHORT).show();
                addImg(b,current_color,c);
                continue;
            }

            int temp=num.nextInt(5)+1;
            addImg(i,ques.get(j),temp);

        }
    }
}
