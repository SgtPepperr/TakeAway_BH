package com.example.takeaway_bh.Customer.ui.Index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.databinding.FragmentIndexBinding;


public class IndexFragment extends Fragment {

    private FragmentIndexBinding binding;
    private String username;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentIndexBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CustomerIndex activity= (CustomerIndex) getActivity();
        username= activity.username;

        final TextView textView = binding.textNotifications;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}