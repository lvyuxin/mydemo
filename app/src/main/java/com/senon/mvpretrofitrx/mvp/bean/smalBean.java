package com.senon.mvpretrofitrx.mvp.bean;

import java.io.Serializable;

public class smalBean implements Serializable {

    private int viewCount;
    private int publishDate;
    private String content;
    private String id;
    private String publishDateStr;
    private int commentCount;
    private String url;
    private String posterScreenName;

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPosterScreenName(String posterScreenName) {
        this.posterScreenName = posterScreenName;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getUrl() {
        return url;
    }

    public String getPosterScreenName() {
        return posterScreenName;
    }
}
