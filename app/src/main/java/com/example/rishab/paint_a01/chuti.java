package com.example.rishab.paint_a01;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class chuti extends AppCompatActivity {

    public void goback(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuti);
//
////        ImageView imageView = (ImageView)findViewById(R.id.gif);
////
////        //Glide.with(this).load("https://68.media.tumblr.com/1bae93b70c1543b1a637eb352d5721a9/tumblr_ohxv2nYLdE1ufw8o4o1_500.gif").into(imageView);
////        Glide.with(this)
////                .load(R.drawable.win2)
////                .diskCacheStrategy(DiskCacheStrategy.ALL)
////                .into(imageView);
//
//
//        VideoView videoView =(VideoView)findViewById(R.id.videoView1);
//
//        //Creating MediaController
//        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
//
//        //specify the location of media file
//
//        //Setting MediaController and URI, then starting the videoView
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.start();

        GifImageView g1 = (GifImageView) findViewById(R.id.g1);
        GifImageView g2 = (GifImageView) findViewById(R.id.g2);
        GifImageView g3 = (GifImageView) findViewById(R.id.g3);

        GifImageView g4 = (GifImageView) findViewById(R.id.g4);
        GifImageView g5 = (GifImageView) findViewById(R.id.g5);


        g1.setVisibility(View.INVISIBLE);
        g2.setVisibility(View.INVISIBLE);
        g3.setVisibility(View.INVISIBLE);

        g4.setVisibility(View.INVISIBLE);
        g5.setVisibility(View.INVISIBLE);

        if(constant.mode == 1) {


            // RANDOMISE KARNA HAI 0 SE T TAK
            Random r = new Random();
            int i1 = r.nextInt(3);

            switch (i1) {
                case 0:
                    g1.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    g2.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    g3.setVisibility(View.VISIBLE);
                    break;
            }

        }

        if(constant.mode == 0) {


            // RANDOMISE KARNA HAI 0 SE T TAK
            Random r = new Random();
            int i1 = r.nextInt(2);

            switch (i1) {
                case 0:
                    g4.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    g5.setVisibility(View.VISIBLE);
                    break;
            }

        }

        CountDownTimer C = new CountDownTimer(3000 , 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                constant.mode=100;
                goback();
                finish();
            }
        }.start();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
