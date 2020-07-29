package com.elliott.animtestapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMain extends Fragment {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate( R.layout.fragment_main, container, false );
        button1 = v.findViewById( R.id.button_start_1 );
        button2 = v.findViewById( R.id.button_start_2 );
        button3 = v.findViewById( R.id.button_start_3 );
        button4 = v.findViewById( R.id.button_start_4 );

        // Activity 실행을 위한 인텐트
        final Intent intent = new Intent( Intent.ACTION_VIEW );
        intent.setData(Uri.parse( "http://www.daum.net" ) );

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( intent, ActivityOptions
                        .makeClipRevealAnimation( button1, 0, 0, button1.getMeasuredWidth(), button1.getMeasuredHeight() ).toBundle());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( intent, ActivityOptions.makeScaleUpAnimation(button2, 0, 0, button2.getWidth(), button2.getHeight() ).toBundle() );
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bitmap bitmap = createBitmapFromView( v );
//
//                Bundle b = ActivityOptions.makeThumbnailScaleUpAnimation( v, bitmap ,0, 0 ).toBundle();
//
//                startActivity( intent, b);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                ActivityOptions opt = ActivityOptions.makeCustomAnimation(v1.getContext(), android.R.anim.fade_in, android.R.anim.slide_out_right );
                FragmentMain.this.startActivity(intent, opt.toBundle() );
            }
        } );

        return v;
    }

    private Bitmap createBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap( v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888 );
        Canvas canvas = new Canvas( b );
        if( v instanceof SurfaceView)
        {
            SurfaceView surfaceView = (SurfaceView) v;
            surfaceView.setZOrderOnTop(true);
            surfaceView.draw(canvas);
            surfaceView.setZOrderOnTop(false);
        }
        else
        {
            v.draw(canvas);
        }
        return b;

    }
}
