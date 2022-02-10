package cn.snowman.sms.entity;

import cn.snowman.sms.entity.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 黑名单
 * @author kangz
 */
@TableName("black_list")
public class BlackListEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String type;
    private String content;
    private String remark;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
