package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.Rider.RiderOrderInfo;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<TakeOrder> mOrderList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View Orderview;
        TextView OrderName;
        TextView OrderTime;
        TextView OrderState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Orderview = itemView;
            OrderName = itemView.findViewById(R.id.order_name);
            OrderTime = itemView.findViewById(R.id.order_time);
            OrderState = itemView.findViewById(R.id.order_statement);
        }
    }

    public OrderAdapter(List<TakeOrder> mOrderList) {
        this.mOrderList = mOrderList;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        final OrderAdapter.ViewHolder holder = new OrderAdapter.ViewHolder(view);
        holder.Orderview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                TakeOrder order = mOrderList.get(position);
                Intent intent;
                if (MyApp.isIsRider()) {
                    intent = new Intent(view.getContext(), RiderOrderInfo.class);
                } else {
                    intent = new Intent(view.getContext(), OrderInfo.class);
                }
                intent.putExtra("OrderId", order.getName());
                parent.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        TakeOrder order = mOrderList.get(position);
        holder.OrderName.setText(order.getName());
        holder.OrderTime.setText("订单下单时间" + order.getTakeorder_time());
        if (order.isOver()) {
            holder.OrderState.setText("订单状态：已完成");
        } else if (order.isReceive()) {
            holder.OrderState.setText("订单状态：已接单");
        } else {
            holder.OrderState.setText("订单状态：已下单");
        }
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }
}
