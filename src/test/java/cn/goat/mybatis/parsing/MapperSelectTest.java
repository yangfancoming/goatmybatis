package cn.goat.mybatis.parsing;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:39
 */
public class MapperSelectTest extends BaseTest {



    @Test
    public void getChildren() throws Exception{
        XNode node = common("mybatis-config.xml", "/configuration/mappers");
        List<XNode> children = node.getChildren();
        for(XNode child:children){
            String resource = child.getStringAttribute("resource");
            Assert.assertEquals("mapperSelect.xml", resource);
            XNode mapper = common(resource, "/mapper");
            Assert.assertEquals("com.goat.test.namespace", mapper.getStringAttribute("namespace"));
            List<XNode> xNodes = xPathParser.evalNodes(mapper.node, "select|insert|update|delete");
            for(XNode xNode:xNodes){
                System.out.println(xNode);
            }
        }

    }


}
