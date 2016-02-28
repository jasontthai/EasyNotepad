package hello;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by trit on 2/27/16.
 */
public class Hello {

    @Id
    private String id;

    private String text;

    public Hello() {
    }

    public Hello(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hello{");
        sb.append("id='").append(id).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
