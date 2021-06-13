package com.example.fastrestowner.fragments.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastrestowner.R;
import com.example.fastrestowner.controllers.entities.Menu;
import com.example.fastrestowner.controllers.entities.Order;
import com.example.fastrestowner.fragments.menu.MenuAdapter;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Order> orderList;
    private LayoutInflater layoutInflater;
    private float density;
    private ItemClicked listener;

    public OrderAdapter(List<Order> orderList, Context context, float density) {
        this.orderList = orderList;
        this.layoutInflater = LayoutInflater.from(context);
        this.density = density;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ViewHolder vh = new ViewHolder(layoutInflater.inflate(R.layout.order_item, parent, false));
        vh.itemView.setOnClickListener(v -> {
            if (listener != null) listener.clciked(vh.getAdapterPosition());
        });
        vh.readyButton.setOnClickListener(v -> {
            orderList.get(vh.getAdapterPosition()).setAccepted(true);
            notifyItemChanged(vh.getAdapterPosition());
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Order order = orderList.get(position);
        holder.order.setText(order.getItems().toString());
        holder.comment.setText(order.getComment());
        holder.time.setText(order.getTime());
        holder.readyButton.setText(order.isAccepted()?"Accept":"Ready");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView order;
        TextView comment;
        TextView time;
        Button readyButton;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            order = itemView.findViewById(R.id.textView2);
            comment = itemView.findViewById(R.id.textView);
            time = itemView.findViewById(R.id.textView3);
            readyButton = itemView.findViewById(R.id.ready_button);
        }
    }

    public interface ItemClicked {
        void clciked(int position);
    }
}
