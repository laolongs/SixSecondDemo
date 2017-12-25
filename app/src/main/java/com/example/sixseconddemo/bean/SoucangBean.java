package com.example.sixseconddemo.bean;

/**
 * Created by one Dream on 2017/12/25.
 */

public class SoucangBean {

    /**
     * wares : {"id":2,"categoryId":6,"campaignId":1,"name":"奥林巴斯（OLYMPUS）E-M10-1442-EZ 微单电电动变焦套机 银色 内置WIFI 翻转触摸屏 EM10复古高雅","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_rBEhWlMFnG0IAAAAAAIqnbSuyAAAAIxLwJ57aQAAiq1705.jpg","price":3799,"sale":3020}
     * id : 758
     * userId : 279643
     * wareId : 2
     * createTime : Dec 23, 2017 11:33:54 AM
     */

    private WaresBean wares;
    private int id;
    private int userId;
    private int wareId;
    private String createTime;

    public WaresBean getWares() {
        return wares;
    }

    public void setWares(WaresBean wares) {
        this.wares = wares;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWareId() {
        return wareId;
    }

    public void setWareId(int wareId) {
        this.wareId = wareId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public static class WaresBean {
        /**
         * id : 2
         * categoryId : 6
         * campaignId : 1
         * name : 奥林巴斯（OLYMPUS）E-M10-1442-EZ 微单电电动变焦套机 银色 内置WIFI 翻转触摸屏 EM10复古高雅
         * imgUrl : http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_rBEhWlMFnG0IAAAAAAIqnbSuyAAAAIxLwJ57aQAAiq1705.jpg
         * price : 3799.0
         * sale : 3020
         */

        private int id;
        private int categoryId;
        private int campaignId;
        private String name;
        private String imgUrl;
        private double price;
        private int sale;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }

        public void setSale(int sale) {
            this.sale = sale;
        }
    }
}
