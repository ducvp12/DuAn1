package vn.edu.poly.qunlvtnui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import vn.edu.poly.qunlvtnui.dao.GhichuDAO;
import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;
import vn.edu.poly.qunlvtnui.model.Ghichu;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class AddGhichuActivity extends AppCompatActivity {
    GhichuDAO ghichuDAO;
    private LinearLayout ct;
    private Toolbar toolbar;
    private ImageView imgBack;
    private ImageView iconpet;

    private EditText edtTieude;
    private EditText edtNoidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ghichu);
        initView();

    }

    public void addghichu(View view) {
        ghichuDAO = new GhichuDAO(AddGhichuActivity.this);
        Ghichu ghichu = new Ghichu(edtTieude.getText().toString(),
                edtNoidung.getText().toString());

        try {
            if (validateForm() > 0) {
                if (ghichuDAO.insert(ghichu) > 0) {
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
        if (edtTieude.getText().length() == 0 || edtNoidung.getText().length() == 0
                ) {
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông ",
                    Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            finish();
        }

        return check;
    }


    private void initView() {


        edtTieude = (EditText) findViewById(R.id.edt_tieude);
        edtNoidung = (EditText) findViewById(R.id.edt_noidung);
    }

    public void back(View view) {
        finish();
    }
}
