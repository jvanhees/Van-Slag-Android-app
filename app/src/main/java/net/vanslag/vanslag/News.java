package net.vanslag.vanslag;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by JVH on 25/08/16.
 */
public class News {
    @SerializedName("id")
    long id;

    @SerializedName("created_at")
    Date dateCreated;

    String title;
    String slug;
    String body;
}
