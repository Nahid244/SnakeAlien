package com.example.rohim;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Looper;
import android.renderscript.Font.Style;
import android.text.TextPaint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class GamePanel  extends SurfaceView implements SurfaceHolder.Callback{
    
	private OneThread thread;
	 public Dataabase db;
	public int timecount=0;
	public int timecount1=3000;
	String s,s1;
	boolean eggredhit=false;

	//private Sounds sound;
	Backgrnd back;
	float touchx=-10;
	float touchy=-10;
	  // boolean playerrun=true;
	 public MediaPlayer[] mp;
	   Wall wall;
	   int eggcount=-1;
	   int eggcatch=0;
	   int bestscore;
	   boolean monstaregg=false;
	  boolean playerwin=false;
	  boolean notskip=true; 
	  
	   TextPaint p1;
	   int frametick=0;
	   
	   Nayok nyk;
	   
	   Monstar1 monstar1;
	   Monstar2 monstar2;
	   
	   Bitmap dm;
	   Bitmap sdb;
	   Bitmap sdl;
	   Bitmap sdr;
	   Bitmap sdu;
	   Bitmap shadow;
	   Bitmap score;
	  Bitmap playpausebit;
	  Bitmap playbit;
	  Bitmap scoreboardbit;
	  Bitmap homebit; 
	  Bitmap eggredbit;
	  
	   public Bitmap[] mn=new Bitmap[96];
	   public Bitmap[] mn1=new Bitmap[80];
	   ArrayList<Dim> egg=new ArrayList<Dim>();
	   Dim eggred;
	   ArrayList<Monstar1> monstar11=new ArrayList<Monstar1>();
	   ArrayList<Sword> srd=new ArrayList<Sword>();
	   
	   
	   public CustomButton playpausebut;
	   public CustomButton homebut;
	   public ScoreBoard scoreboard;
	   //ArrayList<DimCollect> egg1=new ArrayList<DimCollect>();
	
	   
	  
	   
	   
	   
	public GamePanel( Context context, Dataabase db,MediaPlayer[] mp){
         super(context);
		this.db=db;
		this.mp=mp;
		getHolder().addCallback(this);
		thread=new OneThread(getHolder(),this);
		//sound=new Sounds(context);
		
		 dm=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.dim,191,191), Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30, true);
		 eggredbit=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.dimred, Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30, true);
		 scoreboardbit=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.scoreboard, Constants.SCREEN_WIDTH/2,Constants.SCREEN_HEIGHT/2), Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, true);
		 playpausebit=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.pausebut, Constants.SCREEN_WIDTH/15,Constants.SCREEN_HEIGHT/15), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
		 homebit=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.homebut, Constants.SCREEN_WIDTH/15,Constants.SCREEN_HEIGHT/15), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
		 playbit=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.playbut, Constants.SCREEN_WIDTH/15,Constants.SCREEN_HEIGHT/15), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
		 playpausebut=new CustomButton(Constants.SCREEN_WIDTH/15,Constants.SCREEN_HEIGHT/15);
		playpausebut.setBitmap(playpausebit);
		playpausebut.setPosition(0, 0);
		
		
		 
		 shadow=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.shadow1,Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/22, Constants.SCREEN_HEIGHT/35, true);
		 score=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.score,Constants.SCREEN_WIDTH/5, Constants.SCREEN_HEIGHT/15), Constants.SCREEN_WIDTH/5, Constants.SCREEN_HEIGHT/15, true);
		//en=new Entity(context);
		 sdl=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.swordleft,Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/35, Constants.SCREEN_HEIGHT/25, true);
		 sdb=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.swordbottom,Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/35, Constants.SCREEN_HEIGHT/25, true);
		 sdu=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.swordup,Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/35, Constants.SCREEN_HEIGHT/25, true);
		 sdr=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.swordright,Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30), Constants.SCREEN_WIDTH/35, Constants.SCREEN_HEIGHT/25, true);
		 for(int k=1;k<=24;k++){
				String s1="wb"+k;
				mn[k-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s1, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
				String s2="wl"+k;
				mn[k+24-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s2, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
				String s3="wr"+k;
				mn[k+48-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s3, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
				String s4="wu"+k;
				mn[k+72-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s4, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
				
				
			}
		 for(int k=1;k<=20;k++){
				String s1="db"+k;
				mn1[k-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s1, R.drawable.class),Constants.SCREEN_WIDTH/8,Constants.SCREEN_HEIGHT/8), Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, true);
				String s2="dl"+k;
				mn1[k+20-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s2, R.drawable.class),Constants.SCREEN_WIDTH/8,Constants.SCREEN_HEIGHT/8), Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, true);
				String s3="dr"+k;
				mn1[k+40-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s3, R.drawable.class),Constants.SCREEN_WIDTH/8,Constants.SCREEN_HEIGHT/8), Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, true);
				String s4="du"+k;
				mn1[k+60-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s4, R.drawable.class),Constants.SCREEN_WIDTH/8,Constants.SCREEN_HEIGHT/8), Constants.SCREEN_WIDTH/8, Constants.SCREEN_HEIGHT/8, true);
				
				
			}
		 
		scoreboard=new ScoreBoard(scoreboardbit); 
		back=new Backgrnd(context);
		wall=new Wall(context);
		nyk=new Nayok(context,shadow);
		p1=new TextPaint();
		p1.setColor(Color.BLACK);
		p1.setTypeface(Typeface.create("Arial", Typeface.BOLD));
		
		p1.setTextSize(Constants.SCREEN_HEIGHT/15);
		
		
		homebut=new CustomButton(Constants.SCREEN_WIDTH/15,Constants.SCREEN_HEIGHT/15);
			homebut.setBitmap(homebit);
			//homebut.setPosition(scoreboard.x, scoreboard.y);
			homebut.setPosition(scoreboard.x+scoreboardbit.getWidth()/2+scoreboardbit.getWidth()/3,Constants.SCREEN_HEIGHT/2+scoreboardbit.getHeight()/4);
		
		eggred=new Dim(eggredbit);
		Constants.playchk=true;
	// monstar1=new Monstar1(mn);
	// monstar2=new Monstar2(mn1);
		
		
		bestscore=db.getScore();
		
		
		
		setFocusable(true);
		
	}
	
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		 
			   
		        Constants.running=true;
		        thread.start();
		        //thread.start();
		   
	}
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
		
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry=true;
		while(retry){
			Log.d("dfdf", "i am roh");
			try{	
			 Constants.running=false;
				thread.join();
				retry=false;
			}catch(Exception e){}
		}
		Log.d("sdsd", "Thread was shut down cleanly"+retry);
		Constants.staticset();
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		touchx=event.getX();
		touchy=event.getY();
		return super.onTouchEvent(event);
	}


	
	


	public void update(Canvas canvas){
		if(Constants.playerrun && Constants.playchk ){
			mp[1].setAudioStreamType(AudioManager.STREAM_MUSIC);
			mp[1].setVolume(0.06f, 0.06f);
			mp[1].setLooping(true);                                              
			mp[1].start();
		nyk.update();
		//monstar1.update();
		for(int i=0;i<egg.size();i++){
			if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, dm, egg.get(i).dmx, egg.get(i).dmy)){
				egg.remove(i);
               Constants.dimheat=true;
				eggcount--;
				eggcatch++;
				monstaregg=true;
				mp[0].setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp[0].setVolume(0.4f, 0.4f);
				mp[0].setLooping(false);                                              
				mp[0].start();
				break;
			}
		}
		if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, wall.frontwall,
				wall.frontwall1x, wall.frontwall1y) || Constants.isCollisionDetected(nyk.nayokb[0],
						Constants.nayokx,Constants.nayoky, wall.frontwall,
						wall.frontwall2x, wall.frontwall2y) ){
			//Constants.running=false;
			Constants.playerrun=false;
			
		}
		else if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx, Constants.nayoky, wall.backwall, wall.backwall1x, wall.backwall1y)
				|| Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx, Constants.nayoky, wall.backwall, wall.backwall2x, wall.backwall2y)){
			//Constants.running=false;
			Constants.playerrun=false;
			
		}
		else if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, wall.lefttwall,
				wall.leftwallx, wall.leftwally) || Constants.isCollisionDetected(nyk.nayokb[0],
						Constants.nayokx,Constants.nayoky, wall.rightwall,
						Constants.rightwallx, Constants.rightwally) ){
			//Constants.running=false;
			Constants.playerrun=false;
			
		}
          for(int i=0;i<monstar11.size();i++){
        	  monstar11.get(i).update();
          }
		frametick++;
		
		
		if(frametick==1000){
			monstar2=new Monstar2(mn1,shadow);
			if(monstar2.mnbottom){
				srd.add(new Sword(sdb,monstar2.x,monstar2.y+sdb.getHeight(),2));
			}else if(monstar2.mnup){
				srd.add(new Sword(sdu,monstar2.x,monstar2.y-sdu.getHeight(),4));
			}else if(monstar2.mnleft){
				srd.add(new Sword(sdr,monstar2.x+sdl.getWidth(),monstar2.y,1));
			}
			else if(monstar2.mnright){
				srd.add(new Sword(sdl,monstar2.x-sdr.getWidth(),monstar2.y,3));
			}
		}
		
		
		if(monstar2!=null && monstar2.count<20){
		monstar2.update();
		}else if(monstar2!=null && monstar2.count==20){
			frametick=0;
			monstar2=null;
			
		}
		for(int i=0;i<srd.size();i++){
			if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, sdl, srd.get(i).mnx, srd.get(i).y)){
				//Constants.running=false;
				mp[4].setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp[4].setVolume(0.5f, 0.5f);
				mp[4].setLooping(false);                                              
				mp[4].start();
				Constants.playerrun=false;
				
				break;
			}
			
		}
		for(int i=0;i<srd.size();i++){
			//if(srd.get(i).mnx<Constants.backx || srd.get(i).mnx>Constants.backx+back.back.getWidth() || srd.get(i).y<0 || srd.get(i).y>Constants.SCREEN_HEIGHT){
			//	srd.remove(i);
			if(srd.get(i).direction==1 && srd.get(i).mnx>Constants.backx+back.back.getWidth() ){
				srd.remove(i);
			}
			else if(srd.get(i).direction==2 && srd.get(i).y>Constants.SCREEN_HEIGHT){
				srd.remove(i);
			}
			else if(srd.get(i).direction==3 && srd.get(i).mnx<Constants.backx){
				srd.remove(i);
			}
			else if(srd.get(i).direction==4 &&  srd.get(i).y<0){
				srd.remove(i);
			}
				 
			//}
		}
		
		for(int i=0;i<monstar11.size();i++){
			if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, mn[0], monstar11.get(i).mnx, monstar11.get(i).mny)){
				//Constants.running=false;
				mp[2].setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp[2].setVolume(0.5f, 0.5f);
				mp[2].setLooping(false);                                              
				mp[2].start();
				Constants.playerrun=false;
				
				break;
			}
			
		}
		for(int i=0;i<nyk.egg1.size();i++){
			for(int j=0;j<srd.size();j++){
			if(Constants.isCollisionDetected(nyk.dm, nyk.egg1.get(i).x, nyk.egg1.get(i).y,sdl , srd.get(j).mnx, srd.get(j).y)){
				mp[4].setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp[4].setVolume(0.5f, 0.5f);
				mp[4].setLooping(false);                                              
				mp[4].start();
				for(int k=i;k<nyk.egg1.size();k++){
					nyk.egg1.remove(k);
					eggcatch--;
				}
				
				break;
			}
			}
			
		}
		for(int i=0;i<nyk.egg1.size();i++){
			for(int j=0;j<monstar11.size();j++){
			if(Constants.isCollisionDetected(nyk.dm, nyk.egg1.get(i).x, nyk.egg1.get(i).y, mn[0], monstar11.get(j).mnx, monstar11.get(j).mny)){
				mp[2].setAudioStreamType(AudioManager.STREAM_MUSIC);
				mp[2].setVolume(0.5f, 0.5f);
				mp[2].setLooping(false);                                              
				mp[2].start();
				for(int k=i;k<nyk.egg1.size();k++){
					nyk.egg1.remove(k);
					eggcatch--;
					
				}
				break;
			}
			}
			
		}
		timecount++;
		if(timecount>10 && wall.leftwally>Constants.SCREEN_HEIGHT/13){
			 wall.leftwally-=2;
		}
		else if(wall.leftwally<=Constants.SCREEN_HEIGHT/13){
			timecount=0;
		}
		if(Constants.isCollisionDetected(nyk.nayokb[0], Constants.nayokx,Constants.nayoky, eggredbit, eggred.dmx, eggred.dmy)){
			eggredhit=true;
		}
		if(eggredhit && timecount1>0){
			timecount1--;
			wall.leftwally=Constants.SCREEN_HEIGHT/2;
		}else if(timecount1==0){
			wall.leftwally=Constants.SCREEN_HEIGHT/13;
			Constants.playerrun=false;
			notskip=true;
		}
		
		}
		if(notskip){
		if(Constants.playerrun && eggredhit && Constants.nayokx<-Constants.SCREEN_WIDTH/15){
			playerwin=true;
		}
		}
		
	
		
