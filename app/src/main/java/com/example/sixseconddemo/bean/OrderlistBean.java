package com.example.sixseconddemo.bean;

import java.util.List;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class OrderlistBean {

    /**
     * items : [{"wares":{"id":2,"categoryId":6,"campaignId":1,"name":"奥林巴斯（OLYMPUS）E-M10-1442-EZ 微单电电动变焦套机 银色 内置WIFI 翻转触摸屏 EM10复古高雅","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_rBEhWlMFnG0IAAAAAAIqnbSuyAAAAIxLwJ57aQAAiq1705.jpg","price":3799,"sale":3020},"id":8103,"orderId":3971,"ware_id":2},{"wares":{"id":1,"categoryId":5,"campaignId":1,"name":"联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55c1e8f7N4b99de71.jpg","price":5979,"sale":8654},"id":8104,"orderId":3971,"ware_id":1},{"wares":{"id":3,"categoryId":6,"campaignId":3,"name":"Apple iPad mini 2 ME276CH/A （配备 Retina 显示屏 7.9英寸 16G WLAN 机型 深空灰色）","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_548574edNc366ff4a.jpg","price":1938,"sale":9138},"id":8105,"orderId":3971,"ware_id":3}]
     * id : 3971
     * userId : 279643
     * orderNum : 20171229112725000100
     * createdTime : Dec 29, 2017 11:27:25 AM
     * amount : 11716.0
     * status : 0
     */

    private int id;
    private int userId;
    private String orderNum;
    private String createdTime;
    private double amount;
    private int status;
    private List<ItemsBean> items;

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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * wares : {"id":2,"categoryId":6,"campaignId":1,"name":"奥林巴斯（OLYMPUS）E-M10-1442-EZ 微单电电动变焦套机 银色 内置WIFI 翻转触摸屏 EM10复古高雅","imgUrl":"http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_rBEhWlMFnG0IAAAAAAIqnbSuyAAAAIxLwJ57aQAAiq1705.jpg","price":3799,"sale":3020}
         * id : 8103
         * orderId : 3971
         * ware_id : 2
         */

        private WaresBean wares;
        private int id;
        private int orderId;
        private int ware_id;

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

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getWare_id() {
            return ware_id;
        }

        public void setWare_id(int ware_id) {
            this.ware_id = ware_id;
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
}
