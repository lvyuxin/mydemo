package com.senon.mvpretrofitrx.mvp.entity;

import java.util.List;

public class learnDate {


    private DataEntity data;


    private int errorCode;
    private String errorMsg;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DataEntity getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static class DataEntity {
        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;


        private List<DatasEntity> datas;

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public void setDatas(List<DatasEntity> datas) {
            this.datas = datas;
        }

        public int getCurPage() {
            return curPage;
        }

        public int getOffset() {
            return offset;
        }

        public boolean isOver() {
            return over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public int getSize() {
            return size;
        }

        public int getTotal() {
            return total;
        }

        public List<DatasEntity> getDatas() {
            return datas;
        }

        public static class DatasEntity {
            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            /**
             * name : 项目
             * url : /project/list/1?cid=323
             */

            private List<TagsEntity> tags;

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public void setTags(List<TagsEntity> tags) {
                this.tags = tags;
            }

            public String getApkLink() {
                return apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public String getDesc() {
                return desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public int getId() {
                return id;
            }

            public String getLink() {
                return link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public int getType() {
                return type;
            }

            public int getUserId() {
                return userId;
            }

            public int getVisible() {
                return visible;
            }

            public int getZan() {
                return zan;
            }

            public List<TagsEntity> getTags() {
                return tags;
            }

            public static class TagsEntity {
                private String name;
                private String url;

                public void setName(String name) {
                    this.name = name;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getName() {
                    return name;
                }

                public String getUrl() {
                    return url;
                }
            }
        }
    }
}
