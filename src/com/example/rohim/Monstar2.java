package com.example.rohim;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Monstar2 {
	 public Bitmap[] mn=new Bitmap[80];
	 
	 public int mnx;
	 public int mny;
	 public boolean mnbottom; 
	 public boolean mnleft; 
	 public boolean mnright; 
	 public boolean mnup; 
	 
	 int x;
	 int y;
	 
	int count=1;
	 
	 int updownleftright;
	 
	 int i=0;
	   int j=0;
	   int b=0;
	   int l=13;
	   int r=25;
	   int u=37;
	 
	   int shadowx;
		 int shadowy;
		 public Bitmap shadow;
	   
	   
	 public Monstar2(Bitmap[] mn,Bitmap shadow){
		 this.mn=mn;
		 this.shadow=shadow;
//		 for(int k=1;k<=24;k++){
//				String s1="wb"+k;
//				mn[k-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s1, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
//				String s2="wl"+k;
//				mn[k+24-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s2, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
//				String s3="wr"+k;
//				mn[k+48-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s3, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
//				String s4="wu"+k;
//				mn[k+72-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s4, R.drawable.class),Constants.SCREEN_WIDTH/10,Constants.SCREEN_HEIGHT/10), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
//				
//				
//			}
		 if(Constants.nayokbottomchk){
		 mnbottom=true;
	 	  mnleft=false;
	 	  mnright=false;
	 	  mnup=false;
//	 	 x=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
//	   	  x+=Constants.SCREEN_WIDTH/40;
	 	  x=Constants.nayokx-Constants.backx;
	 	 y= Constants.SCREEN_HEIGHT/20;
	 	 
	 	  
		 }
		 else if(Constants.nayokleftchk){
			 mnbottom=false;
		 	  mnleft=true;
		 	  mnright=false;
		 	  mnup=false;
		 	  x=Constants.SCREEN_WIDTH/40;
//		 	  y=new Random().nextInt(Constants.SCREEN_HEIGHT-Constants.SCREEN_HEIGHT/3);
//		 	  y+=Constants.SCREEN_HEIGHT/15;
		 	  y=Constants.nayoky;
		 	
		 }
		 else if(Constants.nayokrightchk){
			 mnbottom=false;
		 	  mnleft=false;
		 	  mnright=true;
		 	  mnup=false;
		 	 x=Constants.SCREEN_WIDTH*2-Constants.SCREEN_WIDTH/8;
//		 	 y=new Random().nextInt(Constants.SCREEN_HEIGHT-Constants.SCREEN_HEIGHT/3);
//		 	  y+=Constants.SCREEN_HEIGHT/15;
		 	 y=Constants.nayoky;
		 	  
		 }else if(Constants.nayokupchk){
			 mnbottom=false;
		 	  mnleft=false;
		 	  mnright=false;
		 	  mnup=true;
		 	  x=Constants.nayokx-Constants.backx;
//		 	 x=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
//		   	  x+=Constants.SCREEN_WIDTH/40;
		 	 y= Constants.SCREEN_HEIGHT-Constants.SCREEN_HEIGHT/4;
		 }
		 shadowx=mn[0].getWidth()/3;
		 shadowy=mn[0].getHeight()-mn[0].getHeight()/4;
	 }
	 public void draw(Canvas canvas){
		 if(Constants.playchk){
		 mnx=Constants.backx+x;
		 }
		canvas.drawBitmap(mn[i],mnx,y, null);
	 }
	 public void update(){
		
	  
		   j++;
		   if(j==5){
			   j=0;
			   count++;
			   if(mnbottom){
				  b++;
				  b=b%20;
				  i=b;
				   
			   }else if(mnright){
				   l++;
				   l=20+l%20;
				   i=l;
			   }else if(mnleft){
				   r++;
				   r=40+r%20;
				   i=r;
			   }else if(mnup){
				   u++;
				   u=60+u%20;
				   i=u;
			   }
		   }
		   
	   }
	 public void draw1(Canvas canvas){
		 canvas.drawBitmap(shadow, mnx+shadowx, y+shadowy, null);
	 }
}

