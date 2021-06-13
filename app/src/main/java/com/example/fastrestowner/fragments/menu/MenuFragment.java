package com.example.fastrestowner.fragments.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.MenuProvider;

public class MenuFragment extends Fragment implements View.OnClickListener {


    MenuAdapter adapter;
    RecyclerView recyclerView;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_menu, container, false);
        adapter = new MenuAdapter(MenuProvider.getInstance().getRestaurants(), requireContext(), getResources().getDisplayMetrics().density);
        recyclerView = root.findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        root.findViewById(R.id.addItem).setOnClickListener(this);
//        adapter.setListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        MenuProvider.getInstance().createRestaurant();
        adapter.notifyItemInserted(MenuProvider.getInstance().getRestaurants().size() - 1);
        recyclerView.scrollToPosition(MenuProvider.getInstance().getRestaurants().size() - 1);
    }


}