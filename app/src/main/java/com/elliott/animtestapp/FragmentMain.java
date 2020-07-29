package com.elliott.animtestapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate( R.layout.fragment_main, container, false );
        button1 = v.findViewById( R.id.button_start_1 );
        button2 = v.findViewById( R.id.button_start_2 );
        button3 = v.findViewById( R.id.button_start_3 );

        // Activity 실행을 위한 인텐트
        final Intent intent = new Intent( Intent.ACTION_VIEW );
        intent.setData(Uri.parse( "http://www.daum.net" ) );

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( intent, ActivityOptions.makeClipRevealAnimation( button1, 0, 0, button1.getMeasuredWidth(), button1.getMeasuredHeight() ).toBundle());
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
                Bundle b = ActivityOptions.makeCustomAnimation(  )

                startActivity( intent );
            }
        });

        return v;
    }
}
