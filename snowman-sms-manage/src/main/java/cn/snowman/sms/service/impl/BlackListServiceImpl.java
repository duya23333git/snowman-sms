package cn.snowman.sms.service.impl;

import cn.snowman.sms.annotation.DefaultParams;
import cn.snowman.sms.entity.BlackListEntity;
import cn.snowman.sms.Pojo.BlackListPojo;
import cn.snowman.sms.mapper.BlackListMapper;
import cn.snowman.sms.service.BlackListService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 黑名单实现类
 * @author kangz
 */
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackListEntity> implements BlackListService {

    @Autowired
    private BlackListService blackListService;

    @DefaultParams
    @Override
    public Boolean upload(MultipartFile file) {

        // 解析excel数据
        HashMap<String, String> hashMap = new HashMap<>();
        List<BlackListEntity> blackList = new ArrayList<>();

        File tempFile = multipartFileToFile(file);

        EasyExcel.read(tempFile, BlackListPojo.class, new PageReadListener<BlackListPojo>(dataList->{
            for (BlackListPojo blackListExcel : dataList) {
                if (blackListExcel.getPhone().length() == 11) {
                    hashMap.put(blackListExcel.getPhone(), blackListExcel.getRemark());
                }
            }
        })).sheet().doRead();

        tempFile.delete();

        if (!hashMap.isEmpty()) {
            Set<String> key = hashMap.keySet();
            for (String s : key) {
                BlackListEntity blackListEntity = new BlackListEntity();
                blackListEntity.setId(UUID.randomUUID().toString());
                blackListEntity.setType("1");
                blackListEntity.setContent(s);
                blackListEntity.setRemark(hashMap.get(s));
                blackListEntity.setCreateUser("1");
                blackListEntity.setUpdateUser("1");
                blackList.add(blackListEntity);
            }
        }

        // 插入数据库
        return blackListService.saveBatch(blackList);
    }

    private File multipartFileToFile(MultipartFile file) {

        File tempFile = null;

        try {
            String originalFilename = file.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            tempFile = File.createTempFile(filename[0], filename[1]);
            file.transferTo(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempFile;
    }
}
