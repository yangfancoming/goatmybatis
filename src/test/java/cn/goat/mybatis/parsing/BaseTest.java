package cn.goat.mybatis.parsing;


import cn.goat.mybatis.io.Resources;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/6---14:51
 */
public abstract class BaseTest {

    XPathParser xPathParser;

    public XNode common(String path,String expression) throws Exception{
        try (InputStream inputStream = Resources.getResourceAsStream(path)) {
            xPathParser = new XPathParser(inputStream);
            XNode node = xPathParser.evalNode(expression);
            return node;
        }
    }
}
