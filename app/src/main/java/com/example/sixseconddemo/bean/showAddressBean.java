package com.example.sixseconddemo.bean;

/**
 * 作者：author
 * 时间 ：2017/12/25:10:37
 * 说明：
 */

public class showAddressBean {

    /**
     * id : 1118
     * userId : 279643
     * consignee : 刘恩彤
     * phone : 17744537060
     * addr : bawei
     * zipCode : 10000
     * isDefault : false
     */

    private int id;
    private int userId;
    private String consignee;
    private String phone;
    private String addr;
    private String zipCode;
    private boolean isDefault;
    private String ischecked;

    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked;
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

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
