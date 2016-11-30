package com.vanderveldt.rens.rensvanderveldt_pset5;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLMaster extends SQLiteOpenHelper {

    // Table Name for master lists
    public static final String TABLE_NAME_MASTER = "MASTERLIST";

    // Table Name
    public static final String TABLE_NAME_ITEMS = "MASTERLIST";

    // Table columns
    public static final String _ID = "_id";
    public static final String MASTER_TITLE = "masterTitle";
    public static final String ITEM_TITLE = "itemTitle";
    public static final String MASTER_KEY = "masterKey";



    // Database Information
    static final String DB_NAME = "TODO_DATABASE.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table querys
    private static final String CREATE_TABLE_MASTER = "create table " + TABLE_NAME_MASTER + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MASTER_TITLE + " TEXT NOT NULL);";
    private static final String CREATE_TABLE_ITEM = "create table " + TABLE_NAME_ITEMS + "(" + MASTER_KEY + " INTEGER PRIMARY," + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM_TITLE + " TEXT NOT NULL);";


    public SQLMaster(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create both tables
        db.execSQL(CREATE_TABLE_MASTER);
        db.execSQL(CREATE_TABLE_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MASTER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ITEMS);
        onCreate(db);
    }
}