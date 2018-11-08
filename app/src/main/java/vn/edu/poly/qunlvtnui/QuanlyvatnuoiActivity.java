package vn.edu.poly.qunlvtnui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.poly.qunlvtnui.model.Quanly;

public class QuanlyvatnuoiActivity extends AppCompatActivity {

    private ImageView imbtnQuanly;
    private ImageView imbnThongtin;
    private ImageView imbtnGhichu;
    private ImageView imbtnExit;
    private TextView tvQuanly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyvatnuoi);
        initView();

        imbtnQuanly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanlyvatnuoiActivity.this, QuanlyActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imbtnQuanly = (ImageView) findViewById(R.id.imbtn_quanly);
        imbnThongtin = (ImageView) findViewById(R.id.imbn_thongtin);
        imbtnGhichu = (ImageView) findViewById(R.id.imbtn_ghichu);
        imbtnExit = (ImageView) findViewById(R.id.imbtn_exit);
        tvQuanly = (TextView) findViewById(R.id.tv_quanly);
    }
}
