package com.example.takeaway_bh.Customer.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.takeaway_bh.Customer.ChangeAddress;
import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private String username;

    private FragmentHomeBinding binding;

    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        CustomerIndex activity= (CustomerIndex) getActivity();
        username= activity.username;

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