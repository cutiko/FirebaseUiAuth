package cl.cutiko.firebaseuiauth;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

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

    }
}
