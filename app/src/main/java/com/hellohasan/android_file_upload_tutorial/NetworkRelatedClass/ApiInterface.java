package com.hellohasan.android_file_upload_tutorial.NetworkRelatedClass;

import com.hellohasan.android_file_upload_tutorial.ModelClass.ImageSenderInfo;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAddProduct;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelAllOrders;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ModelUser;
import com.hellohasan.android_file_upload_tutorial.ModelClass.ResponseModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ApiInterface {

    @Multipart
    @POST("upload.php")
    Call<ResponseModel> fileUpload(
            @Part("sender_information") RequestBody description,
            @Part MultipartBody.Part file);

    @POST("delete.php")
    Call<ImageSenderInfo> delete_account(@Body ImageSenderInfo imageSenderInfo);

    @POST("delete.php")
    Call<ModelAddProduct> delete_product(@Body ModelAddProduct modelAddProduct);

    @POST("get_orders.php")
    Call<List<ModelAllOrders>> getorders();

    @POST("getall.php")
    Call<List<ModelAddProduct>> getAlldata();

    @POST("update.php")
    Call<ImageSenderInfo> update(@Body ImageSenderInfo imageSenderInfo);


    @POST("get_orders.php")
    Call<List<ModelAllOrders>> getAllOrders();

    @POST("get_users.php")
    Call<List<ModelUser>> getAlluser();

    @POST("update_order_status.php")
    Call<ModelAllOrders> updateOrderStatus(@Body ModelAllOrders modelAllOrders);

    @POST("update_user_status.php")
    Call<ModelUser> updateUserStatus(@Body ModelUser modelAllOrders);


    @POST("checkoutdata.php")
    Call<List<ModelAllOrders>> checkoutdata(@Body ModelAllOrders modelAllOrders);

    @POST("get_order_details.php")
    Call<List<ModelAllOrders>> getOrderDetails(@Body ModelAllOrders modelAllOrders);

    @POST("get_total_sell.php")
    Call<List<ModelAllOrders>> getTotalSell();

    @POST("get_total_user.php")
    Call<List<ModelUser>> getTotalUser();

    @POST("get_total_user_info.php")
    Call<List<ModelUser>> getUserinfo(@Body ModelUser modelUser);

    @POST("get_current_month_sell.php")
    Call<List<ModelAllOrders>> getCurrentSell(@Body ModelAllOrders modelAllOrders);

    @GET("supper_shop_login.php")
    Call<ModelAllOrders> shoplogin(@Query("phone") String phone ,@Query("password") String pass);

}

//283887
