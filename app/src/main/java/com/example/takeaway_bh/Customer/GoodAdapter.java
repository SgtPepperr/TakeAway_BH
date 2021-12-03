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
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.R;

import java.util.HashMap;
import java.util.List;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder> {
    public static List<Good> mGoodList;
    private HashMap<String, Integer> map = new HashMap<>();
    private int count = 0;
    private float price = 0;

    public interface onItemClickListener {
        void onItemClick(View view,int position);
    }

    private onItemClickListener monItemClickListener;

    public void setonItemClickListener(onItemClickListener monItemClickListener) {
        this.monItemClickListener = monItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View goodView;
        ImageView goodImage;
        TextView goodName;
        TextView goodPrice;
        TextView goodAdd;
        TextView goodCount;
        TextView goodSub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goodView = itemView;
            goodImage = itemView.findViewById(R.id.good_image);
            goodName = itemView.findViewById(R.id.good_name);
            goodPrice = itemView.findViewById(R.id.good_price);
            goodAdd = itemView.findViewById(R.id.store_add);
            goodCount = itemView.findViewById(R.id.count);
            goodSub = itemView.findViewById(R.id.store_minus);

        }

    }

    public GoodAdapter(List<Good> mGoodList) {
        this.mGoodList = mGoodList;
//        Log.d("GoodAdapter","wuwu");
//        Log.d("GoodAdapter", String.valueOf(m_count==null));
//        Log.d("GoodAdapter",m_count.toString());
//        this.m_count = m_count;
//        this.m_price = m_price;
    }

    @NonNull
    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.good_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.goodName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Good good = mGoodList.get(position);
                Intent intent = new Intent(view.getContext(), GoodIndex.class);
                intent.putExtra("Name", good.getName());
                intent.putExtra("StoreName", good.getStoreName());
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
        Log.d("GoodAdapter", "price is " + good.getPrice());
        holder.goodPrice.setText(String.valueOf(good.getPrice()));

        if(monItemClickListener!=null){
            holder.goodAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=holder.getLayoutPosition();
                    monItemClickListener.onItemClick(holder.goodView,pos);
                }
            });
        }
//        holder.goodAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Log.d("GoodAdapter","wuwu");
////                Log.d("GoodAdapter", String.valueOf(m_count==null));
////                Log.d("GoodAdapter",m_count.toString());
////                Log.d("GoodAdapter",m_price.toString());
////                Log.d("GoodAdapter",holder.goodCount.toString());
////                Log.d("GoodAdapter",holder.goodSub.toString());
////                Log.d("GoodAdapter",holder.goodCount.toString());
//                int cou=0;
//                if (map.containsKey(good.getName())) {
//                    cou = map.get(good.getName());
//                }
//                map.put(good.getName(), cou + 1);
//                holder.goodCount.setVisibility(View.VISIBLE);
//                holder.goodSub.setVisibility(View.VISIBLE);
//                holder.goodCount.setText(String.valueOf(cou+1));
//                count++;
//                price += good.getPrice();
//                m_count.setText(count);
//                m_price.setText("$" + price);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }

    public static List<Good> getmGoodList() {
        return mGoodList;
    }
}
