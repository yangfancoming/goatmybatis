package cn.goat.mybatis.io;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 *
 * @ date 2019/12/4---20:45
 */
public class ResourcesTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void getResourceAsReader() throws IOException {
        String xmlPath = "mybatis-config.xml";
        try (Reader reader = Resources.getResourceAsReader(xmlPath)) {
            Assert.assertNotNull(reader);
        }
    }

    @Test
    public void getResourceAsStream() throws IOException {
        String xmlPath = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(xmlPath)) {
            Assert.assertNotNull(inputStream);
        }
    }

    @Test
    public void getResourceAsProperties() throws IOException {
        Properties properties = Resources.getResourceAsProperties("dbconfig.properties");
        log.info("Resources.getResourceAsProperties {}" ,properties);
    }

    @Test
    public void classForName() throws Exception {
        Class<?> clazz = Resources.classForName("cn.goatool.core.reflect.Student");
        log.info("Resources.classForName getSimpleName {}" ,clazz.getSimpleName());
        log.info("Resources.classForName {}" ,clazz);
    }


}
