package vn.edu.poly.qunlvtnui.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qunlvtnui.database.DatabaseHelper;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class QuanlyDAO {
    private final SQLiteDatabase db;
    private final DatabaseHelper databaseHelper;
    public static final String TABLE_NAME="Quanlyvatnuoi";
    public static final String SQL_VATNUOI="CREATE TABLE Quanlyvatnuoi(name text primary key, thoigian text, loaithucan text, soluong int, trangthai text);";
    public static final String TAG="QuanlyDAO";

    public QuanlyDAO(Context context) {
        databaseHelper=new DatabaseHelper(context);
        db=databaseHelper.getWritableDatabase();

    }

    //insert
    public int insert(Quanly quanly){
        ContentValues values=new ContentValues();
        values.put("name", quanly.getName());
        values.put("soluong",quanly.getSoluong());
        values.put("thoigian",quanly.getThoigian());
        values.put("loaithucan",quanly.getLoaithucan());
        values.put("trangthai",quanly.getTrangthai());
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
    public List<Quanly> getQuanly(){
        List<Quanly> ql=new ArrayList<>();
        Cursor c=db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()== false){
            Quanly ee=new Quanly();
            ee.setName(c.getString(0));
            ee.setTrangthai(c.getString(1));
            ee.setLoaithucan(c.getString(2));
            ee.setThoigian(c.getString(3));
            ee.setSoluong(c.getString(4));
            ql.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return ql;
    }


    public void deleteQuanly(String name){
        int result= db.delete(TABLE_NAME,"name=?",new String[]{name});
        if (result==0){};
    }

    public int updatequanly(String name, String trangthai, String soluong ){
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
