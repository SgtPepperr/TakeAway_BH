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
    private TextView m_count;
    private TextView m_price;
    private HashMap<String, Integer> map = new HashMap<>();
    private int countnums = 0;
    private float price = 0;

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

    public GoodAdapter(List<Good> mGoodList, TextView m_count, TextView m_price) {
        this.mGoodList = mGoodList;
//        Log.d("GoodAdapter","wuwu");
//        Log.d("GoodAdapter", String.valueOf(m_count==null));
//        Log.d("GoodAdapter",m_count.toString());
        this.m_count = m_count;
        this.m_price = m_price;
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

        holder.goodAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getLayoutPosition();
                Good good = mGoodList.get(pos);
                int cou = 0;
                if (map.containsKey(good.getName())) {
                    cou = map.get(good.getName());
                }
                map.put(good.getName(), cou + 1);
                View v=holder.goodView;
                TextView goodCount = v.findViewById(R.id.count);
                View goodSub = v.findViewById(R.id.store_minus);
                goodCount.setVisibility(View.VISIBLE);
                goodSub.setVisibility(View.VISIBLE);
                goodCount.setText(String.valueOf(cou + 1));
                countnums++;
                price += good.getPrice();
                m_count.setText(String.valueOf(countnums));
                m_price.setText("￥" + price);
            }
        });

        holder.goodSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getLayoutPosition();
                Good good = mGoodList.get(pos);
                int  cou = map.get(good.getName());

                map.put(good.getName(), cou -1);
                View v=holder.goodView;
                TextView goodCount = v.findViewById(R.id.count);
                View goodSub = v.findViewById(R.id.store_minus);

                goodCount.setText(String.valueOf(cou - 1));
                countnums--;
                price -= good.getPrice();
                m_count.setText(String.valueOf(countnums));
                m_price.setText("￥" + price);

                if(cou==1){
                    goodCount.setVisibility(View.GONE);
                    goodSub.setVisibility(View.GONE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGoodList.size();
    }

    public static List<Good> getmGoodList() {
        return mGoodList;
    }
}
