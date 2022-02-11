package cn.snowman.sms.controller;

import cn.snowman.sms.dto.BlackListDTO;
import cn.snowman.sms.entity.BlackListEntity;
import cn.snowman.sms.service.BlackListService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snowman.sms.entity.Result;
import com.snowman.sms.entity.StatusCode;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("blacklist")
@Api(tags = "黑名单")
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    /**
     * 分页查询
     * @param blackListDTO
     * @param current
     * @param size
     * @return
     */
    @GetMapping("page")
    public Result<Page<BlackListEntity>> page(BlackListDTO blackListDTO, int current, int size) {

        Page<BlackListEntity> page = new Page<>(current, size);

        if (blackListDTO.getContent() == null) {
            blackListDTO.setContent("");
        }

        if (blackListDTO.getType() == null) {
            blackListDTO.setType("");
        }

        LambdaQueryWrapper<BlackListEntity> wrapper = new QueryWrapper<BlackListEntity>().lambda();
        wrapper.like(BlackListEntity::getContent, blackListDTO.getContent())
                .like(BlackListEntity::getType, blackListDTO.getType())
                .orderByDesc(BlackListEntity::getCreateTime);

        blackListService.page(page, wrapper);

        return new Result<>(true, StatusCode.OK, "ok", page);
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("upload")
    public Result<? extends Object> upload(@RequestParam(value = "file") MultipartFile file) {

        if (file.isEmpty()) {
            return new Result<>(false, StatusCode.ERROR, "error");
        }

        Boolean flag = blackListService.upload(file);

        return new Result<>(flag, StatusCode.OK, "ok");
    }


    /**
     * 删除
     * @param map
     * @return
     */
    @DeleteMapping()
    public Result<BlackListEntity> delete(@RequestParam Map<String, String> map) {

        List<String> arrayList = new ArrayList<>();

        arrayList.addAll(map.values());

        blackListService.removeBatchByIds(arrayList);

        return new Result<>(true, StatusCode.OK, "ok");
    }

}
