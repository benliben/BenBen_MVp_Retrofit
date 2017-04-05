package com.android.benben.retrofitlibrary.model;

import java.util.List;

/**
 * Time      2017/2/28 10:39 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class MoveModel {
    /**
     * title : 刺客联盟
     * tag : 动作
     * act : 安吉丽娜·朱莉 詹姆斯·麦卡沃伊 摩根·弗里曼 托马斯·克兰特曼恩 特伦斯·斯坦姆普
     * year : 2008
     * rating : 7.4
     * area : 美国
     * dir : 提莫·贝克曼贝托夫
     * desc : 为了改变窘迫的生活现状,为了替父报仇,韦斯利毅然踏上了先人之路.
     * cover : http://p3.qhimg.com/d/dy_384c5ea18b9b1543210c16081136df59.jpg
     * vdo_status : none
     * playlinks : {"levp":"","qiyi":"","qq":""}
     * video_rec : [{"cover":"http://p7.qhimg.com/t014b2b70e36c288df3.jpg","detail_url":"http://www.360kan.com/m/hKPmaEX7RXj5SR.html","title":"通缉令2009"},{"cover":"http://p3.qhimg.com/t01e9159cf1f537158a.jpg","detail_url":"http://www.360kan.com/m/gKrmYhH3QHn3Sx.html","title":"通缉令2"},{"cover":"http://p4.qhimg.com/t01bae7d63ee701ce19.jpg","detail_url":"http://www.360kan.com/m/gafraEL5Qnb1UB.html","title":"古墓丽影2"},{"cover":"http://p8.qhimg.com/d/dy_89bb4e9f9f602d4a43f993a9ee5ac03c.jpg","detail_url":"http://www.360kan.com/m/gqXrYUL2QnT3Sx.html","title":"洛城疑云"},{"cover":"http://p1.qhimg.com/t01720354fbbad74dad.jpg","detail_url":"http://www.360kan.com/m/faLjZUP6QHr5Sx.html","title":"特工绍特"}]
     * act_s : [{"name":"安吉丽娜·朱莉","url":"http://baike.so.com/doc/2029869-2147862.html","image":"http://p8.qhmsg.com/dmsmty/120_110_100/t013702b129eee70d1c.jpg"},{"name":"詹姆斯·麦卡沃伊","url":"http://baike.so.com/doc/5417707-5655855.html","image":"http://p7.qhmsg.com/dmsmty/120_110_100/t014b0a38dff5003908.jpg"},{"name":"摩根·弗里曼","url":"http://baike.so.com/doc/2334230-2468775.html","image":"http://p1.qhmsg.com/dmsmty/120_110_100/t01bcbac8e323e388f0.jpg"}]
     */

    private String title;
    private String tag;
    private String act;
    private String year;
    private double rating;
    private String area;
    private String dir;
    private String desc;
    private String cover;
    private String vdo_status;
    /**
     * levp :
     * qiyi :
     * qq :
     */

    private PlaylinksBean playlinks;
    /**
     * cover : http://p7.qhimg.com/t014b2b70e36c288df3.jpg
     * detail_url : http://www.360kan.com/m/hKPmaEX7RXj5SR.html
     * title : 通缉令2009
     */

    private List<VideoRecBean> video_rec;
    /**
     * name : 安吉丽娜·朱莉
     * url : http://baike.so.com/doc/2029869-2147862.html
     * image : http://p8.qhmsg.com/dmsmty/120_110_100/t013702b129eee70d1c.jpg
     */

    private List<ActSBean> act_s;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVdo_status() {
        return vdo_status;
    }

    public void setVdo_status(String vdo_status) {
        this.vdo_status = vdo_status;
    }

    public PlaylinksBean getPlaylinks() {
        return playlinks;
    }

    public void setPlaylinks(PlaylinksBean playlinks) {
        this.playlinks = playlinks;
    }

    public List<VideoRecBean> getVideo_rec() {
        return video_rec;
    }

    public void setVideo_rec(List<VideoRecBean> video_rec) {
        this.video_rec = video_rec;
    }

    public List<ActSBean> getAct_s() {
        return act_s;
    }

    public void setAct_s(List<ActSBean> act_s) {
        this.act_s = act_s;
    }

    public static class PlaylinksBean {
        private String levp;
        private String qiyi;
        private String qq;

        public String getLevp() {
            return levp;
        }

        public void setLevp(String levp) {
            this.levp = levp;
        }

        public String getQiyi() {
            return qiyi;
        }

        public void setQiyi(String qiyi) {
            this.qiyi = qiyi;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }
    }

    public static class VideoRecBean {
        private String cover;
        private String detail_url;
        private String title;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ActSBean {
        private String name;
        private String url;
        private String image;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
