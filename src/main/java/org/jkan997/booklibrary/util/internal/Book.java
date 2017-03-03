package org.jkan997.booklibrary.util.internal;

import java.util.Calendar;
import java.util.Date;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.io.JSONWriter;
import org.jkan997.booklibrary.util.ISO8601;

/**
 *
 * @author jakaniew
 */
public class Book {

    private String title;
    private String author;
    private String genre;
    private String path;

    public Book(Node n) throws RepositoryException {
        this.fromNode(n);
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

  

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public final void fromNode(Node n) throws RepositoryException {
        title = n.getProperty("title").getString();
        author = n.getProperty("author").getString();
        if (n.hasProperty("reserved")) {
          //  reserved = n.getProperty("reserved").getDate();
        }
        genre = n.getParent().getName();
        path = n.getPath();
    }

    public static int C = 0;

    public void toJSON(JSONWriter json) throws JSONException {
        json.object();
        json.key("title").value(this.getTitle());
        json.key("author").value(this.getAuthor());
        json.key("genre").value(this.getGenre());
        C++;
        if (C % 2 == 0) {
            json.key("reserved").value(ISO8601.format(Calendar.getInstance()));
        }
        json.key("path").value(this.getPath());
        json.endObject();
    }
}
