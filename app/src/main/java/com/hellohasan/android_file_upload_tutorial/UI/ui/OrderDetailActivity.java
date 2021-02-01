package com.hellohasan.android_file_upload_tutorial.UI.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelUser;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.ApiInterface;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.RetrofitApiClient;
import com.hellohasan.android_file_upload_tutorial.R;
import com.hellohasan.android_file_upload_tutorial.SendData;
import com.hellohasan.android_file_upload_tutorial.adapter.AllOrdersAdapter;
import com.hellohasan.android_file_upload_tutorial.adapter.OrderDetailsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderDetailActivity extends AppCompatActivity implements SendData {
    private OrderDetailsAdapter orderDetailsAdapter;
    List<ModelAllOrders> orders;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    List<ModelUser> userList;
    TextView name, phone, address, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        recyclerView = findViewById(R.id.recyclerView);
        orders = new ArrayList<>();

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.textView12);
        total = findViewById(R.id.totaltaka);
        userList = new ArrayList<>();

        orderDetailsAdapter = new OrderDetailsAdapter(orders, getApplicationContext(), this);

        initRecyclerViewAllproduct(orderDetailsAdapter, recyclerView);
        getuserdata();
    }

    private void initRecyclerViewAllproduct(RecyclerView.Adapter adapter, RecyclerView view) {
        view.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        view.setAdapter(adapter);
        orderDetailsAdapter.notifyDataSetChanged();

        datasetallproduct();
    }

    private void datasetallproduct() {

        //todo get All product
        Retrofit instance = RetrofitApiClient.getClient();
        apiInterface = instance.create(ApiInterface.class);
        String invoice = getIntent().getStringExtra("invoiceno");
        ModelAllOrders modelAllOrders = new ModelAllOrders();
        modelAllOrders.setInvoiceNumber(invoice);
        apiInterface.getOrderDetails(modelAllOrders).enqueue(new Callback<List<ModelAllOrders>>() {
            @Override
            public void onResponse(Call<List<ModelAllOrders>> call, Response<List<ModelAllOrders>> response) {
                orders.addAll(response.body());
                orderDetailsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ModelAllOrders>> call, Throwable t) {

            }
        });


    }

    public void getuserdata() {
        Retrofit instance = RetrofitApiClient.getClient();
        apiInterface = instance.create(ApiInterface.class);
        String phonee = getIntent().getStringExtra("phone");
        ModelUser modelUser = new ModelUser();
        modelUser.setPhone("1");

        apiInterface.getUserinfo(modelUser).enqueue(new Callback<List<ModelUser>>() {
            @Override
            public void onResponse(Call<List<ModelUser>> call, Response<List<ModelUser>> response) {
                userList.addAll(response.body());

                name.setText("Name: " + userList.get(0).getName());
                phone.setText("Phone: " + userList.get(0).getPhone());
                address.setText("Address: " + userList.get(0).getAddress());

            }

            @Override
            public void onFailure(Call<List<ModelUser>> call, Throwable t) {

            }
        });


    }

    public void backbtn(View view) {
        onBackPressed();
    }

    @Override
    public void totalPrice(String subtotal) {
        total.setText(subtotal+" BDT");
    }
}