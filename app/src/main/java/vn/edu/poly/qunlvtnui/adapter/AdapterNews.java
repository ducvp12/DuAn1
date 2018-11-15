package vn.edu.poly.qunlvtnui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vn.edu.poly.qunlvtnui.R;
import vn.edu.poly.qunlvtnui.WebViewActivity;
import vn.edu.poly.qunlvtnui.model.HolderNews;
import vn.edu.poly.qunlvtnui.model.News;

public class AdapterNews extends RecyclerView.Adapter<HolderNews> {
   private Context context;
    private List<News> newsList;

    public AdapterNews(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public HolderNews onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemnews, parent,false);
        return new HolderNews(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderNews holder, int position) {
        News itemnews= newsList.get(position);
        holder.tvTitle.setText(itemnews.title);
        holder.tvDate.setText(itemnews.pubDate);
        holder.tvDes.setText(itemnews.description);
        holder.tvLink.setText(itemnews.link);
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("ok", holder.tvLink.getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
