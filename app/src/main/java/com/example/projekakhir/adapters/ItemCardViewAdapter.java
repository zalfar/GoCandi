package com.example.projekakhir.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projekakhir.R;
import com.example.projekakhir.activities.DetailActivity;
import com.example.projekakhir.models.Hewan;

import java.util.ArrayList;

public class ItemCardViewAdapter extends RecyclerView.Adapter<ItemCardViewAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Hewan> listHewan;

    public ItemCardViewAdapter(Context context) {
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
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        holder.tvName.setText(getListHewan().get(position).getName());
        holder.tvDescription.setText(getListHewan().get(position).getDescription());
        Glide.with(context).load(getListHewan().get(position).getPhoto()).into(holder.imgPhoto);

        holder.button.setOnClickListener(new View.OnClickListener() {
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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        Button button;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_card);
            tvName = itemView.findViewById(R.id.tv_name_card);
            tvDescription = itemView.findViewById(R.id.tv_desc_card);
            button = itemView.findViewById(R.id.button);
        }
    }
}
