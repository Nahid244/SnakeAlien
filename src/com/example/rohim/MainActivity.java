package com.example.rohim;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
	private ImageButton setAlarmBut,exitBut,howtoBut;
	private ClickTouch clicktouch = new ClickTouch(); 
	
	ImageView splashView;
    AnimationDrawable anim;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        getActionBar().hide();
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        setAlarmBut=(ImageButton) findViewById(R.id.setalarm);
        exitBut=(ImageButton) findViewById(R.id.two);
        howtoBut=(ImageButton) findViewById(R.id.one);
        clicktouch.setTouch(howtoBut);
        clicktouch.setTouch(setAlarmBut);
        Constants.playerrun=true;
        clicktouch.setClick(setAlarmBut, MainActivity.this, GameActivity.class);
        clicktouch.setTouch(exitBut);
        clicktouch.setClick(howtoBut,MainActivity.this , HowtoActivity.class);
        exitBut.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                
               finish();
            }
        });
//        BitmapDrawable frame1=(BitmapDrawable)getResources().getDrawable(R.drawable.splash1);
//        //frame1.setBounds(0, 0, 4, 4);
//        BitmapDrawable frame2=(BitmapDrawable)getResources().getDrawable(R.drawable.splash2);
//        BitmapDrawable frame3=(BitmapDrawable)getResources().getDrawable(R.drawable.splash3);
//        //frame3.setBounds(0, 0, 4, 4);
//        anim=new AnimationDrawable();
//        anim.addFrame(frame1,30);
//        //anim.addFrame(frame2,30);
//        anim.addFrame(frame3,30);
//        
//        anim.setOneShot(false);
        
        
        
        
        
    }


	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		finish();
		Log.d("sds", "i am rohim");
	}


}