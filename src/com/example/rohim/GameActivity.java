package com.example.rohim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity{
    
    public GamePanel gp;
    public Dataabase db;
   // MediaPlayer mp;
    public MediaPlayer[] mp=new MediaPlayer[7];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH=dm.widthPixels;
        Constants.SCREEN_HEIGHT=dm.heightPixels;
		 getActionBar().hide();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
	        
	       db=new Dataabase(this);
		mp[0] = MediaPlayer.create(this,R.raw.dimdhora ); 
		mp[1] = MediaPlayer.create(this,R.raw.aliens ); 
		mp[2] = MediaPlayer.create(this,R.raw.monstarattack ); 
		mp[3] = MediaPlayer.create(this,R.raw.ncrash ); 
		mp[4] = MediaPlayer.create(this,R.raw.sword ); 
		
		gp=new GamePanel(this,db,mp);
		setContentView(gp);
		 
//		 FrameLayout game = new FrameLayout(this);
//	        GamePanel gameView = new GamePanel (this);
//	        LinearLayout gameWidgets = new LinearLayout (this);
//
//	        Button endGameButton = new Button(this);
//	        TextView myText = new TextView(this);
//             
//	        //endGameButton.setLayoutParams (new LayoutParams(50, 50);
//	        endGameButton.setText("Start Game");
//	        myText.setText("rIZ..i");
//	       // endGameButton.setBackgroundResource(R.drawable.db1);
//	       
//	        gameWidgets.addView(myText);
//	        gameWidgets.addView(endGameButton);       
//	        
//	        game.addView(gameView);
//	        game.addView(gameWidgets);

	       // setContentView(game);
		 
		 
		
		gp.setOnTouchListener(new OnSwipeTouchListener(this) {

			
			
//			if(Constants.playchk){
			  @Override
            
			  public void onSwipeDown() {
				  if(Constants.playchk){
				  Toast.makeText(GameActivity.this, "Down", Toast.LENGTH_SHORT).show();
				  Constants.nayokbottomchk=true;
				  Constants.nayokleftchk=false;
				  Constants.nayokrightchk=false;
				  Constants.nayokupchk=false;

			  }
			  }
			  

			  @Override

			  public void onSwipeLeft() {
				  if(Constants.playchk){
				  Toast.makeText(GameActivity.this, "Left", Toast.LENGTH_SHORT).show();
				  Constants.nayokbottomchk=false;
				  Constants.nayokleftchk=true;
				  Constants.nayokrightchk=false;
				  Constants.nayokupchk=false;
				  }
			  }

			  

			  @Override

			  public void onSwipeUp() {
				  if(Constants.playchk){
			    Toast.makeText(GameActivity.this, "Up", Toast.LENGTH_SHORT).show();
			    Constants.nayokbottomchk=false;
				  Constants.nayokleftchk=false;
				  Constants.nayokrightchk=false;
				  Constants.nayokupchk=true;
			  }
			  }
			  

			  @Override

			  public void onSwipeRight() {
				  if(Constants.playchk){
				  Toast.makeText(GameActivity.this, "Right", Toast.LENGTH_SHORT).show();
				  Constants.nayokbottomchk=false;
				  Constants.nayokleftchk=false;
				  Constants.nayokrightchk=true;
				  Constants.nayokupchk=false;
			  }
			  }
		});
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Constants.running=false;
		
		Log.v("sdsd", "i am rohim");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Constants.running=false;
		Constants.staticset();
	}

	@Override
	public void onBackPressed() {
		
		super.onBackPressed();
		mp[0].stop();
		mp[1].stop();
		mp[2].stop();
		mp[3].stop();
		mp[4].stop();
		Intent intent=new Intent(GameActivity.this,MainActivity.class);
		 this.startActivity(intent);
		 intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		 Constants.staticset();
		 
		 finish();
	}
	public void bb(){
		Intent intent=new Intent(GameActivity.this,MainActivity.class);
		 this.startActivity(intent);
		 intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		 Constants.staticset();
		 
		 finish();
	}
	

}