//		for(int i=0;i<srd.size();i++){
//			srd.get(i).update();
//		}
}
	
	public void draw(Canvas canvas){
		
		back.draw(canvas);
		if(Constants.playerrun){
			if(Constants.playchk){
			back.update();
			wall.update();
			}
		nyk.draw1(canvas);
		if(monstar2!=null){
		monstar2.draw1(canvas);
		}
		for(int i=0;i<monstar11.size();i++){
			monstar11.get(i).draw1(canvas);
		}
		}
		wall.draw(canvas);
		playpausebut.draw(canvas);
		if(eggredhit){
		canvas.drawBitmap(score,Constants.SCREEN_WIDTH-dm.getWidth()*6,0 , null);
		//canvas.drawRect(Constants.SCREEN_WIDTH-dm.getWidth()*6, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT/15, p1);
		//canvas.drawBitmap(dm,Constants.SCREEN_WIDTH-dm.getWidth()*6,0 , null);
		String s=String.valueOf(timecount1/100);
		canvas.drawText(s, Constants.SCREEN_WIDTH-dm.getWidth()*4, Constants.SCREEN_HEIGHT/20, p1);
		}
		if(Constants.playerrun){
		nyk.draw(canvas);
		if(monstar2!=null && monstar2.count<20){
			monstar2.draw(canvas);
			}
		 
			for(int i=0;i<srd.size();i++){
				srd.get(i).draw(canvas);
			
		  }
		if(eggcount<10 && !eggredhit){
		egg.add(new Dim(dm));
		eggcount++;
		
		}
		
		if(eggcatch%3==0 && monstaregg){
			monstar11.add(new Monstar1(mn,shadow));
			monstaregg=false;
		}
		if(!eggredhit){
		eggred.draw(canvas);
		for(int i=0;i<egg.size();i++){
			egg.get(i).draw(canvas);
		}
		}
		else if(eggredhit){
			eggred.x=-100;
			eggred.y=-100;
			for(int i=0;i<egg.size();i++){
				egg.remove(i);
			}
		}
		
		for(int i=0;i<monstar11.size();i++){
			monstar11.get(i).draw(canvas);
		}
		//monstar1.draw(canvas);
		
		
		//postInvalidate();
	}
		if(playpausebut.btn_rect.contains(touchx, touchy) && Constants.playchk){
			playpausebut.setBitmap(playbit);
			Constants.playchk=false;
			touchx=-10;
			touchy=-10;
			
		}
		else if(playpausebut.btn_rect.contains(touchx, touchy) && Constants.playchk==false){
			playpausebut.setBitmap(playpausebit);
			Constants.playchk=true;
			touchx=-10;
			touchy=-10;
		}
		if(!Constants.playerrun && notskip){
			
			scoreboard.draw(canvas);
			scoreboard.update();
			
			//homebut.setPosition(scoreboard.x+scoreboardbit.getWidth()/2+scoreboardbit.getWidth()/3,scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4);
			if(scoreboard.y>=Constants.SCREEN_HEIGHT/4){
			homebut.draw(canvas);
			}
			//String s=String.valueOf(eggcatch);
	//		canvas.drawText("Score : "+s, scoreboard.x, scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4, p1);
	//		canvas.drawText("Best   : "+s, scoreboard.x, scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4+scoreboardbit.getHeight()/6, p1);
			canvas.drawText("You Loose :V", scoreboard.x+scoreboardbit.getWidth()/3, scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4, p1);
			if(homebut.btn_rect.contains(touchx, touchy)){
				mp[0].stop();
				mp[1].stop();
				mp[2].stop();
				mp[3].stop();
				mp[4].stop();
				 Constants.running=false;
				 Intent i = new Intent().setClass(getContext(), MainActivity.class);
				  ((Activity) getContext()).startActivity(i);
				  ((Activity) getContext()).finish();
			 
		
		}
			
		}
		else if(playerwin){
			
			if(bestscore==0){
				db.addScore(eggcatch);
				s=String.valueOf(eggcatch);
				s1=String.valueOf(eggcatch);
			}
			else{
				if(bestscore>eggcatch){
					s=String.valueOf(eggcatch);
					s1=String.valueOf(bestscore);
				}else {
					db.updatescore(bestscore, eggcatch);
					s=String.valueOf(eggcatch);
					s1=String.valueOf(eggcatch);
				}
			}
			Constants.playerrun=false;
			notskip=false;
			scoreboard.draw(canvas);
			scoreboard.update();
			
			
			if(scoreboard.y>=Constants.SCREEN_HEIGHT/4){
			homebut.draw(canvas);
			}
			 
			canvas.drawText("Score : "+s, scoreboard.x, scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4, p1);
			canvas.drawText("Best   : "+s1, scoreboard.x, scoreboard.y+scoreboardbit.getHeight()/2+scoreboardbit.getHeight()/4+scoreboardbit.getHeight()/6, p1);
			
			if(homebut.btn_rect.contains(touchx, touchy)){
				mp[0].stop();
				mp[1].stop();
				mp[2].stop();
				mp[3].stop();
				mp[4].stop();
				 Constants.running=false;
				 eggredhit=false;
				 Intent i = new Intent().setClass(getContext(), MainActivity.class);
				  ((Activity) getContext()).startActivity(i);
				  ((Activity) getContext()).finish();
			 
		
		}
			
			
			
		}
		
		
		
		
		
	}
	
	
	}
	
	
