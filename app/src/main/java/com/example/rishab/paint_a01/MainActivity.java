package com.example.rishab.paint_a01;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Build;
        import android.os.CountDownTimer;
        import android.speech.tts.TextToSpeech;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    TextView sc ;
    ImageView play ;
    SharedPreferences sharedPreferences;
    TextToSpeech ttsobject;
    //SHARED PREFERANCES KA KAAM HAI YEAH
    int HIGHSCORE = 0;
    CountDownTimer timer;

    public void goToCanvas(View view){

        Intent i=new Intent(this,second.class);
        finish();
        startActivity(i);


    }

    public void setHighScore()
    {
        String HighScore = sharedPreferences.getString("highscore","");
        HIGHSCORE = Integer.parseInt(HighScore);
    }

  /*  public void addHighScore()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        HIGHSCORE++;
        editor.putString("highscore",Integer.toString(HIGHSCORE));
        editor.commit();
    }*/
    //SHARED PREFERANCES KA KAAM KHATAM


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Score S=new Score();
        if(Score.apprun)
            S.Speech(this," Hello Kid ");
        Score.apprun=false;
        setContentView(R.layout.activity_main);
        sc = (TextView)findViewById(R.id.score1);
        play = (ImageView)findViewById(R.id.play);

        //SHARED PREFERANCES KA KAAM SHURU

        sharedPreferences = this.getSharedPreferences("com.example.rishab.paint_a01",Context.MODE_PRIVATE);

        if( !sharedPreferences.contains("highscore") )
        {
            sharedPreferences.edit().putString("highscore","0").apply();

        }
        setHighScore();
        //TEXT TO SPEECH WORK IS DONE HERE


        //TEXT TO SPEECH WORK ENDS HERE

        sc.setText(Integer.toString(HIGHSCORE));
        //Toast.makeText(this,Integer.toString(HIGHSCORE), Toast.LENGTH_SHORT).show();
       // addHighScore();
        //SHARED PREFERACES KA KAAM KHATAM


    }

}