package vn.edu.poly.qunlvtnui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import vn.edu.poly.qunlvtnui.ItemClickListener;
import vn.edu.poly.qunlvtnui.dao.QuanlyDAO;
import vn.edu.poly.qunlvtnui.model.Quanly;
import vn.edu.poly.qunlvtnui.R;

public class QuanlyAdapter extends RecyclerView.Adapter<QuanlyAdapter.ViewHoder> {

    private Context context;
    private List<Quanly> quanlyList;
    private ItemClickListener itemClickListener;
    private QuanlyDAO quanlyDAO;
    public QuanlyAdapter(Context context, List<Quanly> quanlyList, ItemClickListener itemClickListener) {
        this.context = context;
        this.quanlyList = quanlyList;
        this.itemClickListener = itemClickListener;
        quanlyDAO=new QuanlyDAO(context);
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_quanly, parent, false);


        return new ViewHoder(itemView);
    }

    public class ViewHoder extends RecyclerView.ViewHolder  {
        public ImageView imgDelete,iconpet;
        public TextView tvName, tvTrangThai;
        public TextView tvsoluong;


        public ViewHoder(View itemView) {
            super(itemView);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            tvTrangThai = itemView.findViewById(R.id.tv_trangthai);
            tvName = itemView.findViewById(R.id.tv_name);
            tvsoluong = itemView.findViewById(R.id.tv_soluong);
            iconpet=itemView.findViewById(R.id.iconpet);
        }


    }
    public void showAlertDialog(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa dữ liệu");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Ứ chịu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context, "Hủy", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                quanlyDAO.deleteQuanly(quanlyList.get(position).getName());
                quanlyList.remove(position);
                notifyDataSetChanged();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHoder holder, final int position) {
        Quanly st = quanlyList.get(position);
        holder.tvName.setText(st.getName());
        holder.tvTrangThai.setText(st.getTrangthai());
        holder.tvsoluong.setText(st.getSoluong());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showAlertDialog(position);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(holder.getAdapterPosition());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemClickListener.onClick(holder.getAdapterPosition());
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return quanlyList.size();
    }
    public void changeDataset(List<Quanly> items) {
        this.quanlyList = items;
        notifyDataSetChanged();
    }



}
