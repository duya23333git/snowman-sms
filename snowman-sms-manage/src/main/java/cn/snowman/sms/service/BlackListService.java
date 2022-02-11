package cn.snowman.sms.service;


import cn.snowman.sms.entity.BlackListEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.snowman.sms.entity.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * 黑名单
 * @author kangz
 */
public interface BlackListService extends IService<BlackListEntity> {

    Boolean upload(MultipartFile file);

}
