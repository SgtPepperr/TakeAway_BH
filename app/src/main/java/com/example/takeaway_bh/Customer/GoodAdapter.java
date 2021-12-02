package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.R;

import java.util.List;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder>{
    private List<Good> mGoodList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View goodView;
        ImageView goodImage;
        TextView goodName;
        TextView goodPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goodView = itemView;
            goodImage = itemView.findViewById(R.id.good_image);
            goodName = itemView.findViewById(R.id.good_name);
            goodPrice = itemView.findViewById(R.id.good_price);
        }
    }

    public GoodAdapter(List<Good> mGoodList) {
        this.mGoodList = mGoodList;
    }

    @NonNull
    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.good_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.goodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Good good = mGoodList.get(position);
                Intent intent = new Intent(view.getContext(), GoodIndex.class);
                intent.putExtra("Name",good.getName());
                intent.putExtra("StoreName",good.getStoreName());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Good good = mGoodList.get(position);
        holder.goodImage.setImageResource(good.getImageId());
        holder.goodName.setText(good.getName());
            Log.d("GoodAdapter","price is "+ good.getPrice() );
        holder.goodPrice.setText(String.valueOf(good.getPrice()));
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }
}
