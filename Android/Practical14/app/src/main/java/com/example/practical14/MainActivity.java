package com.example.practical14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ChatAdapter chatAdapter;
    private List<ChatItem> chatItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Prepare some sample data
        chatItemList = new ArrayList<>();
        chatItemList.add(new ChatItem("Himanshu", "Hey, what's up?", "10:45 AM", R.drawable.ic_launcher_foreground));
        chatItemList.add(new ChatItem("Darshil", "See you soon!", "9:30 AM", R.drawable.ic_launcher_foreground));
        chatItemList.add(new ChatItem("Ronak", "Let's catch up later.", "Yesterday", R.drawable.ic_launcher_foreground));
        chatItemList.add(new ChatItem("Sumit", "Call me when you're free.", "Monday", R.drawable.ic_launcher_foreground));

        // Create an adapter and bind it to the ListView
        chatAdapter = new ChatAdapter(this, chatItemList);
        listView.setAdapter(chatAdapter);
    }
}
