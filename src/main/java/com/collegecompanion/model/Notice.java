package com.collegecompanion.model;

import java.util.Objects;

public class Notice {
    private int id;
    private String content;
    private String date;

    public Notice() {}

    public Notice(int id, String content, String date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Notice notice = (Notice) o;
        return id == notice.id && Objects.equals(content, notice.content) && Objects.equals(date, notice.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, date);
    }
}
