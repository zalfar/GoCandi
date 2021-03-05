package com.example.projekakhir.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekakhir.R;
import com.example.projekakhir.activities.DetailActivity;
import com.example.projekakhir.models.Hewan;

import java.util.ArrayList;

public class ItemGridAdapter extends RecyclerView.Adapter<ItemGridAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hewan> listHewan;

    public ItemGridAdapter(Context context) {
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
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        Glide.with(context).load(getListHewan().get(position).getPhoto()).into(holder.imgGrid);
        holder.imgGrid.setOnClickListener(new View.OnClickListener() {
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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGrid;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGrid = itemView.findViewById(R.id.img_grid);
        }
    }
}
