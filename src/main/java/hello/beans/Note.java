/*
 * Copyright (c) 2012-2013 Yahoo! Inc. All rights reserved.
 */
package hello.beans;

/**
 * @author trit
 *
 */
public class Note {
    String id;
    String headline;
    String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        builder.append("Note [id=").append(id).append(", headline=").append(headline).append(", content=")
                .append(content).append("]");
        return builder.toString();
    }
}
