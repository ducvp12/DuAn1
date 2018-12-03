package vn.edu.poly.qunlvtnui.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qunlvtnui.database.DatabaseHelper;
import vn.edu.poly.qunlvtnui.model.Ghichu;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class GhichuDAO {
    private final SQLiteDatabase db;
    private final DatabaseHelper databaseHelper;
    public static final String TABLE_NAME="Ghichu";
    public static final String SQL_GHICHU="CREATE TABLE Ghichu( tieude text primary key, noidung text);";
    public static final String TAG="GhichuDAO";

    public GhichuDAO(Context context) {
        databaseHelper=new DatabaseHelper(context);
        db=databaseHelper.getWritableDatabase();

    }

    //insert
    public int insert(Ghichu ghichu){
        ContentValues values=new ContentValues();

        values.put("tieude",ghichu.getTieude());
        values.put("noidung",ghichu.getNoidung());

        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }


    //getAll
    public List<Ghichu> getGhichu(){
        List<Ghichu> gc=new ArrayList<>();
        Cursor c=db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()== false){
            Ghichu ee=new Ghichu();

            ee.setTieude(c.getString(0));
            ee.setNoidung(c.getString(1));
            gc.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return gc;
    }


    public void deleteghichu(String tieude){
        int result= db.delete(TABLE_NAME,"tieude=?",new String[]{String.valueOf(tieude)});
        if (result==0){};
    }

    public int updateghichu(String name, String trangthai, String soluong ){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("soluong", soluong);
        values.put("trangthai", trangthai);
        int result = db.update(TABLE_NAME, values, "name=?", new
                String[]{name});
        if (result == 0) {
            return -1;
        }
        return 1;
    }
}
