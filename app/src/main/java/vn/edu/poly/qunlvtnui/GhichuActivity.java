package vn.edu.poly.qunlvtnui;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qunlvtnui.adapter.GhichuAdapter;
import vn.edu.poly.qunlvtnui.adapter.QuanlyAdapter;
import vn.edu.poly.qunlvtnui.dao.GhichuDAO;
import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;
import vn.edu.poly.qunlvtnui.model.Ghichu;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class GhichuActivity extends AppCompatActivity implements ItemClickListener {
    private List<Ghichu> quanlyList;
    private GhichuAdapter adapter;
    private RecyclerView recyclerView;
    private GhichuDAO ghichuDAO;
    private FloatingActionButton fl;
    Dialog dialog;
    private TextView tv1;
    private TextView tv2;
    private Button btn_luu;
    private EditText tv4;
    private EditText tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichu);
        recyclerView = findViewById(R.id.rvquanly);
        quanlyList = new ArrayList<>();
//        for (int i = 1; i < 40; i++) {
//            quanlyList.add(new Quanly("Gà" + i, "Tốt", "15" + i));
//
//        }

        adapter = new GhichuAdapter(GhichuActivity.this, quanlyList, this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        ghichuDAO = new GhichuDAO(GhichuActivity.this);
        quanlyList = ghichuDAO.getGhichu();


        initView();
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GhichuActivity.this, AddGhichuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        quanlyList.clear();
        quanlyList = ghichuDAO.getGhichu();
        adapter.changeDataset(ghichuDAO.getGhichu());
    }

    private void initView() {
        fl = (FloatingActionButton) findViewById(R.id.fl);

    }

    @Override
    public void onLongClick(int i, View view) {
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(final int position) {
        dialog = new Dialog(GhichuActivity.this);
        dialog.setContentView(R.layout.dialog_ghichu);
        dialog.setTitle("Chi tiết");
        tv1 =  dialog.findViewById(R.id.tvtieude);
        tv2 =  dialog.findViewById(R.id.tvnoidung);

        dialog.show();

        tv1.setText(String.valueOf(quanlyList.get(position).getTieude()));
        tv2.setText(String.valueOf(quanlyList.get(position).getNoidung()));


//        btn_luu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String a1 = tv1.getText().toString();
//                String a2 = tv1.getText().toString();
//                String a3 = tv1.getText().toString();
//                String a4 = tv1.getText().toString();
//                quanlyList = ghichuDAO.getGhichu();
//
//
//            }
//        });

    }

    public void back(View view) {
        finish();
    }


}
