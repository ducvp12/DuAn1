package vn.edu.poly.qunlvtnui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class AddVatnuoiActivity extends AppCompatActivity {
    QuanlyDAO quanlyDAO;
    private LinearLayout ct;
    private Toolbar toolbar;
    private ImageView imgBack;
    private ImageView iconpet;
    private EditText edtName;
    private EditText edtTrangthai;
    private EditText edtLoaithucan;
    private EditText edtThoigian;
    private EditText edtSoluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vatnuoi);
        initView();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddVatnuoiActivity.this,QuanlyActivity.class);
                startActivity(intent);
        finish();
            }
        });
    }

    public void addvatnuoi(View view){
        quanlyDAO=new QuanlyDAO(AddVatnuoiActivity.this);
        Quanly vatnuoi=new Quanly(edtName.getText().toString(),
                edtTrangthai.getText().toString(),
                edtLoaithucan.getText().toString(),
                edtThoigian.getText().toString(),
                edtLoaithucan.getText().toString());

        try {
            if (validateForm()>0){
                if (quanlyDAO.insert(vatnuoi) > 0) {
                    Toast.makeText(getApplicationContext(), "Thêm thành công",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

    private int validateForm() {
        int check = 1;
        if (edtName.getText().length() == 0 || edtLoaithucan.getText().length() == 0
                || edtSoluong.getText().length() == 0 || edtThoigian.getText().length()==0
                || edtTrangthai.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        }

        return check;
    }


    private void initView() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        imgBack = (ImageView) findViewById(R.id.img_back);
        iconpet = (ImageView) findViewById(R.id.iconpet);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtTrangthai = (EditText) findViewById(R.id.edt_trangthai);
        edtLoaithucan = (EditText) findViewById(R.id.edt_loaithucan);
        edtThoigian = (EditText) findViewById(R.id.edt_thoigian);
        edtSoluong = (EditText) findViewById(R.id.edt_soluong);
    }
}
