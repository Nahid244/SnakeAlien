package com.example.rohim;

import java.io.Console;
import java.lang.reflect.Field;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.webkit.ConsoleMessage;

public class Entity {
   public Bitmap bit,img;
   public Bitmap[] plr=new Bitmap[51];
   int i=0;
   int j=0;
   
   int posx=0;
   
	public Entity(Context context){
		
	}
}
		
////		String s1="f"+k;
//	//	bit=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.rust,500,500), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, true);
//		//draw(canvas);
////		plr[0]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.one,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[1]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.two,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[2]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.two,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[3]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.three,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[4]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.four,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[5]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.five,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[6]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.six,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[7]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.seven,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[8]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.eight,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[9]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.nine,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[10]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.ten,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[11]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.thrtn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[12]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.fhrtn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[13]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.fiftn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[14]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.sxtn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[15]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.svtn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[16]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.eghtn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[17]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.nintn,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[18]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.tnt,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[19]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.tnt2,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[20]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.tnt3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[21]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.tnt4,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[22]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[23]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[24]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[25]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[26]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[27]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[28]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[29]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[30]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[31]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[32]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[33]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[34]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[35]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[36]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[37]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[38]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[39]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[40]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[41]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[42]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[43]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[44]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[45]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[46]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[47]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		plr[48]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),R.drawable.splash3,100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
//		
//		//img=decodeSampledBitmapFromResource(context.getResources(),R.drawable.rust,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
////		for(int k=1;k<=48;k++){
////			String s1="t"+k;
////			plr[k-1]=Bitmap.createScaledBitmap(decodeSampledBitmapFromResource(context.getResources(),getResId(s1, R.drawable.class),100,100), Constants.SCREEN_WIDTH/4, Constants.SCREEN_HEIGHT/4, true);
////		}
////	}
//	
//	}
//	public void draw(Canvas canvas){
//		//canvas.drawBitmap(bit, 0, 0,null);
//		
//		
//	//	canvas.drawBitmap(plr[i], posx, 0,null);
//		
//		
//		
//		
//		
////		String s="dfd"+i;
////		Log.d(null, s);
//		
//	}
//	public void update(){
////		i++;
////		i=i%1;
//		
////		if(posx<Constants.SCREEN_WIDTH/2 || Constants.rightwallx==Constants.SCREEN_WIDTH-Constants.SCREEN_WIDTH/25){
////			posx++;
////			Constants.backchk=false;
////			
////		}
////		else{
////			Constants.backchk=true;
////		}
////		j++;
////		if(j==3){
////		i++;
////		if(i>47){i=0;}
////		  String s=""+Constants.SCREEN_WIDTH;
////		  Log.d(null, s);
////    	j=0;
////		}
//		
//		//posx=posx%Constants.SCREEN_WIDTH;
//	}
//	
//	
//	public static int calculateInSampleSize(
//            BitmapFactory.Options options, int reqWidth, int reqHeight) {
//    // Raw height and width of image
//    final int height = options.outHeight;
//    final int width = options.outWidth;
//    int inSampleSize = 1;
//
//    if (height > reqHeight || width > reqWidth) {
//
//        final int halfHeight = height / 2;
//        final int halfWidth = width / 2;
//
//        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
//        // height and width larger than the requested height and width.
//        while ((halfHeight / inSampleSize) >= reqHeight
//                && (halfWidth / inSampleSize) >= reqWidth) {
//            inSampleSize *= 2;
//        }
//    }
//
//    return inSampleSize;
//}
//	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
//	        int reqWidth, int reqHeight) {
//
//	    // First decode with inJustDecodeBounds=true to check dimensions
//	    final BitmapFactory.Options options = new BitmapFactory.Options();
//	    options.inJustDecodeBounds = true;
//	    BitmapFactory.decodeResource(res, resId, options);
//
//	    // Calculate inSampleSize
//	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//	    // Decode bitmap with inSampleSize set
//	    options.inJustDecodeBounds = false;
//	    return BitmapFactory.decodeResource(res, resId, options);
//	}
//	public static int getResId(String resName, Class<?> c) {
//
//	    try {
//	        Field idField = c.getDeclaredField(resName);
//	        return idField.getInt(idField);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return -1;
//	    } 
//	}
