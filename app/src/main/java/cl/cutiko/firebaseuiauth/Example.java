package cl.cutiko.firebaseuiauth;

import android.animation.Animator;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import java.lang.reflect.Field;

public class Example {

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
    }
}
