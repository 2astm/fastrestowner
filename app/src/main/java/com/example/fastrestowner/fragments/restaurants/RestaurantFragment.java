package com.example.fastrestowner.fragments.restaurants;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.RestaurantProvider;
import com.example.fastrestowner.controllers.entities.Restaurant;

import java.util.List;

public class RestaurantFragment extends Fragment implements RestaurantsAdapter.ItemClicked {

    private View root;
    private RestaurantsAdapter adapter;
    private List<Restaurant> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_restaurant, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.list);
        list = RestaurantProvider.getInstance().getRestaurants();
        adapter = new RestaurantsAdapter(list, requireContext(), getResources().getDisplayMetrics().density);
        recyclerView.setAdapter(adapter);
        Button addRest = root.findViewById(R.id.addRest);
        addRest.setOnClickListener(v -> {
            list.add(new Restaurant("Example title", null));
            adapter.notifyItemInserted(list.size() - 1);
            recyclerView.scrollToPosition(list.size() - 1);
        });
        adapter.setListener(this);
        return root;
    }

    @Override
    public void itemClicked(int position) {
        Log.d("RestaurantFragment", "ItemClicked " + position);
        Navigation.findNavController(root).navigate(R.id.action_navigation_restaurants_to_navigation_menu);
    }
}