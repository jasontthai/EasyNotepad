/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.beans;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * @author trit
 *
 */
public class Notepad {
    @Id
    private String id;
    private String title;
    private String description;
    private List<Note> notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Notepad [id=").append(id).append(", title=").append(title).append(", description=")
                .append(description).append(", notes=").append(notes).append("]");
        return builder.toString();
    }
}
