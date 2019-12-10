package cn.goat.mybatis.parsing;

import cn.goat.mybatis.io.Resources;
import cn.goat.mybatis.type.TypeAliasRegistry;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:39
 */
public class XNodeTypeAliasTest extends BaseTest {

    TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    @Test
    public void registerAlias() throws Exception{
        XNode node = common("typeAlias1.xml", "/configuration/typeAliases");
        List<XNode> children = node.getChildren();
        System.out.println(children);

        XNode xNode = children.get(0);
        String alias = xNode.getStringAttribute("alias");
        String type = xNode.getStringAttribute("type");
        System.out.println(alias + type);
        Class<?> clazz = Resources.classForName(type);
        System.out.println(clazz);
        typeAliasRegistry.registerAlias(alias, clazz);
    }

    @Test
    public void getChildrenAsProperties() throws Exception{
        XNode node = common("typeAlias1.xml", "/configuration/typeAliases");
        Properties properties = node.getChildrenAsProperties("type", "alias");
        System.out.println(properties);
    }


}
