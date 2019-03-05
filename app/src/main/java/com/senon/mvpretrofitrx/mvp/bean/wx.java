package com.senon.mvpretrofitrx.mvp.bean;

import java.io.Serializable;
import java.util.List;

public class wx {
    /**
     * code : 0
     * msg : null
     * info : {"list":[{"id":"3206279560_2247490517_1","title":"农业银行，新闻已曝光，都看看！","source":"两分钟教你扎头发","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzIwNjI3OTU2MA==&mid=2247490517&idx=1&sn=91934807f69716057a4c1d905a940c66&chksm=97255d32a052d424032de0270a5b66e77268a4a60e9da9016aed6df027248758fbdb761cb9e1"},{"id":"3015723761_2654555214_1","title":"▶又一明星没了,冰冰, 心如痛哭!","source":"全球视觉盛宴","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzAxNTcyMzc2MQ==&mid=2654555214&idx=1&sn=8869b3c11ce62e044e63637895483485&chksm=803251d0b745d8c6775b6e6c9410b0d3964598d86aa107ec8e731675f454dabcb6a396ce8145"},{"id":"3218401223_2247491661_1","title":"9张照片","source":"教女人变洋气","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzIxODQwMTIyMw==&mid=2247491661&idx=1&sn=dd4480cead1e8806681ca9e40b4ade83&chksm=97e9b0e5a09e39f33848149a506f59f9f33cd16a0395d6a1c4067da41cd9e73ebe3532ce3dd4"}],"totalPage":36606,"ps":3,"pno":1}
     */

    private int code;
    private String  msg;
    /**
     * list : [{"id":"3206279560_2247490517_1","title":"农业银行，新闻已曝光，都看看！","source":"两分钟教你扎头发","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzIwNjI3OTU2MA==&mid=2247490517&idx=1&sn=91934807f69716057a4c1d905a940c66&chksm=97255d32a052d424032de0270a5b66e77268a4a60e9da9016aed6df027248758fbdb761cb9e1"},{"id":"3015723761_2654555214_1","title":"▶又一明星没了,冰冰, 心如痛哭!","source":"全球视觉盛宴","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzAxNTcyMzc2MQ==&mid=2654555214&idx=1&sn=8869b3c11ce62e044e63637895483485&chksm=803251d0b745d8c6775b6e6c9410b0d3964598d86aa107ec8e731675f454dabcb6a396ce8145"},{"id":"3218401223_2247491661_1","title":"9张照片","source":"教女人变洋气","firstImg":"","mark":"","url":"https://mp.weixin.qq.com/s?__biz=MzIxODQwMTIyMw==&mid=2247491661&idx=1&sn=dd4480cead1e8806681ca9e40b4ade83&chksm=97e9b0e5a09e39f33848149a506f59f9f33cd16a0395d6a1c4067da41cd9e73ebe3532ce3dd4"}]
     * totalPage : 36606.0
     * ps : 3.0
     * pno : 1.0
     */

    private InfoEntity info;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String  msg) {
        this.msg = msg;
    }

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String  getMsg() {
        return msg;
    }

    public InfoEntity getInfo() {
        return info;
    }

    public static class InfoEntity {
        private double totalPage;
        private double ps;
        private double pno;
        /**
         * id : 3206279560_2247490517_1
         * title : 农业银行，新闻已曝光，都看看！
         * source : 两分钟教你扎头发
         * firstImg :
         * mark :
         * url : https://mp.weixin.qq.com/s?__biz=MzIwNjI3OTU2MA==&mid=2247490517&idx=1&sn=91934807f69716057a4c1d905a940c66&chksm=97255d32a052d424032de0270a5b66e77268a4a60e9da9016aed6df027248758fbdb761cb9e1
         */

        private List<ListEntity> list;

        public void setTotalPage(double totalPage) {
            this.totalPage = totalPage;
        }

        public void setPs(double ps) {
            this.ps = ps;
        }

        public void setPno(double pno) {
            this.pno = pno;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public double getTotalPage() {
            return totalPage;
        }

        public double getPs() {
            return ps;
        }

        public double getPno() {
            return pno;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public static class ListEntity implements Serializable {
            private String id;
            private String title;
            private String source;
            private String firstImg;
            private String mark;
            private String url;

            public void setId(String id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public void setFirstImg(String firstImg) {
                this.firstImg = firstImg;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getSource() {
                return source;
            }

            public String getFirstImg() {
                return firstImg;
            }

            public String getMark() {
                return mark;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}
