package com.jdm5908_bw.ist402.gears;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView gear1Img, gear2Img;
    private Gear gear1, gear2;
    private RotateAnimation ra1, ra2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gear1Img = (ImageView) findViewById(R.id.imageView1);
        gear2Img = (ImageView) findViewById(R.id.imageView2);
        button = (Button) findViewById(R.id.button);
        initializeGears();
        initializeAnimations();
    }

    private void initializeGears(){
        gear1 = new Gear();
        gear1.setStartDegree(0);
        gear1.setEndDegree(360);

        gear2 = new Gear();
        gear2.setStartDegree(0);
        gear2.setEndDegree(-360);
    }

    /**
     * Initializes the animations to be used.
     */
    private void initializeAnimations(){
        final int DELAY = 1000;

        ra1 = new RotateAnimation(gear1.getStartDegree(), gear1.getEndDegree(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra1.setDuration(DELAY);
        ra1.setRepeatMode(Animation.RESTART);
        ra1.setRepeatCount(Animation.INFINITE);
        ra1.setFillAfter(true);

        ra2 = new RotateAnimation(gear2.getStartDegree(), gear2.getEndDegree(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra2.setDuration(DELAY);
        ra2.setRepeatMode(Animation.RESTART);
        ra2.setRepeatCount(Animation.INFINITE);
        ra2.setFillAfter(true);
    }

    /**
     * Button click listener.
     * @param view the button.
     */
    public void animateGears(View view){

        animate();
    }

    /**
     * Starts or stops a rotate animation.
     */
    public void animate(){

        if (ra1.hasStarted() && ra2.hasStarted()) {

//            animation1.cancel();
//            animation1.reset();
//            animation2.cancel();
//            animation2.reset();
            gear1Img.clearAnimation();
            gear2Img.clearAnimation();
            initializeAnimations(); // Necessary to restart an animation
            button.setText(R.string.start_gears);
        }
        else{
            gear1Img.startAnimation(ra1);
            gear2Img.startAnimation(ra2);
            button.setText(R.string.stop_gears);
        }
    }
}
