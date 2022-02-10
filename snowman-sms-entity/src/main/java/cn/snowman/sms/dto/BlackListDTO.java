package cn.snowman.sms.dto;

import cn.snowman.sms.entity.BlackListEntity;
import io.swagger.annotations.ApiModel;

/**
 * 视图层
 * @author kangz
 */
@ApiModel(description = "黑名单")
public class BlackListDTO extends BlackListEntity {

    @Override
    public String toString() {
        return "BlackListDTO{}";
    }

}
