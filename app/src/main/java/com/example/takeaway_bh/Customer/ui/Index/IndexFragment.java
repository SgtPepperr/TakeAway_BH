package com.example.takeaway_bh.Customer.ui.Index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.Customer.StoreAdapter;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.FragmentIndexBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class IndexFragment extends Fragment {
    private List<Store> storeList = new ArrayList<>();
    private FragmentIndexBinding binding;
//    private String username;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentIndexBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CustomerIndex activity = (CustomerIndex) getActivity();
//        username= activity.username;

        List<Store> stores = LitePal.findAll(Store.class);
        binding.imageView2.setImageResource(R.drawable.head_2);

//        for(Store s:stores){
//            Log.d("LoginActivity","storename is "+s.getStoreName());                      //调试模块部分，对商店图片信息进行初始化
//            s.setImageId(R.drawable.banana_pic);
//            s.save();
////            s.save();
//        }

        storeList = LitePal.findAll(Store.class);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        binding.recyclerStore.setLayoutManager(layoutManager);
        StoreAdapter adapter = new StoreAdapter(storeList);
        binding.recyclerStore.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}