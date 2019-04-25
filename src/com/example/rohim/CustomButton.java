package com.example.rohim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

public class CustomButton {
	 public Matrix btn_matrix = new Matrix();

     public RectF btn_rect;

     float width;
     float height;   
     Bitmap bg;

     public CustomButton(float width, float height)
     {
         this.width = width;
         this.height = height;
        

         btn_rect = new RectF(0, 0, width, height);
     }
     public void setBitmap(Bitmap bg){
    	this.bg=bg; 
     }

     public void setPosition(float x, float y)
     {
         btn_matrix.setTranslate(x, y);
         btn_matrix.mapRect(btn_rect);
     }

     public void draw(Canvas canvas)
     {
         canvas.drawBitmap(bg, btn_matrix, null);
     }
}
