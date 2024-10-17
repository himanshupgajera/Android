package com.example.practical14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends BaseAdapter {

    private Context context;
    private List<ChatItem> chatItems;

    public ChatAdapter(Context context, List<ChatItem> chatItems) {
        this.context = context;
        this.chatItems = chatItems;
    }

    @Override
    public int getCount() {
        return chatItems.size();
    }

    @Override
    public Object getItem(int position) {
        return chatItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ChatItem chatItem = chatItems.get(position);

        // Bind the data to the view
        ImageView profileImage = convertView.findViewById(R.id.profile_image);
        TextView mainTitle = convertView.findViewById(R.id.main_title);
        TextView subtitle = convertView.findViewById(R.id.subtitle);
        TextView time = convertView.findViewById(R.id.time);

        profileImage.setImageResource(chatItem.getProfileImage());
        mainTitle.setText(chatItem.getName());
        subtitle.setText(chatItem.getMessage());
        time.setText(chatItem.getTime());

        return convertView;
    }
}
