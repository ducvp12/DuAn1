package vn.edu.poly.qunlvtnui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;


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
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
    }

    @Override
    public void onLongClick(int i, View view) {
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(int position) {
        dialog = new Dialog(QuanlyActivity.this);
        dialog.setContentView(R.layout.dialog_chitet);
        dialog.setTitle("Chi tiết");
        tv1 = (TextView) dialog.findViewById(R.id.tv1);
        tv2 = (TextView) dialog.findViewById(R.id.tv2);
        tv3 = (TextView) dialog.findViewById(R.id.tv3);
        tv4 = (TextView) dialog.findViewById(R.id.tv4);
        tv5 = (TextView) dialog.findViewById(R.id.tv5);
        dialog.show();

        tv1.setText(String.valueOf(quanlyList.get(position).getName()));
        tv2.setText(String.valueOf(quanlyList.get(position).getLoaithucan()));

        tv4.setText(String.valueOf(quanlyList.get(position).getThoigian()));
        tv5.setText(String.valueOf(quanlyList.get(position).getTrangthai()));
    }

    public void back(View view) {
        finish();
    }
}
