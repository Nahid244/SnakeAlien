package com.example.rohim;

import java.lang.reflect.Field;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;

public class Constants {
	public static boolean playerrun=true;
	
	public static boolean playchk=true;
	
	public static boolean running=false;
	
    public static int SCREEN_WIDTH=1;
    public static int SCREEN_HEIGHT=1;
    
    public static int backx=0;
    public static boolean backleftchk=false;
    public static boolean backrightchk=false;
    
    public static int rightwallx;
    public static int rightwally;
    
    public static int nayokx=100;
    public static int nayoky=100;
    
    public static boolean nayokleftchk=false;
    public static boolean nayokrightchk=false;
    public static boolean nayokbottomchk=true;
    public static boolean nayokupchk=false;
    
    
    public static boolean dimheat=false;
    public static int dimheatCount=0;
    public static int dimprevx=0;
    public static int dimprevy=0;
    
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        final int halfHeight = height / 2;
        final int halfWidth = width / 2;

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while ((halfHeight / inSampleSize) >= reqHeight
                && (halfWidth / inSampleSize) >= reqWidth) {
            inSampleSize *= 2;
        }
    }

    return inSampleSize;
}
	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
	        int reqWidth, int reqHeight) {

	    // First decode with inJustDecodeBounds=true to check dimensions
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    BitmapFactory.decodeResource(res, resId, options);

	    // Calculate inSampleSize
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

	    // Decode bitmap with inSampleSize set
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeResource(res, resId, options);
	}
	public static int getResId(String resName, Class<?> c) {

	    try {
	        Field idField = c.getDeclaredField(resName);
	        return idField.getInt(idField);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    } 
	}
	public static void staticset(){
		playerrun=true;
		
		 playchk=true;
		running=false;
		  SCREEN_WIDTH=1;
		    SCREEN_HEIGHT=1;
		    
		     backx=0;
		    backleftchk=false;
		     backrightchk=false;
		    
		   
		    
		     nayokx=100;
		   nayoky=100;
		    
		     nayokleftchk=false;
		    nayokrightchk=false;
		     nayokbottomchk=true;
		     nayokupchk=false;
		     
		     
		     dimheat=false;
		     dimheatCount=0;
		      dimprevx=0;
		      dimprevy=0;
	}
	public static boolean isCollisionDetected(Bitmap bitmap1, int x1, int y1,
	        Bitmap bitmap2, int x2, int y2) {

	    Rect bounds1 = new Rect(x1, y1, x1+bitmap1.getWidth(), y1+bitmap1.getHeight());
	    Rect bounds2 = new Rect(x2, y2, x2+bitmap2.getWidth(), y2+bitmap2.getHeight());

	    if (Rect.intersects(bounds1, bounds2)) {
	        Rect collisionBounds = getCollisionBounds(bounds1, bounds2);
	        for (int i = collisionBounds.left; i < collisionBounds.right; i++) {
	            for (int j = collisionBounds.top; j < collisionBounds.bottom; j++) {
	                int bitmap1Pixel = bitmap1.getPixel(i-x1, j-y1);
	                int bitmap2Pixel = bitmap2.getPixel(i-x2, j-y2);
	                if (isFilled(bitmap1Pixel) && isFilled(bitmap2Pixel)) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

	private static Rect getCollisionBounds(Rect rect1, Rect rect2) {
	    int left = (int) Math.max(rect1.left, rect2.left);
	    int top = (int) Math.max(rect1.top, rect2.top);
	    int right = (int) Math.min(rect1.right, rect2.right);
	    int bottom = (int) Math.min(rect1.bottom, rect2.bottom);
	    return new Rect(left, top, right, bottom);
	}

	private static boolean isFilled(int pixel) {
	    return pixel != Color.TRANSPARENT;
	}
}
