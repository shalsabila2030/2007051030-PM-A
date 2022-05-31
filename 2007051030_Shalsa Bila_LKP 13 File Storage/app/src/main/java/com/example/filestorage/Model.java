package com.example.filestorage;

public class Model {
    private String title;
    private String content;

    String getTitle() {
        return title;
    }

    void setTitle(String filename) {
        this.title = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String data) {
        this.content = data;
    }
}

