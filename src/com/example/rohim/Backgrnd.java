package com.example.rohim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Backgrnd {
   public Bitmap back;
  // public int posx=0;
   public Backgrnd(Context context){
	   back=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.back,1000,500), Constants.SCREEN_WIDTH*2, Constants.SCREEN_HEIGHT, true);
   }
   public void draw(Canvas canvas){
	   canvas.drawBitmap(back, Constants.backx, 0,null);
	   
	   
   }
   public void update(){
	   if(Constants.backrightchk==true ){
		   Constants.backx-=2;
	   }else if(Constants.backleftchk==true ){
		   Constants.backx+=2;
	   }
   }
}
