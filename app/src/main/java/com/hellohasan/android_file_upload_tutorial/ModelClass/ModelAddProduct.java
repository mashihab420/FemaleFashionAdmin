package com.hellohasan.android_file_upload_tutorial.ModelClass;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ModelAddProduct implements Parcelable {
    @SerializedName("id")
    private String id;

    @SerializedName("p_name")
    private String name;

    @SerializedName("p_price")
    private String price;

    @SerializedName("description")
    private String description;

    @SerializedName("category")
    private String categorys;

    @SerializedName("url")
    private String url;




    @SerializedName("message")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategorys() {
        return categorys;
    }

    public void setCategorys(String categorys) {
        this.categorys = categorys;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public ModelAddProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ModelAddProduct(String name, String price,String description,String categorys) {
        this.name = name;
        this.price = price;
        this.description=description;
        this.categorys = categorys;


    }

    public final static Parcelable.Creator<ModelAddProduct> CREATOR = new Parcelable.Creator<ModelAddProduct>() {

        @SuppressWarnings({
                "unchecked"
        })
        public ModelAddProduct createFromParcel(Parcel in) {
            ModelAddProduct instance = new ModelAddProduct();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.price = ((String) in.readValue((int.class.getClassLoader())));
            instance.description = ((String) in.readValue((int.class.getClassLoader())));
            instance.categorys = ((String) in.readValue((String.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ModelAddProduct[] newArray(int size) {
            return (new ModelAddProduct[size]);
        }

    };


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(price);
        dest.writeValue(description);
        dest.writeValue(categorys);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }
}
