package com.example.practical14;

public class ChatItem {
    private String name;
    private String message;
    private String time;
    private int profileImage;

    public ChatItem(String name, String message, String time, int profileImage) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
