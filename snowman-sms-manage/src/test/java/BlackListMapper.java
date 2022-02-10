import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 黑名单
 */
@Mapper
public interface BlackListMapper extends BaseMapper<BlackListEntity> {

}
