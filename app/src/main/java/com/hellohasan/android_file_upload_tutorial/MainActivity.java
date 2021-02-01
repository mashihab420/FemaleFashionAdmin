package com.hellohasan.android_file_upload_tutorial;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hellohasan.android_file_upload_tutorial.ModelClass.EventModel;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ImageSenderInfo;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.ApiInterface;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.NetworkCall;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.RetrofitApiClient;
import com.hellohasan.android_file_upload_tutorial.UI.AddProductActivity;
import com.hellohasan.android_file_upload_tutorial.UI.AllProductActivity;
import com.hellohasan.android_file_upload_tutorial.UI.CheckoutActivity;
import com.hellohasan.android_file_upload_tutorial.UI.UsersActivity;
import com.hellohasan.android_file_upload_tutorial.UI.ViewOrdersActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TextView totalTextview, userText, shopnametitle;
    List<ModelAllOrders> totalval;
    List<ModelAllOrders> totaluser;
    List<ModelAllOrders> currentmontsell;
    int total = 0;
    int currentsell = 0;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalTextview = findViewById(R.id.totalvalue);
        userText = findViewById(R.id.totaluserid);
        shopnametitle = findViewById(R.id.shopnametitleid);
        totalval = new ArrayList<>();
        totaluser = new ArrayList<>();
        currentmontsell = new ArrayList<>();

        getsubtotalvalue();



    }


    public void addproduct(View view) {

        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shopname");

        intent = new Intent(MainActivity.this, AddProductActivity.class);
        intent.putExtra("shopname", shop_name);
        startActivity(intent);

    }

    public void Viewproduct(View view) {
        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shopname");

        intent = new Intent(MainActivity.this, AllProductActivity.class);
        intent.putExtra("shopname", shop_name);
        startActivity(intent);
    }

    public void orders(View view) {

        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shopname");

        intent = new Intent(MainActivity.this, ViewOrdersActivity.class);
        intent.putExtra("shopname", shop_name);
        startActivity(intent);


    }

    public void user(View view) {
        Intent intent = new Intent(MainActivity.this, UsersActivity.class);
        startActivity(intent);
    }

    public void checkout(View view) {
        Intent intent = getIntent();
        String shop_name = intent.getStringExtra("shopname");

        intent = new Intent(MainActivity.this, CheckoutActivity.class);
        intent.putExtra("shopname", shop_name);
        startActivity(intent);


    }

    private void getsubtotalvalue() {

        //todo get All product
        Retrofit instance = RetrofitApiClient.getClient();
        apiInterface = instance.create(ApiInterface.class);

        apiInterface.getTotalSell().enqueue(new Callback<List<ModelAllOrders>>() {
            @Override
            public void onResponse(Call<List<ModelAllOrders>> call, Response<List<ModelAllOrders>> response) {
                totalval.addAll(response.body());


                for (i = 0; i < totalval.size(); i++) {
                    String valu = totalval.get(i).getTotal();

                    int val = Integer.parseInt(valu);
                    total = total + val;
                    totalTextview.setText(total + " BDT");
                }
            }

            @Override
            public void onFailure(Call<List<ModelAllOrders>> call, Throwable t) {

            }
        });




    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
