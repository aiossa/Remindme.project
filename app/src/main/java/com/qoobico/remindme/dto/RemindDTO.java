package com.qoobico.remindme.dto;

public class RemindDTO {
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {

        return title;
    }

    public RemindDTO(String title) {
        this.title = title;

    }
}
