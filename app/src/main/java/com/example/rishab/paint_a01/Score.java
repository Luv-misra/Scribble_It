package com.example.rishab.paint_a01;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by luv on 7/2/17.
 */

public class Score {

    public static int score=0;
    public static boolean apprun=true;
    TextToSpeech ttsobject;

    public void Speech(Context context,String string){

        final Context This=context;
        final String S=string;
        ttsobject = new TextToSpeech(This, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if( status == TextToSpeech.SUCCESS )
                {
                    ttsobject.setLanguage(Locale.ENGLISH);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(This, "speaking" , Toast.LENGTH_SHORT).show();
                        ttsobject.speak(S,TextToSpeech.QUEUE_FLUSH,null,null);
                    } else {
                        ttsobject.speak(S, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
                else
                {
                    Toast.makeText(This," Text to Speech language ERROR ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
