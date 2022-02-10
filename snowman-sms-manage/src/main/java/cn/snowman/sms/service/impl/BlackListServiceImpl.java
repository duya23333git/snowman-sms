package cn.snowman.sms.service.impl;

import cn.snowman.sms.entity.BlackListEntity;
import cn.snowman.sms.mapper.BlackListMapper;
import cn.snowman.sms.service.BlackListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.snowman.sms.entity.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 黑名单实现类
 * @author kangz
 */
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackListEntity> implements BlackListService {

    @Override
    public Result<Boolean> upload(MultipartFile file) {
        return null;
    }
}
