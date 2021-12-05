package com.example.takeaway_bh.Manage;

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

public class CheckGoodAdapter extends RecyclerView.Adapter<CheckGoodAdapter.ViewHolder> {

    private List<Good> mGoodList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View goodView;
        ImageView goodImage;
        TextView goodName;
        TextView goodPrice;
        TextView goodIntro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goodView = itemView;
            goodImage = itemView.findViewById(R.id.good_image);
            goodName = itemView.findViewById(R.id.good_name);
            goodPrice = itemView.findViewById(R.id.good_price);
            goodIntro = itemView.findViewById(R.id.good_intro);
        }
    }

    public CheckGoodAdapter(List<Good> mGoodList) {
        this.mGoodList = mGoodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.check_good_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Good good = mGoodList.get(position);
        holder.goodImage.setImageResource(good.getImageId());
        holder.goodName.setText(good.getName());
        holder.goodPrice.setText(String.valueOf(good.getPrice()));
        holder.goodIntro.setText(good.getIntroduction());
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }
}
