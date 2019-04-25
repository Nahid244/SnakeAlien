package com.example.rohim;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ScoreBoard {
int x;
int y;
Bitmap bit;
public ScoreBoard(Bitmap bit){
	x=Constants.SCREEN_WIDTH/4;
	y=-Constants.SCREEN_HEIGHT;
	this.bit=bit;
}
public void draw(Canvas canvas){
	canvas.drawBitmap(bit, x, y,null);
}
public void update(){
	if(y<Constants.SCREEN_HEIGHT/4){
		y+=15;
	}
}
}
