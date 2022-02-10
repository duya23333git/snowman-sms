package cn.snowman.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.snowman.sms.entity.BlackListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 黑名单
 */
@Repository
public interface BlackListMapper extends BaseMapper<BlackListEntity> {

}
