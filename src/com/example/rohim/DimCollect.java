package com.example.rohim;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class DimCollect {
           public Bitmap dm;
           int x;
           int y;
          
		public DimCollect(Bitmap dm) {
			super();
			this.dm = dm;
			
			
		}
		public void draw(Canvas canvas){
		     canvas.drawBitmap(dm, x,y,null);	
		}
		
}
