package vn.edu.poly.qunlvtnui.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import vn.edu.poly.qunlvtnui.R;

public class HolderNews extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public TextView tvDes;
    public TextView tvDate;
    public TextView tvLink;



    public HolderNews(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDes = (TextView) itemView.findViewById(R.id.tvDes);
        tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        tvLink = (TextView) itemView.findViewById(R.id.tv_link);
    }
}
