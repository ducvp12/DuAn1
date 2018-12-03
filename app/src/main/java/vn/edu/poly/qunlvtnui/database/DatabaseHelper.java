package vn.edu.poly.qunlvtnui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.edu.poly.qunlvtnui.dao.GhichuDAO;
import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="quanly";
    private static final int VERSION= 1;
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QuanlyDAO.SQL_VATNUOI);
        db.execSQL(GhichuDAO.SQL_GHICHU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+ QuanlyDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+ GhichuDAO.TABLE_NAME);
        onCreate(db);
    }
}
