package com.example.a20f0196.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context) {
        super(context,"fitnessDB",null,1);
        Log.d("TAg","fitness DAta base Created");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String SqlTableQuery="CREATE TABLE  fitness ("+"_id  INTEGER PRIMARY KEY AUTOINCREMENT,"+"Name TEXT,"+"Age TEXT,"+"Weight TEXT,"+"Height TEXT)";
        db.execSQL(SqlTableQuery);

        Log.d("TAg","Fitness Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void InsertSingleContact(HashMap<String,String> contact)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
//        contentValues.put("_id",contact.get("_id"));
        contentValues.put("Name",contact.get("Name"));
        contentValues.put("Age",contact.get("Age"));
        contentValues.put("Weight",contact.get("Weight"));
        contentValues.put("Height",contact.get("Height"));

        long result=db.insert("fitness",null,contentValues);
        if (result!=-1)
        {
            Log.d("TAG","NEW CONTACT INSEET WITH ID"+result);
        }
        else {
            Log.d("TAG","NEW CONTACT INSERTION FAILED");
        }
        db.close();
    }

    public ArrayList<HashMap<String, String>> getContactlist() {
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<HashMap<String, String>> contactlist = new ArrayList<HashMap<String, String>>();
        String Query = "SELECT * FROM  fitness";

        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.moveToFirst())
        {
            do {

                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("id", cursor.getString(0));

                hashMap.put("Name", cursor.getString(1));
                hashMap.put("Age", cursor.getString(2));
                hashMap.put("Weight", cursor.getString(3));
                hashMap.put("Height", cursor.getString(4));

                contactlist.add(hashMap);

            } while (cursor.moveToNext());

        }

        return contactlist;
    }



    public void deleteContact(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete("fitness", "_id=?", new String[]{id});
        if (result > 0) {
            Log.d("TAG", "CONTACT DELETED WITH ID " + id);
        } else {
            Log.d("TAG", "CONTACT DELETION FAILED");
        }
        db.close();
    }



    public void updateContact(String id, HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", contact.get("Name"));
        contentValues.put("Age", contact.get("Age"));
        contentValues.put("Weight", contact.get("Weight"));
        contentValues.put("Height", contact.get("Height"));

        int result = db.update("fitness", contentValues, "_id=?", new String[]{id});
        if (result > 0) {
            Log.d("TAG", "CONTACT UPDATED WITH ID " + id);
        } else {
//            Toast.makeText(context, "CONTACT UPDATE FAILED", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "CONTACT UPDATE FAILED");
        }
        db.close();
    }
    public HashMap<String,String > getSingleContact(String id)
    {
        SQLiteDatabase db= getReadableDatabase();
        HashMap<String,String> hashMap =new HashMap<String,String>();

        String Query =  "SELECT * FROM fitness WHERE  _id= " +id;
        Cursor cursor = db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {


            hashMap.put("id",cursor.getString(0));
            hashMap.put("Name",cursor.getString(1));
            hashMap.put("Age",cursor.getString(2));
            hashMap.put("Weight",cursor.getString(3));
            hashMap.put("Height",cursor.getString(4));

        }
        return hashMap;
    }
}
