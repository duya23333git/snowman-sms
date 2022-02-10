import cn.snowman.sms.ManageApplication;
import cn.snowman.sms.dto.BlackListDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageApplication.class)
public class MysqlTest {

    @Test
    public void isnull() {
        System.out.println(1111);
        BlackListDTO blackListDTO = new BlackListDTO();
        Class<? extends BlackListDTO> aClass = blackListDTO.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            System.out.println(name);
        }
    }

}
