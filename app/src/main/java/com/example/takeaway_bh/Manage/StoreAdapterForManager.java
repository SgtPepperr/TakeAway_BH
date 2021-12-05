package com.example.takeaway_bh.Manage;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.R;

import java.util.List;

public class StoreAdapterForManager extends RecyclerView.Adapter<StoreAdapterForManager.ViewHolder> {
    private List<Store> mStoreList;
    private Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View storeview;
        ImageView storeImage;
        TextView storeName, storeDesc, tvAdd,tvDelete,tvCheck;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storeview = itemView;
            storeImage = itemView.findViewById(R.id.store_image);
            storeName = itemView.findViewById(R.id.store_name);
            storeDesc = itemView.findViewById(R.id.tvDesc);
            tvAdd = itemView.findViewById(R.id.tvAdd);
            tvDelete = itemView.findViewById(R.id.tvDelete);
            tvCheck = itemView.findViewById(R.id.tvCheck);
        }
    }

    public StoreAdapterForManager(List<Store> mStoreList, Context context) {
        this.mStoreList = mStoreList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store_for_add, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = mStoreList.get(position);
//        holder.storeImage.setImageResource(store.getImageId());
        holder.storeName.setText(store.getStoreName());
        holder.storeDesc.setText(store.getIntroduction());
        holder.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddGoodActivity.class);
                intent.putExtra("store_name", store.getStoreName());
                context.startActivity(intent);
            }
        });

        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleteGoodActivity.class);
                intent.putExtra("store_name", store.getStoreName());
                context.startActivity(intent);
            }
        });

        holder.tvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CheckGoodActivity.class);
                intent.putExtra("StoreName", store.getStoreName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStoreList.size();
    }

}
