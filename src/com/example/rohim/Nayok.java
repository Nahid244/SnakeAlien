package com.example.rohim;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

public class Nayok {
   public Bitmap[] nayokb=new Bitmap[48];
   public Bitmap dm;
   public Canvas canvas;
   public DimCollect dim;
   ArrayList<DimCollect> egg1=new ArrayList<DimCollect>();
   int i=0;
   int j=0;
   int b=0;
   int l=13;
   int r=25;
   int u=37;
   
   int bottom=0;
   int left=0;
   int right=0;
   int up=0;
   
  int c=0; 
  
  int shadowx;
  int shadowy;
  public Bitmap shadow;
//   public Bitmap[] nayokl=new Bitmap[12];
//   public Bitmap[] nayokr=new Bitmap[12];
//   public Bitmap[] nayoku=new Bitmap[12];
   
   public Nayok(Context context,Bitmap shadow){
	  // nayok=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.nb1,115,149), Constants.SCREEN_WIDTH/12, Constants.SCREEN_HEIGHT/12, true);
	   for(int k=1;k<=12;k++){
			String s1="nb"+k;
			nayokb[k-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s1, R.drawable.class),Constants.SCREEN_WIDTH/12,Constants.SCREEN_HEIGHT/12), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
			String s2="nl"+k;
			nayokb[k+12-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s2, R.drawable.class),Constants.SCREEN_WIDTH/12,Constants.SCREEN_HEIGHT/12), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
			String s3="nr"+k;
			nayokb[k+24-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s3, R.drawable.class),Constants.SCREEN_WIDTH/12,Constants.SCREEN_HEIGHT/12), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
			String s4="nu"+k;
			nayokb[k+36-1]=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),Constants.getResId(s4, R.drawable.class),Constants.SCREEN_WIDTH/12,Constants.SCREEN_HEIGHT/12), Constants.SCREEN_WIDTH/15, Constants.SCREEN_HEIGHT/15, true);
			 dm=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.dim,191,191), Constants.SCREEN_WIDTH/30, Constants.SCREEN_HEIGHT/30, true);
			dim=new DimCollect(dm);
			
		}
	   this.shadow=shadow;
	   shadowy=nayokb[0].getHeight()-nayokb[0].getHeight()/4;
	   Constants.nayoky=0;
	   Constants.nayoky=Constants.SCREEN_HEIGHT/8;
	}
   
   public void draw(Canvas canvas ){
	  Constants.dimprevx=Constants.nayokx;
	  Constants.dimprevy=Constants.nayoky;
	  
	   
	   if(Constants.nayokx>Constants.SCREEN_WIDTH/2 && Constants.nayokrightchk && Constants.backx>=-Constants.SCREEN_WIDTH){
		   Constants.backrightchk=true;
		   Constants.backleftchk=false;
	   }else if(Constants.nayokx<Constants.SCREEN_WIDTH/2 && Constants.nayokleftchk && Constants.backx<=0){
		   Constants.backrightchk=false;
		   Constants.backleftchk=true;
	   }else{
		   Constants.backrightchk=false;
		   Constants.backleftchk=false;
		   
		   
		   if(Constants.playchk){
		   if(Constants.nayokbottomchk){
			  
			   Constants.nayoky+=2;
			   
		   }
		   else if(Constants.nayokleftchk && Constants.backrightchk==false){
			  
			   
			   Constants.nayokx-=2;
			   String s=""+ Constants.nayokx;
			   Log.d("dfdf", s);
		   }
		   else if(Constants.nayokrightchk && Constants.backleftchk==false){
			  
			   Constants.nayokx+=2;
			  
		   }
		   else{
			  
			   Constants.nayoky-=2;
			   
		   }
		   }
		   
	   }
	   if(Constants.dimheat){
		   egg1.add(new DimCollect(dm));
		   Constants.dimheat=false;
		   Constants.dimheatCount++;
	   }
//	   String s=""+egg1.size()+"   "+Constants.dimheatCount;
//	   Log.d("hhhhhhhhh",s );

	   if(egg1.size()>=1){
		    if(Constants.nayokbottomchk){
		    	 egg1.get(0).x=Constants.dimprevx;
				  egg1.get(0).y=Constants.dimprevy-dm.getHeight();
				       int x=dm.getHeight();
				 
				   bottom+=2;
				   if(bottom==x){
				 
					  
				  for(int i=egg1.size()-1;i>=1;i--){
					 
					 
					  
					  egg1.get(i).y = egg1.get(i-1).y-x/2;
					  egg1.get(i).x=egg1.get(i-1).x;
					  
					 
				  }
				  bottom=0;
				   }
				  
				  
				  }
		    else if(Constants.nayokupchk){
		    	 egg1.get(0).x=Constants.dimprevx;
				  egg1.get(0).y=Constants.dimprevy+nayokb[0].getHeight();
				  int x=dm.getHeight();
				  up+=2;
				   if(up==x){
				  for(int i=egg1.size()-1;i>=1;i--){
					  
					  
					  egg1.get(i).y= egg1.get(i-1).y+x/2;
					  egg1.get(i).x=egg1.get(i-1).x;
					 
					    
					  }
				  up=0;
				   }
				   
				 
		    }
		    else if(Constants.nayokrightchk){
		    	 egg1.get(0).x=Constants.dimprevx-dm.getWidth();
				  egg1.get(0).y=Constants.dimprevy;

				  int x1=dm.getWidth();
				  right+=2;
				   if(right==x1){
				  for(int i=egg1.size()-1;i>=1;i--){
					  
					 
					  egg1.get(i).y=egg1.get(i-1).y;
					  egg1.get(i).x= egg1.get(i-1).x-x1/2;
					  
					  }
				  right=0;
				 
	    }
				  
		    }
		    else{
		    	 egg1.get(0).x=Constants.dimprevx+dm.getWidth();
				  egg1.get(0).y=Constants.dimprevy;
				  int x11=dm.getWidth();
				  left+=2;
				   if(left==x11){
				  for(int i=egg1.size()-1;i>=1;i--){
					  egg1.get(i).y=egg1.get(i-1).y;
					  egg1.get(i).x= egg1.get(i-1).x+x11/2;
					 
					  }
				 
		   left=0;
//			 
//			 
//				   
		  }
   }
		    
	   }
	  
//	   else if(egg1.size()>1){
//		   for(int i=egg1.size()-1;i>=1;i--){
//			   egg1.get(i).x= egg1.get(i-1).x; 
//				  egg1.get(i).y= egg1.get(i-1).y;
//			  
//		   }
//		   
//	   }
	  
	   for(int i=0;i<egg1.size();i++){
	   
		   egg1.get(i).draw(canvas);
	    
	     
	   }
	   //egg1.get(0).draw(canvas);
	   canvas.drawBitmap(nayokb[i], Constants.nayokx, Constants.nayoky,null);
	   
//	   if(Constants.dimheat){
//		    Constants.dimheatx+=Constants.nayokx-nayokb[0].getWidth();
//		    Constants.dimheaty=Constants.nayokx;
//		    egg.add(new DimCollect(dm,Constants.dimheatx,Constants.dimheaty));
//		    for(int i=0;i<=Constants.dimheatCount;i++){
//		    	egg.get(Constants.dimheatCount).draw(canvas);
//		    }
//		    Constants.dimheatCount++;
//		    
//		   Constants.dimheat=false;
//	   }
	   
	   
	   
   }
   public void update(){
	   j++;
	   if(j==3){
		   j=0;
		   if(Constants.nayokbottomchk){
			  b++;
			  b=b%12;
			  i=b;
			   
		   }else if(Constants.nayokleftchk){
			   l++;
			   l=12+l%12;
			   i=l;
		   }else if(Constants.nayokrightchk){
			   r++;
			   r=24+r%12;
			   i=r;
		   }else{
			   u++;
			   u=36+u%12;
			   i=u;
		   }
	   }
	   
   }
   public void draw1(Canvas canvas){
	   canvas.drawBitmap(shadow, Constants.nayokx,Constants.nayoky+shadowy ,null);
   }
}
