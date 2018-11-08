package vn.edu.poly.qunlvtnui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.edu.poly.qunlvtnui.model.Quanly;
import vn.edu.poly.qunlvtnui.R;

public class QuanlyAdapter extends RecyclerView.Adapter<QuanlyAdapter.ViewHoder> {

    private List<Quanly> studentList;

    public QuanlyAdapter(List<Quanly> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_quanly, parent, false);


        return new ViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Quanly st = studentList.get(position);
        holder.tvName.setText(st.getName());
        holder.tvTrangThai.setText(st.getTrangthai());
        holder.tvsoluong.setText(st.getSoluong());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        public ImageView imgAvatar;
        public TextView tvName,tvTrangThai;
        public TextView tvsoluong;

        public ViewHoder(View itemView) {
            super(itemView);

            tvTrangThai = itemView.findViewById(R.id.tv_trangthai);
            tvName = itemView.findViewById(R.id.tv_name);
            tvsoluong = itemView.findViewById(R.id.tv_soluong);
        }
    }
}
