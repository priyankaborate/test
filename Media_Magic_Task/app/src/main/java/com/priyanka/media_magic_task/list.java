package com.priyanka.media_magic_task;


public class list
        {
private String filename;

private String author_url;

private String post_url;

private String author;

private String format;

private String width;

private String id;

private String height;

public String getFilename ()
        {
        return filename;
        }

public void setFilename (String filename)
        {
        this.filename = filename;
        }

public String getAuthor_url ()
        {
        return author_url;
        }

public void setAuthor_url (String author_url)
        {
        this.author_url = author_url;
        }

public String getPost_url ()
        {
        return post_url;
        }

public void setPost_url (String post_url)
        {
        this.post_url = post_url;
        }

public String getAuthor ()
        {
        return author;
        }

public void setAuthor (String author)
        {
        this.author = author;
        }

public String getFormat ()
        {
        return format;
        }

public void setFormat (String format)
        {
        this.format = format;
        }

public String getWidth ()
        {
        return width;
        }

public void setWidth (String width)
        {
        this.width = width;
        }

public String getId ()
        {
        return id;
        }

public void setId (String id)
        {
        this.id = id;
        }

public String getHeight ()
        {
        return height;
        }

public void setHeight (String height)
        {
        this.height = height;
        }

@Override
public String toString()
        {
        return "ClassPojo [filename = "+filename+", author_url = "+author_url+", post_url = "+post_url+", author = "+author+", format = "+format+", width = "+width+", id = "+id+", height = "+height+"]";
        }
        }
