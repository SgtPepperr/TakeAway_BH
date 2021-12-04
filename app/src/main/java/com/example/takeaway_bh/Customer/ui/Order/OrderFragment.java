package com.example.takeaway_bh.Customer.ui.Order;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.Customer.OrderAdapter;
import com.example.takeaway_bh.Customer.StoreAdapter;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.FragmentOrderBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {

    private String username;
    private List<TakeOrder> orderlist=new ArrayList<>();

    private FragmentOrderBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentOrderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.fragmentOrderViewImage.setImageResource(R.drawable.banana_pic);


        CustomerIndex activity= (CustomerIndex) getActivity();
        username= activity.username;
        orderlist= LitePal.where("customer_user = ?",username).find(TakeOrder.class);

        List<TakeOrder> orders=LitePal.findAll(TakeOrder.class);

        for(TakeOrder s:orders){
            Log.d("OrderFragment","username is "+s.getSales_user());
            Log.d("OrderFragment","id is "+s.getName());
        }

        for(TakeOrder s:orderlist){
            Log.d("OrderFragment","storename is "+s.getName());
        }

        LinearLayoutManager layoutManager=new LinearLayoutManager(activity);
        binding.recyclerOrderList.setLayoutManager(layoutManager);
        OrderAdapter adapter=new OrderAdapter(orderlist);
        binding.recyclerOrderList.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}