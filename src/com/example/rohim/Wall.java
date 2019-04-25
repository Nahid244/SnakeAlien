package com.example.rohim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Wall {
     public Bitmap frontwall;
     public int frontwall1x;
     public int frontwall1y;
     public int frontwall2x;
     public int frontwall2y;
     
     public Bitmap backwall;
     public int backwall1x;
     public int backwall1y;
     public int backwall2x;
     public int backwall2y;
     
     
     public Bitmap lefttwall;
     public int leftwallx;
     public int leftwally;
     
     
     public Bitmap rightwall;
//     public int rightwallx;
//     public int rightwally;
     
     
     public Wall(Context context){
    	 frontwall=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.deal,500,72), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT/10, true);
    	 backwall=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.deal1,500,72), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT/10, true);
    	 lefttwall=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.deall,72,500), Constants.SCREEN_HEIGHT/10, Constants.SCREEN_HEIGHT, true);
    	 rightwall=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.dealr,72,500), Constants.SCREEN_HEIGHT/10, Constants.SCREEN_HEIGHT, true);
    	 frontwall1x=0;
    	 frontwall1y=-Constants.SCREEN_HEIGHT/50;
    	 frontwall2x=Constants.SCREEN_WIDTH;
    	 frontwall2y=-Constants.SCREEN_HEIGHT/50;
    	 
    	 backwall1x=0;
    	 backwall1y=Constants.SCREEN_HEIGHT-Constants.SCREEN_HEIGHT/7;
    	 backwall2x=Constants.SCREEN_WIDTH;
    	 backwall2y=Constants.SCREEN_HEIGHT-Constants.SCREEN_HEIGHT/7;
    	 
    	 leftwallx=-Constants.SCREEN_HEIGHT/50;
    	 //leftwally=Constants.SCREEN_HEIGHT/13;
    	 leftwally=Constants.SCREEN_HEIGHT/2;
    	 
    	 Constants.rightwallx=Constants.SCREEN_WIDTH*2-Constants.SCREEN_WIDTH/25;
    	 Constants.rightwally=0;
    	 
     }
     public void draw(Canvas canvas){
    	 canvas.drawBitmap(frontwall,frontwall1x,frontwall1y,null);
    	 canvas.drawBitmap(frontwall, frontwall2x,frontwall2y ,null);
    	 
    	 canvas.drawBitmap(lefttwall, leftwallx, leftwally,null);
    	 canvas.drawBitmap(rightwall, Constants.rightwallx, Constants.rightwally,null);
    	 
    	 canvas.drawBitmap(backwall, backwall1x, backwall1y,null);
    	 canvas.drawBitmap(backwall, backwall2x, backwall2y,null);
    	
    	 
     }
     public void update(){
    	 if(Constants.backrightchk==true && Constants.rightwallx>Constants.SCREEN_WIDTH-Constants.SCREEN_WIDTH/25){
    		 frontwall1x-=2;
    		 frontwall2x-=2;
    		 backwall1x-=2;
    		 backwall2x-=2;
    		 leftwallx-=2;
    		 Constants.rightwallx-=2;
    		 
    	 }
    	 else if(Constants.backleftchk==true && leftwallx<Constants.SCREEN_WIDTH/25){
    		 frontwall1x+=2;
    		 frontwall2x+=2;
    		 backwall1x+=2;
    		 backwall2x+=2;
    		 leftwallx+=2;
    		 Constants.rightwallx+=2;
    	 }
     }
}
