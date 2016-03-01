/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.beans;

import org.springframework.data.annotation.Id;

/**
 * @author trit
 *
 */
public class Note {

    @Id
    String id;
    String notepadId;
    String headline;
    String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotepadId() {
        return notepadId;
    }

    public void setNotepadId(String notepadId) {
        this.notepadId = notepadId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Note [id=").append(id).append(", notepadId=").append(notepadId).append(", headline=")
                .append(headline).append(", content=").append(content).append("]");
        return builder.toString();
    }
}
