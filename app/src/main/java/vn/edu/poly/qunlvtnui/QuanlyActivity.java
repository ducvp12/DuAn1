package vn.edu.poly.qunlvtnui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.qunlvtnui.adapter.QuanlyAdapter;
import vn.edu.poly.qunlvtnui.model.AddVatnuoiActivity;
import vn.edu.poly.qunlvtnui.model.Quanly;

public class QuanlyActivity extends AppCompatActivity {
    private List<Quanly> quanlyList;
    private QuanlyAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayout ln;
    private RecyclerView rvquanly;
    private FloatingActionButton fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanly);
        recyclerView = findViewById(R.id.rvquanly);
        quanlyList = new ArrayList<>();
        for (int i = 1; i < 40; i++) {
            quanlyList.add(new Quanly("Gà" + i, "Tốt", "15" + i));

        }
        adapter = new QuanlyAdapter(quanlyList);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        initView();
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuanlyActivity.this, AddVatnuoiActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        ln = (LinearLayout) findViewById(R.id.ln);
        rvquanly = (RecyclerView) findViewById(R.id.rvquanly);
        fl = (FloatingActionButton) findViewById(R.id.fl);
    }
}
