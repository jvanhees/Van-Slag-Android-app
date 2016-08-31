package net.vanslag.vanslag.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by JVH on 25/08/16.
 */
public class News {
    @SerializedName("id")
    long id;

    @SerializedName("created_at")
    public Date dateCreated;

    public String title;
    public String slug;
    public String body;
}
