package com.example.fastrestowner.fragments.restaurants;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.entities.Restaurant;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.ViewHolder> {

    private List<Restaurant> restaurantList;
    private LayoutInflater layoutInflater;
    private float density;
    private ItemClicked listener;

    public RestaurantsAdapter(List<Restaurant> restaurantList, Context context, float density) {
        this.restaurantList = restaurantList;
        this.layoutInflater = LayoutInflater.from(context);
        this.density = density;
    }

    public void setListener(ItemClicked listener) {
        this.listener = listener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.restaurant_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        vh.buttonEditTitle.setOnClickListener(v -> {
            Restaurant restaurant = restaurantList.get(vh.getAdapterPosition());
            restaurant.setChanging(!restaurant.isChanging());
            restaurant.setTitle(vh.title_edit.getText().toString());
            this.notifyItemChanged(vh.getAdapterPosition());
        });
        vh.itemView.setOnClickListener(v-> {
            if (listener != null)
                listener.itemClicked(vh.getAdapterPosition());
        });
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        if (restaurant.getCompanyIcon() != null)
            Picasso.get()
                    .load(restaurant.getCompanyIcon())
                    .placeholder(R.drawable.outline_storefront_24)
                    .error(R.drawable.outline_storefront_24)
                    .resize((int)(65 * density) , (int)(65 * density))
                    .into(holder.logo);
        else
            holder.logo.setImageResource(R.drawable.outline_storefront_24);
        holder.title.setText(restaurant.getTitle());
        holder.title_edit.setText(restaurant.getTitle());
        Log.d("RestaurantsAdapter", "changing: " + restaurant.isChanging());
        if (restaurant.isChanging()) {
            holder.title.setVisibility(View.INVISIBLE);
            holder.title_edit.setVisibility(View.VISIBLE);
        } else {
            holder.title.setVisibility(View.VISIBLE);
            holder.title_edit.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView logo;
        TextView title;
        EditText title_edit;
        ImageView buttonEditTitle;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            title = itemView.findViewById(R.id.title);
            title_edit = itemView.findViewById(R.id.title_edit);
            buttonEditTitle = itemView.findViewById(R.id.editTitle);
        }
    }

    public static interface ItemClicked {
        void itemClicked(int position);
    }
}
