package com.senon.mvpretrofitrx.mvp.entity;

import java.util.List;

public class filemDate {

    private String reason;
    private ResultEntity result;
    private int error_code;
    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public static class ResultEntity {
        private String stat;
        private List<DataEntity> data;

        public void setStat(String stat) {
            this.stat = stat;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public String getStat() {
            return stat;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public static class DataEntity {
            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public String getDate() {
                return date;
            }

            public String getCategory() {
                return category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public String getUrl() {
                return url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }
        }
    }
}
