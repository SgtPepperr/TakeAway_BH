package com.example.takeaway_bh.Customer.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.takeaway_bh.Bean.Address;
import com.example.takeaway_bh.Customer.ChangeAddress;
import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.FragmentHomeBinding;

import org.litepal.LitePal;


public class HomeFragment extends Fragment {

    View root;
    private String username;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        root = binding.getRoot();

        CustomerIndex activity = (CustomerIndex) getActivity();
        username = activity.username;

        binding.userId.setText(username);

        if (MyApp.isIsRider()) {
            binding.userIfRider.setText("是");
        } else {
            binding.userIfRider.setText("否");
        }

        Address address = LitePal.where("userName is ?", MyApp.getUserName()).findFirst(Address.class);
        if (address != null)
            binding.userAddress.setText(address.getAddress());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = root.findViewById(R.id.change_address);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChangeAddress.class));
            }
        });
    }
}