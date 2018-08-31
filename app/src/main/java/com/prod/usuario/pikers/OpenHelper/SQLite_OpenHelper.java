package com.prod.usuario.pikers.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper{

    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table Users(UserID integer primary key autoincrement," +
                                            "Email text," +
                                            "Username text," +
                                            "Password text," +
                                            "Name text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Open DB
    public void OpenDB(){
        this.getWritableDatabase();
    }

    //Close DB
    public void CloseDB(){
        this.close();
    }

    //insert in User
    public void InsertUser(String email,String username, String password, String name){
        ContentValues values = new ContentValues();
        values.put("Email",email);
        values.put("Username",username);
        values.put("Password",password);
        values.put("Name",name);
        this.getWritableDatabase().insert("Users",null,values);
    }

    //Delete User
    public  boolean  DeleteUser(String username)
    {
        return this.getWritableDatabase().delete("Users","username = "+username,null)>0;
    }

    //user exists?
    public boolean UserExists(String userName, String password) throws SQLException
    {
        Cursor cursor = null;

        cursor = this.getReadableDatabase()
                .query("Users",new String[]{"UserID","Email","Username","Password","Name"}
                ,"Username = '"+userName+"' and Password = '"+password+"'"
                ,null,null,null,null);

        return cursor.getCount()>0;
    }


}
