package com.example.rohim;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sword {
    public Bitmap sd;
    int mnx;
	int x;
	int y;
	int direction;
	public Sword(Bitmap sd,int x,int y,int direction){
		this.sd=sd;
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	public void draw(Canvas canvas){
		if(Constants.playchk){
		if(direction==1){
			x+=2;
		}else if(direction==2){
			y+=2;
		}else if(direction==3){
			x-=2;
		}
		else if(direction==4){
			y-=2;
		}
		mnx=Constants.backx+x;
	}
		canvas.drawBitmap(sd, mnx, y,null);
	}
	public void update(){
		
	}
	
}
