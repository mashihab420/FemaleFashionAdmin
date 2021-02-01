package com.hellohasan.android_file_upload_tutorial.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAddProduct;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.ApiInterface;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.RetrofitApiClient;
import com.hellohasan.android_file_upload_tutorial.R;
import com.hellohasan.android_file_upload_tutorial.UI.ui.OrderDetailActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AllOrdersAdapter extends RecyclerView.Adapter<AllOrdersAdapter.MyViewHolder> {

    private List<ModelAllOrders> orders;
    Context context;


    public AllOrdersAdapter(List<ModelAllOrders> orders, Context context) {
        this.orders = orders;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_orders,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.ordernumber.setText("#"+orders.get(position).getInvoiceNumber());
        holder.phone.setText(orders.get(position).getUserPhone());
        holder.date.setText(orders.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String invoice = orders.get(position).getInvoiceNumber();
                String phone = orders.get(position).getUserPhone();
                Intent intent = new Intent(context, OrderDetailActivity.class);
               intent.putExtra("invoiceno",invoice);
                intent.putExtra("phone",phone);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);;
            }
        });


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ordernumber,date,phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ordernumber = itemView.findViewById(R.id.textView11);
            phone = itemView.findViewById(R.id.orderid);
            date = itemView.findViewById(R.id.textView5);

        }
    }
}
