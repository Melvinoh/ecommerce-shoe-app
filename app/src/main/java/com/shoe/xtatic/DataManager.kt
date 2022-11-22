package com.shoe.xtatic

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataManager(context: Context) {
    //this is the actual database

    private var db : SQLiteDatabase

    init {
        //create an instance of our internal database

        val helper = CustomSQliteOpenHelper(context)

        db = helper.writableDatabase
    }

    companion object {
        const val TABLE_ROW_ID = "_ID"
        const val TABLE_ROW_FIRSTNAME = "First_name"
        const val TABLE_ROW_SECONDNAME = "Second_name"
        const val TABLE_ROW_EMAIL = "Email"
        const val TABLE_ROW_ZIP = "Zip"
        const val TABLE_ROW_PHONE = "Phone"
        const val TABLE_ROW_PASSWORD = "Password"

        private const val DB_NAME = "Xtatic shoes"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "Address book"

    }
    fun insert(firstName: String,secondName:String,email:String,zip:Any,phone:Any,password:Any){

        val query = "INSERT INTO " + TABLE_NAME + "(" + TABLE_ROW_FIRSTNAME +","+ TABLE_ROW_SECONDNAME +","+
        TABLE_ROW_EMAIL +","+ TABLE_ROW_ZIP +","+ TABLE_ROW_PHONE +","+ TABLE_ROW_PASSWORD + ")" +
        " VALUES (" + firstName +","+ secondName +","+ email +","+ zip +","+ phone +","+ password + ")"

        Log.i("insert() =",query)

        db.execSQL(query)

    }
    fun search (email:String,password: Any) : Cursor{
        val query = "SELECT" + TABLE_ROW_EMAIL + TABLE_ROW_PASSWORD + "FROM" + TABLE_NAME +"WHERE"+
                TABLE_ROW_EMAIL + "='" +email +"AND"+ TABLE_ROW_PASSWORD + "='" +password +";"
        Log.i("search() =", query)
        return db.rawQuery(query,null)

    }
   private inner class  CustomSQliteOpenHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME,null,
        DB_VERSION){

        override fun onCreate(db: SQLiteDatabase?) {
            val table = ("CREATE TABLE" + TABLE_NAME + "(" +
                    TABLE_ROW_ID + "integer primary key autoincrement not null"
                    + TABLE_ROW_FIRSTNAME +"text not null"
                    + TABLE_ROW_SECONDNAME +" text not null"
                    + TABLE_ROW_EMAIL + "text unique not null"
                    + TABLE_ROW_ZIP + "text"
                    +TABLE_ROW_PHONE + "integer not null"
                    + TABLE_ROW_PASSWORD + "text not null );"
                    )
            db!!.execSQL(table)
        }

       override fun onUpgrade(db: SQLiteDatabase,oldVersion: Int,newVersion: Int) {
           TODO("Not yet implemented")
       }


    }
}