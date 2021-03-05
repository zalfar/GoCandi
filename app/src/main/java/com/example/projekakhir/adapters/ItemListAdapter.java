package com.example.projekakhir.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekakhir.R;
import com.example.projekakhir.activities.DetailActivity;
import com.example.projekakhir.models.Hewan;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Hewan> listHewan;

    public ItemListAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Hewan> getListHewan() {
        return listHewan;
    }

    public void setListHewan(ArrayList<Hewan> listHewan) {
        this.listHewan = listHewan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        holder.tvName.setText(getListHewan().get(position).getName());
        holder.tvOrdo.setText(getListHewan().get(position).getOrdo());

        Glide.with(context).load(getListHewan().get(position).getPhoto()).into(holder.imgList);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(context, DetailActivity.class);
                detailActivity.putExtra(DetailActivity.EXTRA_HEWAN, listHewan.get(position));
                context.startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListHewan().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvOrdo;
        ImageView imgList;
        RelativeLayout relativeLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_list);
            tvOrdo = itemView.findViewById(R.id.tv_ordo_list);
            imgList = itemView.findViewById(R.id.img_list);
            relativeLayout = itemView.findViewById(R.id.relative_layout);
        }
    }
}
