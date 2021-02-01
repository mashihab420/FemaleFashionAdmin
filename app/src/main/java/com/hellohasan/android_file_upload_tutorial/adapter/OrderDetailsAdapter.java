package com.hellohasan.android_file_upload_tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.R;
import com.hellohasan.android_file_upload_tutorial.SendData;

import java.util.List;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder> {
    private List<ModelAllOrders> orders;
    Context context;

    private SendData sendData;


    public OrderDetailsAdapter(List<ModelAllOrders> orders, Context context,SendData sendData) {
        this.orders = orders;
        this.context = context;
        this.sendData = sendData;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_details,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(orders.get(position).getProduct_Name());
        holder.price.setText(orders.get(position).getPPrice()+" BDT");
        holder.quantity.setText("Quantity: "+orders.get(position).getQuantity());
        holder.size.setText("Size: "+orders.get(position).getSize());

      String totall =  orders.get(position).getTotal();


        sendData.totalPrice(totall);

       // total = total+Integer.parseInt(subtotal);

        Glide
                .with(context)
                .load(orders.get(position).getUrl())
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+orders.get(position).getUrl(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price,quantity,size;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView6);
            name = itemView.findViewById(R.id.textView7);
            price = itemView.findViewById(R.id.textView8);
            quantity = itemView.findViewById(R.id.textView21);
            size = itemView.findViewById(R.id.textView23);
        }
    }
}
