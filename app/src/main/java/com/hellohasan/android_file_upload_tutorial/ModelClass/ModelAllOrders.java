package com.hellohasan.android_file_upload_tutorial.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAllOrders {
    @SerializedName("id")
    private String id;


    @SerializedName("invoice_number")
    private String InvoiceNumber;

    @SerializedName("order_status")
    private String OrderStatus;

    @SerializedName("phone")
    private String Phone;

    @SerializedName("password")
    private String Password;

    @SerializedName("message")
    private String Message;

    @SerializedName("product_name")
    private String Product_Name;

    @SerializedName("name")
    private String Name;

    @SerializedName("user_phone")
    private String UserPhone;

    @SerializedName("price")
    private String Price;

    @SerializedName("product_price")
    private String PPrice;

    @SerializedName("quantity")
    private String Quantity;

    @SerializedName("shop_name")
    private String Shop_Name;

    @SerializedName("delivery_time")
    private String Delivery_Time;

    @SerializedName("delivery_type")
    private String Delivery_Type;

    @SerializedName("subtotal")
    private String Subtotal;

    @SerializedName("discount")
    private String Discount;

    @SerializedName("total")
    private String Total;

    @SerializedName("image_url")
    private String Image_Url;


    @SerializedName("url")
    private String Url;

    @SerializedName("size")
    private String Size;

    @SerializedName("totaluser")
    private String Totaluser;

    @SerializedName("date")
    private String Date;

    @SerializedName("month")
    private String Month;

    @SerializedName("response")
    @Expose
    private String response;

    public String getId() {
        return id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getShop_Name() {
        return Shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        Shop_Name = shop_Name;
    }

    public String getDelivery_Time() {
        return Delivery_Time;
    }

    public void setDelivery_Time(String delivery_Time) {
        Delivery_Time = delivery_Time;
    }

    public String getDelivery_Type() {
        return Delivery_Type;
    }

    public void setDelivery_Type(String delivery_Type) {
        Delivery_Type = delivery_Type;
    }

    public String getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(String subtotal) {
        Subtotal = subtotal;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    public String getTotaluser() {
        return Totaluser;
    }

    public void setTotaluser(String totaluser) {
        Totaluser = totaluser;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPPrice() {
        return PPrice;
    }

    public void setPPrice(String PPrice) {
        this.PPrice = PPrice;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }
}
