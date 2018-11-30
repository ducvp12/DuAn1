package vn.edu.poly.qunlvtnui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qunlvtnui.adapter.QuanlyAdapter;
import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class QuanlyActivity extends AppCompatActivity implements ItemClickListener {
    private List<Quanly> quanlyList;
    private QuanlyAdapter adapter;
    private RecyclerView recyclerView;
    private QuanlyDAO quanlyDAO;
    private FloatingActionButton fl;
    Dialog dialog;
    private EditText tv1;
    private EditText tv2;
    private Button btn_luu;
    private EditText tv4;
    private EditText tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly);
        recyclerView = findViewById(R.id.rvquanly);
        quanlyList = new ArrayList<>();
//        for (int i = 1; i < 40; i++) {
//            quanlyList.add(new Quanly("Gà" + i, "Tốt", "15" + i));
//
//        }

        adapter = new QuanlyAdapter(QuanlyActivity.this, quanlyList, this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        quanlyDAO = new QuanlyDAO(QuanlyActivity.this);
        quanlyList = quanlyDAO.getQuanly();


        initView();
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanlyActivity.this, AddVatnuoiActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        quanlyList.clear();
        quanlyList = quanlyDAO.getQuanly();
        adapter.changeDataset(quanlyDAO.getQuanly());
    }

    private void initView() {
        fl = (FloatingActionButton) findViewById(R.id.fl);
        tv1 =  findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
    }

    @Override
    public void onLongClick(int i, View view) {
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(final int position) {
        dialog = new Dialog(QuanlyActivity.this);
        dialog.setContentView(R.layout.dialog_chitet);
        dialog.setTitle("Chi tiết");
        tv1 =  dialog.findViewById(R.id.tv1);
        tv2 =  dialog.findViewById(R.id.tv2);
        btn_luu =  dialog.findViewById(R.id.btn_lưu);
        tv4 =  dialog.findViewById(R.id.tv4);
        tv5 =  dialog.findViewById(R.id.tv5);

        dialog.show();

        tv1.setText(String.valueOf(quanlyList.get(position).getName()));
        tv2.setText(String.valueOf(quanlyList.get(position).getLoaithucan()));

        tv4.setText(String.valueOf(quanlyList.get(position).getThoigian()));
        tv5.setText(String.valueOf(quanlyList.get(position).getTrangthai()));
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = tv1.getText().toString();
                String a2 = tv1.getText().toString();
                String a3 = tv1.getText().toString();
                String a4 = tv1.getText().toString();
                quanlyList = quanlyDAO.getQuanly();
                quanlyDAO.updatequanly(a1,a2,a3);
                adapter.changeDataset(quanlyDAO.getQuanly());

            }
        });

    }

    public void back(View view) {
        finish();
    }
}
