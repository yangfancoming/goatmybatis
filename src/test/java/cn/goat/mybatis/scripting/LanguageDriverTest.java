package cn.goat.mybatis.scripting;

import cn.goat.mybatis.session.Configuration;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/10---11:39
 */
public class LanguageDriverTest {

    Configuration configuration = new Configuration();

    @Test
    public void test(){
        LanguageDriver languageDriver = configuration.getLanguageDriver(null);
        System.out.println(languageDriver);
    }
}
