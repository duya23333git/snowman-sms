package cn.snowman.sms.Pojo;


import java.io.Serializable;

/**
 * 黑名单Excel
 * @author kangz
 */
public class BlackListPojo implements Serializable {

    private String phone;

    private String remark;

    public BlackListPojo() {
    }

    public BlackListPojo(String phone, String remark) {
        this.phone = phone;
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
