package com.example.sixseconddemo.bean;

/**
 * Created by 郭金龙 on 2017/12/29.
 */

public class OrderBean {

    /**
     * data : {"orderNum":"20171229112725000100","charge":{"id":"ch_uTuHq1evXTOOSKqTG810OCKO","object":"charge","created":1514518045,"livemode":false,"paid":false,"refunded":false,"app":"app_0yvTSGSOOSO44u18","channel":"alipay","orderNo":"20171229112725000100","clientIp":"114.249.227.26","amount":11716,"amountSettle":11716,"currency":"cny","subject":"您正在菜鸟商城购物","body":"订单Body","timeExpire":1514604445,"refunds":{"object":"list","url":"/v1/charges/ch_uTuHq1evXTOOSKqTG810OCKO/refunds","hasMore":false,"data":[]},"amountRefunded":0,"metadata":{},"credential":{"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"订单Body\"&it_b_pay=\"2017-12-30 11:27:25\"&notify_url=\"https%3A%2F%2Fnotify.pingxx.com%2Fnotify%2Fcharges%2Fch_uTuHq1evXTOOSKqTG810OCKO\"&out_trade_no=\"20171229112725000100\"&partner=\"2008149994271647\"&payment_type=\"1\"&seller_id=\"2008149994271647\"&service=\"mobile.securitypay.pay\"&subject=\"您正在菜鸟商城购物\"&total_fee=\"117.16\"&sign=\"QzBDUzhTNGlydlBDU2E5U09PZnYxNE9L\"&sign_type=\"RSA\""}},"extra":{}}}
     * status : 1
     * message : success
     */

    private DataBean data;
    private int status;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * orderNum : 20171229112725000100
         * charge : {"id":"ch_uTuHq1evXTOOSKqTG810OCKO","object":"charge","created":1514518045,"livemode":false,"paid":false,"refunded":false,"app":"app_0yvTSGSOOSO44u18","channel":"alipay","orderNo":"20171229112725000100","clientIp":"114.249.227.26","amount":11716,"amountSettle":11716,"currency":"cny","subject":"您正在菜鸟商城购物","body":"订单Body","timeExpire":1514604445,"refunds":{"object":"list","url":"/v1/charges/ch_uTuHq1evXTOOSKqTG810OCKO/refunds","hasMore":false,"data":[]},"amountRefunded":0,"metadata":{},"credential":{"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"订单Body\"&it_b_pay=\"2017-12-30 11:27:25\"&notify_url=\"https%3A%2F%2Fnotify.pingxx.com%2Fnotify%2Fcharges%2Fch_uTuHq1evXTOOSKqTG810OCKO\"&out_trade_no=\"20171229112725000100\"&partner=\"2008149994271647\"&payment_type=\"1\"&seller_id=\"2008149994271647\"&service=\"mobile.securitypay.pay\"&subject=\"您正在菜鸟商城购物\"&total_fee=\"117.16\"&sign=\"QzBDUzhTNGlydlBDU2E5U09PZnYxNE9L\"&sign_type=\"RSA\""}},"extra":{}}
         */

        private String orderNum;
        private ChargeBean charge;

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public ChargeBean getCharge() {
            return charge;
        }

        public void setCharge(ChargeBean charge) {
            this.charge = charge;
        }

        public static class ChargeBean {
            /**
             * id : ch_uTuHq1evXTOOSKqTG810OCKO
             * object : charge
             * created : 1514518045
             * livemode : false
             * paid : false
             * refunded : false
             * app : app_0yvTSGSOOSO44u18
             * channel : alipay
             * orderNo : 20171229112725000100
             * clientIp : 114.249.227.26
             * amount : 11716
             * amountSettle : 11716
             * currency : cny
             * subject : 您正在菜鸟商城购物
             * body : 订单Body
             * timeExpire : 1514604445
             * refunds : {"object":"list","url":"/v1/charges/ch_uTuHq1evXTOOSKqTG810OCKO/refunds","hasMore":false,"data":[]}
             * amountRefunded : 0
             * metadata : {}
             * credential : {"object":"credential","alipay":{"orderInfo":"_input_charset=\"utf-8\"&body=\"订单Body\"&it_b_pay=\"2017-12-30 11:27:25\"&notify_url=\"https%3A%2F%2Fnotify.pingxx.com%2Fnotify%2Fcharges%2Fch_uTuHq1evXTOOSKqTG810OCKO\"&out_trade_no=\"20171229112725000100\"&partner=\"2008149994271647\"&payment_type=\"1\"&seller_id=\"2008149994271647\"&service=\"mobile.securitypay.pay\"&subject=\"您正在菜鸟商城购物\"&total_fee=\"117.16\"&sign=\"QzBDUzhTNGlydlBDU2E5U09PZnYxNE9L\"&sign_type=\"RSA\""}}
             * extra : {}
             */

            private String id;
            private String object;
            private int created;
            private boolean livemode;
            private boolean paid;
            private boolean refunded;
            private String app;
            private String channel;
            private String orderNo;
            private String clientIp;
            private int amount;
            private int amountSettle;
            private String currency;
            private String subject;
            private String body;
            private int timeExpire;
            private RefundsBean refunds;
            private int amountRefunded;
            private MetadataBean metadata;
            private CredentialBean credential;
            private ExtraBean extra;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getObject() {
                return object;
            }

            public void setObject(String object) {
                this.object = object;
            }

            public int getCreated() {
                return created;
            }

            public void setCreated(int created) {
                this.created = created;
            }

            public boolean isLivemode() {
                return livemode;
            }

            public void setLivemode(boolean livemode) {
                this.livemode = livemode;
            }

            public boolean isPaid() {
                return paid;
            }

            public void setPaid(boolean paid) {
                this.paid = paid;
            }

            public boolean isRefunded() {
                return refunded;
            }

            public void setRefunded(boolean refunded) {
                this.refunded = refunded;
            }

            public String getApp() {
                return app;
            }

            public void setApp(String app) {
                this.app = app;
            }

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getClientIp() {
                return clientIp;
            }

            public void setClientIp(String clientIp) {
                this.clientIp = clientIp;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public int getAmountSettle() {
                return amountSettle;
            }

            public void setAmountSettle(int amountSettle) {
                this.amountSettle = amountSettle;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getTimeExpire() {
                return timeExpire;
            }

            public void setTimeExpire(int timeExpire) {
                this.timeExpire = timeExpire;
            }

            public RefundsBean getRefunds() {
                return refunds;
            }

            public void setRefunds(RefundsBean refunds) {
                this.refunds = refunds;
            }

            public int getAmountRefunded() {
                return amountRefunded;
            }

            public void setAmountRefunded(int amountRefunded) {
                this.amountRefunded = amountRefunded;
            }

            public MetadataBean getMetadata() {
                return metadata;
            }

            public void setMetadata(MetadataBean metadata) {
                this.metadata = metadata;
            }

            public CredentialBean getCredential() {
                return credential;
            }

            public void setCredential(CredentialBean credential) {
                this.credential = credential;
            }

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public static class RefundsBean {
            }

            public static class MetadataBean {
            }

            public static class CredentialBean {
                public static class AlipayBean {
                }
            }

            public static class ExtraBean {
            }
        }
    }
}
