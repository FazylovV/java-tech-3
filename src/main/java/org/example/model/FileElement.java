package org.example.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class File {
    private String path;
    private Long size;
    private Date date;
    public final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    public File(String path, Long size, Date date) {
        this.path = path;
        this.size = size;
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public Long getSize() {
        return size;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        String delimeter = " - ";
        return this.path + delimeter + this.dateFormat.format(this.date) + delimeter + this.size;
    }
}
