package com.example.takeaway_bh.Customer;


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

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private List<Store> mStoreList;

    public StoreAdapter(List<Store> mStoreList) {
        this.mStoreList = mStoreList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.storeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Store store = mStoreList.get(position);
                Intent intent = new Intent(view.getContext(), StoreIndex.class);
                intent.putExtra("StoreName", store.getStoreName());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = mStoreList.get(position);
        holder.storeImage.setImageResource(store.getImageId());
        holder.storeName.setText(store.getStoreName());
    }

    @Override
    public int getItemCount() {
        return mStoreList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View storeview;
        ImageView storeImage;
        TextView storeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storeview = itemView;
            storeImage = itemView.findViewById(R.id.store_image);
            storeName = itemView.findViewById(R.id.store_name);
        }
    }

}
