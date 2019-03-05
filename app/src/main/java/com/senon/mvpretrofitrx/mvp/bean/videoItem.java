package com.senon.mvpretrofitrx.mvp.bean;

public class videoItem {
    private String url;
    private int publishDate;
    private String description;
    private Object content;
    private Object shareCount;
    private String id;
    private String viewCount;
    private String publishDateStr;
    private String title;
    private int commentCount;
    private String posterScreenName;
    private String coverUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getShareCount() {
        return shareCount;
    }

    public void setShareCount(Object shareCount) {
        this.shareCount = shareCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getPosterScreenName() {
        return posterScreenName;
    }

    public void setPosterScreenName(String posterScreenName) {
        this.posterScreenName = posterScreenName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return "videoItem{" +
                "url='" + url + '\'' +
                ", publishDate=" + publishDate +
                ", description='" + description + '\'' +
                ", content=" + content +
                ", shareCount=" + shareCount +
                ", id='" + id + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", publishDateStr='" + publishDateStr + '\'' +
                ", title='" + title + '\'' +
                ", commentCount=" + commentCount +
                ", posterScreenName='" + posterScreenName + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
