package com.example.rohim;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Monstar1 {
	 public Bitmap[] mn=new Bitmap[96];
	 public Bitmap shadow;
	 public int mnx;
	 public int mny;
	 public boolean mnbottom; 
	 public boolean mnleft; 
	 public boolean mnright; 
	 public boolean mnup; 
	 int shadowx;
	 int shadowy;
	 
	 int x;
	 int y;
	 
	 int randx;
	 int randy;
	 
	 int updownleftright;
	 
	 int i=0;
	   int j=0;
	   int b=0;
	   int l=13;
	   int r=25;
	   int u=37;
	 
	 public Monstar1(Bitmap[] mn,Bitmap shadow){
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
		 x=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
   	  x+=Constants.SCREEN_WIDTH/10;
   	  y=new Random().nextInt(Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/10)*3);
   	  y+=Constants.SCREEN_HEIGHT/10;
   	  
   	randx=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
 	 randx+=Constants.SCREEN_WIDTH/10;
 	  randy=new Random().nextInt(Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/10)*3);
 	  randy+=Constants.SCREEN_HEIGHT/10;
   	  
 	 updownleftright=new Random().nextInt(2);
 	  mny=y;
 	  
 	  mnbottom=true;
 	  mnleft=false;
 	  mnright=false;
 	  mnup=false;
 	  
 	  shadowx=mn[0].getWidth()/4;
 	  shadowy=mn[0].getHeight()-mn[0].getHeight()/6;
 	  
	 }
	 public void draw(Canvas canvas){
		 if(Constants.playchk){
		 mnx=Constants.backx+x;
		 mny=y;
		 
		 if(updownleftright==0){
		 if(x>randx){
			 x-=2;
			 mnbottom=false;
		 	  mnleft=true;
		 	  mnright=false;
		 	  mnup=false;
			 if(x<=randx){
				 randx=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
			   	  randx+=Constants.SCREEN_WIDTH/10;
			   	updownleftright=new Random().nextInt(2);
			 }
		 }
		 else if(x<=randx){
			 x+=2;
			 
			 mnbottom=false;
		 	  mnleft=false;
		 	  mnright=true;
		 	  mnup=false;
			 
			 if(x>=randx){
				 randx=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
			   	  randx+=Constants.SCREEN_WIDTH/10;
			   	updownleftright=new Random().nextInt(2);
			 }
			 
		 }
		 }
		 else if(updownleftright==1){
			 
			 if(y>randy){
				 
				 y-=2;
				 mnbottom=false;
			 	  mnleft=false;
			 	  mnright=false;
			 	  mnup=true;
				 if(y<=randy){
					 randy=new Random().nextInt(Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/10)*3);
				 	  randy+=Constants.SCREEN_HEIGHT/10;
				   	updownleftright=new Random().nextInt(2);
				 }
			 }
			 else if(y<=randy){
				 y+=2;
				 
				 mnbottom=true;
			 	  mnleft=false;
			 	  mnright=false;
			 	  mnup=false;
				 if(y>=randy){
					 randy=new Random().nextInt(Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/10)*3);
				 	  randy+=Constants.SCREEN_HEIGHT/10;
				   	updownleftright=new Random().nextInt(2);
				 }
				 
			 }
		 
	 }}
		 canvas.drawBitmap(mn[i], mnx, mny,null);
	 }
	 public void update(){
		   j++;
		   if(j==3){
			   j=0;
			   if(mnbottom){
				  b++;
				  b=b%24;
				  i=b;
				   
			   }else if(mnleft){
				   l++;
				   l=24+l%24;
				   i=l;
			   }else if(mnright){
				   r++;
				   r=48+r%24;
				   i=r;
			   }else{
				   u++;
				   u=72+u%24;
				   i=u;
			   }
		   }
		   
	   }
	 public void draw1(Canvas canvas){
		 canvas.drawBitmap(shadow, mnx+shadowx,mny+shadowy ,null);
	 }
}
