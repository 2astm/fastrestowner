package com.example.fastrestowner.fragments.menu;

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
import com.example.fastrestowner.controllers.entities.Menu;
import com.example.fastrestowner.controllers.entities.Restaurant;
import com.example.fastrestowner.fragments.restaurants.RestaurantsAdapter;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<Menu> menuList;
    private LayoutInflater layoutInflater;
    private float density;
    private ItemClicked listener;

    public MenuAdapter(List<Menu> menuList, Context context, float density) {
        this.menuList = menuList;
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
        View view = layoutInflater.inflate(R.layout.menu_item, parent, false);
        MenuAdapter.ViewHolder vh = new MenuAdapter.ViewHolder(view);
        vh.buttonEditTitle.setOnClickListener(v -> {
            Menu menu = menuList.get(vh.getAdapterPosition());
            menu.setTitleChanging(!menu.isTitleChanging());
            menu.setTitle(vh.title_edit.getText().toString());
            this.notifyItemChanged(vh.getAdapterPosition());
        });
        vh.buttonEditIngredients.setOnClickListener(v -> {
            Menu menu = menuList.get(vh.getAdapterPosition());
            menu.setIngredientsChanging(!menu.isIngredientsChanging());
            menu.setIngredients(vh.editIngredients.getText().toString());
            this.notifyItemChanged(vh.getAdapterPosition());
        });
        vh.buttonEditPrice.setOnClickListener(v -> {
            Menu menu = menuList.get(vh.getAdapterPosition());
            menu.setIsPriceChanging(!menu.isPriceChanging());
            menu.setPrice(vh.editPrice.getText().toString());
            this.notifyItemChanged(vh.getAdapterPosition());
        });
        vh.itemView.setOnClickListener(v -> {
            Log.d("MenuAdapter", "ItemClicked " + vh.getAdapterPosition());
            if (listener != null)
                listener.itemClicked(vh.getAdapterPosition());
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        Picasso.get().load(menu.getLogo())
                .placeholder(R.drawable.outline_ramen_dining_24)
                .error(R.drawable.outline_ramen_dining_24)
                .resize((int) (64 * density), (int) (64 * density))
                .into(holder.logo);
        holder.title_edit.setText(menu.getTitle());
        holder.title.setText(menu.getTitle());
        holder.editPrice.setText(String.valueOf(menu.getPrice()));
        holder.price.setText(String.valueOf(menu.getPrice()));
        holder.ingredients.setText(menu.getIngredients());
        holder.editIngredients.setText(menu.getIngredients());
        holder.title.setVisibility(!menu.isTitleChanging()?View.VISIBLE:View.INVISIBLE);
        holder.title_edit.setVisibility(menu.isTitleChanging()?View.VISIBLE:View.INVISIBLE);
        holder.price.setVisibility(!menu.isPriceChanging()?View.VISIBLE:View.INVISIBLE);
        holder.editPrice.setVisibility(menu.isPriceChanging()?View.VISIBLE:View.INVISIBLE);
        holder.ingredients.setVisibility(!menu.isIngredientsChanging()?View.VISIBLE:View.INVISIBLE);
        holder.editIngredients.setVisibility(menu.isIngredientsChanging()?View.VISIBLE:View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView title;
        TextView ingredients;
        TextView price;
        EditText title_edit;
        EditText editIngredients;
        EditText editPrice;
        ImageView buttonEditTitle;
        ImageView buttonEditIngredients;
        ImageView buttonEditPrice;
        TextView address;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.item_menu_logo);
            title = itemView.findViewById(R.id.title);
            title_edit = itemView.findViewById(R.id.title_edit);
            ingredients = itemView.findViewById(R.id.ingredients);
            price = itemView.findViewById(R.id.price);
            buttonEditTitle = itemView.findViewById(R.id.editTitle);
            buttonEditIngredients = itemView.findViewById(R.id.ingredientsEdit);
            buttonEditPrice = itemView.findViewById(R.id.priceEdit);
            editIngredients = itemView.findViewById(R.id.ingredients_edit);
            editPrice = itemView.findViewById(R.id.price_edit);
        }
    }

    static interface ItemClicked {
        void itemClicked(int position);
    }
}
