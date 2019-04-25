package com.example.rohim;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Dim {
    public Bitmap dm;
    public int dmx;
    public int dmy;
    int x;
    int y;
    public Dim(Bitmap dm){
    	 //dm=Bitmap.createScaledBitmap(Constants.decodeSampledBitmapFromResource(context.getResources(),R.drawable.dim,191,191), Constants.SCREEN_WIDTH/20, Constants.SCREEN_HEIGHT/20, true);
    	// int x = (int) (20 * Math.random()) + 1;
    	this.dm=dm;
    	  x=new Random().nextInt(Constants.SCREEN_WIDTH*2-(Constants.SCREEN_WIDTH/10)*2);
    	  x+=Constants.SCREEN_WIDTH/10;
    	  y=new Random().nextInt(Constants.SCREEN_HEIGHT-(Constants.SCREEN_HEIGHT/10)*3);
    	  y+=Constants.SCREEN_HEIGHT/10;
    	dmy=y;
    	
    	
    }
    public void draw(Canvas canvas){
    	dmx=Constants.backx+x;
    	canvas.drawBitmap(dm, dmx, dmy,null);
    }
}
