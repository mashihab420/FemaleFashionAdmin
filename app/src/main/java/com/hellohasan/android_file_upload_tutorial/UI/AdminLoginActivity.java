package com.hellohasan.android_file_upload_tutorial.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hellohasan.android_file_upload_tutorial.MainActivity;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.ApiInterface;
import com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass.RetrofitApiClient;
import com.hellohasan.android_file_upload_tutorial.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AdminLoginActivity extends AppCompatActivity {

    EditText phone,password;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        phone = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);
    }

    public void adminlogin(View view) {

        String phonee = phone.getText().toString();
        String pass = password.getText().toString();

        Retrofit instance = RetrofitApiClient.getClient();
        apiInterface =instance.create(ApiInterface.class);

       if (phonee.equals("")){
            phone.setError("Enter Your Phone Number");
        }
       else if(pass.equals("")){
            password.setError("Enter Your Password");
        }
       else {
           if (phonee.equals("01760992374") && pass.equals("12345")){
               Intent intent = new Intent(AdminLoginActivity.this, MainActivity.class);
               phone.setText("");
               password.setText("");
               startActivity(intent);
           }else {
               Toast.makeText(this, "Phone or Password is incorrect!", Toast.LENGTH_SHORT).show();
           }

       }
         



    }
}