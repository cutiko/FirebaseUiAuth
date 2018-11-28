package cl.cutiko.firebaseuiauth;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class Example {

    private Callback callback;



    private void something(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {

            }
        });
        ScrollView scrollView;
        //scrollView.post()

        if (0 == 0) {
            return;
        } else {

        }

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        scrollView.performClick();

        try {
            Field field = View.class.getField(" mOnClickListener");
            View.OnClickListener clickListener = (View.OnClickListener) field.get(scrollView);
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            };


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        scrollView.animate().setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        TextView textView = null;
        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
    }

    interface Callback {
        void done();
    }
}
