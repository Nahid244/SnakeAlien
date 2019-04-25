package com.example.rohim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Dataabase extends SQLiteOpenHelper {
	private static final String Dbname="secretdev.db";
	private static final String Tbname="gamescore";
	private static final String Score="Score";
	private static final int Vrname=1;
	
	

	public Dataabase(Context context) {
		super(context, Dbname, null, Vrname);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
		db.execSQL("create table "+Tbname+"("+Score+" int );");
		}catch(Exception e){
			
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		try{
		db.execSQL("drop table if exists"+Tbname);
		onCreate(db);
		}catch(Exception e){
			
		}
	}
	public void addScore(int scor){
		try{
		 SQLiteDatabase db = this.getWritableDatabase();
		//String query="insert into "+Tbname+" values ("+scor+")";
		 ContentValues value=new ContentValues();
	      
	        value.put(Score,scor);
	        db.insert(Tbname, null,value);

	        db.close();
		}catch(Exception e){
			
		}
		
	}
	public int getScore(){
		int res;
		SQLiteDatabase db=this.getReadableDatabase();
		String selectquery="SELECT * FROM "+ Tbname;
        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
            	res=cursor.getInt(0);
               
            }while(cursor.moveToNext());
        }
        else {
        	res=0;
        }

        return res;
		
	}
	public void updatescore(int s1,int s2){
		SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value=new ContentValues();

        value.put(Score,s2);
        db.update(Tbname, value, "Score="+s1, null);
        db.close();
       
	}

}
