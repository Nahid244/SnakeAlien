package com.example.rohim;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class OneThread extends Thread{
	private final static int    MAX_FPS = 420;
		private final static int    MAX_FRAME_SKIPS = 5;
		private final static int    FRAME_PERIOD = 1000 / MAX_FPS; 
	
		 private SurfaceHolder surfaceholder;
	     private GamePanel gamepanel;
	     Canvas canvas;
//	     private boolean running;
//	    
//	     
//	     public void setRunning(boolean b){
//	    	 running=b;
//	     }
	     
	     public OneThread(SurfaceHolder s,GamePanel g){
	    	 super();
	    	 surfaceholder=s;
	    	 gamepanel=g;
	     }
		
	
		public void run() {
	
			
		    long beginTime;     // the time when the cycle begun

		    long timeDiff;      // the time it took for the cycle to execute
	
		    long sleepTime;      // ms to sleep (<0 if we're behind)
	
		    int framesSkipped;  // number of frames being skipped
	
		 
	
		    sleepTime = 0;
	
		 
	
		    while (Constants.running) {
	              
		        canvas = null;
	
		       
	
		        try {
		        	Log.d("df", "i am roh");
		        	canvas = this.surfaceholder.lockCanvas();
		        	
		            synchronized (surfaceholder) {
		            	 
		                beginTime = System.currentTimeMillis();
	
		                framesSkipped = 0;  
	
		                gamepanel.draw(canvas);
		                gamepanel.update(canvas);
		               
	                  
		               
		                timeDiff = System.currentTimeMillis() - beginTime;
	
		                // calculate sleep time
	
		                sleepTime = (int)(FRAME_PERIOD - timeDiff);
	
		 
	
		                if (sleepTime > 0) {
	
		                    // if sleepTime > 0 we're OK
	
		                    try {
	
		                        // send the thread to sleep for a short period
	
		                        // very useful for battery saving
		                    	
		                        Thread.sleep(sleepTime);
	
		                    } catch (Exception e) {}

		                }
	
		 
	
		                while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
	
		                    // we need to catch up
	
		                    // update without rendering
		                	
		                    this.gamepanel.update(canvas);
	
		                    // add frame period to check if in next frame
	
		                    sleepTime += FRAME_PERIOD;
	
		                    framesSkipped++;
	
		                }
	
		            }
		        }
		        finally {
	
	
		            if (canvas != null) {
		            	
		                surfaceholder.unlockCanvasAndPost(canvas);
		                
		            }
	
		        }   // end finally
	
		    }
	
		}
}
//public class OneThread extends Thread{
//    public static final int MAX_FPS=250;
//    private double averageFPS;
//    private SurfaceHolder surfaceholder;
//    private GamePanel gamepanel;
//    private boolean running;
//    public  Canvas canvas;
//    private final static int  MAX_FRAME_SKIPS = 5;
//    long  previousTime;
//
//	private  int    FRAME_PERIOD = 1000 / MAX_FPS; 
//    
//    public void setRunning(boolean b){
//   	 running=b;
//    }
//   
//    public OneThread(SurfaceHolder s,GamePanel g){
//   	 super();
//   	 surfaceholder=s;
//   	 gamepanel=g;
//    }
//    public void run() {
//        Canvas canvas;
//
//        while (running) {
//
//            long currentTimeMillis = System.currentTimeMillis();
//            long elapsedTimeMs = currentTimeMillis - previousTime;
//            long sleepTimeMs = (long) (1000f/ MAX_FPS - elapsedTimeMs);
//
//            canvas = null;
//            try {
//
//                canvas = surfaceholder.lockCanvas();
//
//                if (canvas == null) {
//                    Thread.sleep(1);
//
//                    continue;
//
//                }else if (sleepTimeMs > 0){
//
//                    Thread.sleep(sleepTimeMs);
//
//                }
//
//                 {
//                    this.gamepanel.draw(canvas);
//                    this.gamepanel.update();
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (canvas != null) {
//                    surfaceholder.unlockCanvasAndPost(canvas);
//                    previousTime = System.currentTimeMillis();
//                }
//            }
//        }
//}
//    	  
//    	}
//		 
//		
//	 


   
//public class OneThread extends Thread{
//    public static final int MAX_FPS=360;
//    private double averageFPS;
//    private SurfaceHolder surfaceholder;
//    private GamePanel gamepanel;
//    private boolean running;
//    public static Canvas canvas;
//    
//    public void setRunning(boolean b){
//   	 running=b;
//    }
//    
//    public OneThread(SurfaceHolder s,GamePanel g){
//   	 super();
//   	 surfaceholder=s;
//   	 gamepanel=g;
//    }
//    public void run(){
//   	 long startTime;
//   	 long timeMillis=1000/MAX_FPS;
//   	 long waitTime;
//   	 int frameCount=0;
//   	 long totalTime=0;
//   	 long targetTime=1000/MAX_FPS;
//   	 
//   	 while(running){
//   		 startTime=System.nanoTime();
//   		 canvas=null;
//   		 try{
//   			 canvas=this.surfaceholder.lockCanvas();
//   			 synchronized(surfaceholder){
//   				this.gamepanel.update();
//   				this.gamepanel.draw(canvas);
//   				
//   			 } 
//   			 
//   		 }catch(Exception e){
//   			 
//   		 }finally{
//   			 if(canvas!=null){
//   				 try{
//   					 surfaceholder.unlockCanvasAndPost(canvas);
//   				 }catch(Exception e){
//   					 
//   				 }
//   			 }
//   		 }
//   		 timeMillis=System.nanoTime()-(startTime/1000000);
//   		 
//   		 
//   		 waitTime=targetTime- timeMillis;
//   		 try{
//   			 if(waitTime>0){
//   				 this.sleep(waitTime);
//   			 }
//   			 
//   			 
//   		 }catch(Exception e){
//   			 
//   		 }
//   		 totalTime+=System.nanoTime()-startTime;
//   		 frameCount++;
//   		 if(frameCount==MAX_FPS){
//   			 averageFPS=((totalTime/frameCount)/1000000);
//   			 frameCount=0;
//   			 totalTime=0;
//   			 System.out.println(averageFPS);
//   		 }
//   	 }
//    }
//}
