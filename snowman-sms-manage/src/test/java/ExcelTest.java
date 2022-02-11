import cn.snowman.sms.ManageApplication;
import cn.snowman.sms.Pojo.BlackListPojo;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class ExcelTest {

    @Test
    public void excel() {

//        MultipartFile multipartFile = new MultipartFile("E:\\导入黑名单模板.xlsx");
        File file = new File("E:\\导入黑名单模板.xlsx");

        System.out.println(file.length());

        HashMap<String, String> hashMap = new HashMap();
        EasyExcel.read(file, BlackListPojo.class, new PageReadListener<BlackListPojo>(dataList->{
            for (BlackListPojo blackListExcel : dataList) {
//                System.out.println(blackListExcel.getPhone());
                hashMap.put(blackListExcel.getPhone(), blackListExcel.getRemark());
//                System.out.println(JSON.toJSONString(blackListExcel));
            }
        })).sheet().doRead();

        for (String s : hashMap.keySet()) {
            System.out.println(s);
        }

    }

}
