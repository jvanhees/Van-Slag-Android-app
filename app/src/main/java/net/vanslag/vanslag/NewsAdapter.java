package net.vanslag.vanslag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JVH on 25/08/16.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> NewsItems) {
        super(context, 0, NewsItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        News newsItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        // Lookup view for data population
        TextView newsTitle = (TextView) convertView.findViewById(R.id.title);
        TextView newsDate = (TextView) convertView.findViewById(R.id.date);
        TextView newsBody = (TextView) convertView.findViewById(R.id.body);

        // Populate the data into the template view using the data object
        newsTitle.setText(newsItem.title);
        newsDate.setText(newsItem.dateCreated.toString());
        newsBody.setText(newsItem.body);
        // Return the completed view to render on screen
        return convertView;
    }

}
