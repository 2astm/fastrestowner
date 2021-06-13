package com.example.fastrestowner.fragments.members;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.entities.Personal;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {

    private List<Personal> personalList;
    private LayoutInflater layoutInflater;
    private float density;
    private ItemClicked listener;

    public MembersAdapter(List<Personal> personalList, Context context, float density) {
        this.personalList = personalList;
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
        View view = layoutInflater.inflate(R.layout.member_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        vh.itemView.setOnClickListener(v -> {
            if (listener != null)
                listener.itemClicked(vh.getAdapterPosition());
        });
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Personal personal = personalList.get(position);
        holder.email.setText(personal.getEmail());
        holder.name
                .setText(
                        (personal.getName() + " " + personal.getSurname()));
        switch (personal.getStatus()) {
            case PENDING:
                holder.status.setTextColor(Color.BLUE);
                break;
            case REJECTED:
                holder.status.setTextColor(Color.RED);
                break;
            case CONNECTED:
                holder.status.setTextColor(Color.GREEN);
                break;
        }
        holder.status.setText(personal.getStatus().toString());
    }

    @Override
    public int getItemCount() {
        return personalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView status;
        TextView email;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);
            email = itemView.findViewById(R.id.email);
        }
    }

    public static interface ItemClicked {
        void itemClicked(int position);
    }
}
