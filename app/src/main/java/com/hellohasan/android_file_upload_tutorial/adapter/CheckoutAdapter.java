package com.hellohasan.android_file_upload_tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hellohasan.android_file_upload_tutorial.ModelClass.CheckoutModel;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelUser;
import com.hellohasan.android_file_upload_tutorial.R;
import com.hellohasan.android_file_upload_tutorial.SendData;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.MyViewHolder> {
    List<ModelUser> checkoutModelList;
    Context context;



    public CheckoutAdapter(List<ModelUser> checkoutModelList, Context context) {
        this.checkoutModelList = checkoutModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(checkoutModelList.get(position).getName());
        holder.phone.setText(checkoutModelList.get(position).getPhone());
        holder.address.setText(checkoutModelList.get(position).getAddress());



    }

    @Override
    public int getItemCount() {
        return checkoutModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone,address;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nametv);
            phone = itemView.findViewById(R.id.phonetv);
            address = itemView.findViewById(R.id.addresstv);
        }
    }
}
