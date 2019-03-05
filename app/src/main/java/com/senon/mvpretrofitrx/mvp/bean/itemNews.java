package com.senon.mvpretrofitrx.mvp.bean;

import java.util.List;

public class itemNews {

    private String content;
    private String posterId;
    private Object tags;
    private String id;
    private int commentCount;
    private String posterScreenName;
    private String publishDateStr;
    private int viewCount;
    private int likeCount;
    private Object shareCount;
    private String html;
    private int dislikeCount;
    private String coverUrl;
    private String title;
    private String url;
    private int publishDate;
    private List<String> imageUrls;

    @Override
    public String toString() {
        return "A{" +
                "content='" + content + '\'' +
                ", posterId='" + posterId + '\'' +
                ", tags=" + tags +
                ", id='" + id + '\'' +
                ", commentCount=" + commentCount +
                ", posterScreenName='" + posterScreenName + '\'' +
                ", publishDateStr='" + publishDateStr + '\'' +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", shareCount=" + shareCount +
                ", html='" + html + '\'' +
                ", dislikeCount=" + dislikeCount +
                ", coverUrl='" + coverUrl + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", publishDate=" + publishDate +
                ", imageUrls=" + imageUrls +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setPosterScreenName(String posterScreenName) {
        this.posterScreenName = posterScreenName;
    }

    public void setPublishDateStr(String publishDateStr) {
        this.publishDateStr = publishDateStr;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setShareCount(Object shareCount) {
        this.shareCount = shareCount;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getContent() {
        return content;
    }

    public String getPosterId() {
        return posterId;
    }

    public Object getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getPosterScreenName() {
        return posterScreenName;
    }

    public String getPublishDateStr() {
        return publishDateStr;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public Object getShareCount() {
        return shareCount;
    }

    public String getHtml() {
        return html;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }
}
