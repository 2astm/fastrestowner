package com.example.fastrestowner.fragments.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.OrderProvider;

public class OrdersFragment extends Fragment {

    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_orders, container, false);

        recyclerView = root.findViewById(R.id.list);
        orderAdapter = new OrderAdapter(OrderProvider.getInstance().getOrders(), requireContext(), getResources().getDisplayMetrics().density);
        recyclerView.setAdapter(orderAdapter);

        return root;
    }
}