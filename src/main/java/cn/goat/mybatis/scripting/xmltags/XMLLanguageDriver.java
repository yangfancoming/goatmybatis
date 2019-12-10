
package cn.goat.mybatis.scripting.xmltags;


import cn.goat.mybatis.mapping.SqlSource;
import cn.goat.mybatis.parsing.XNode;
import cn.goat.mybatis.scripting.LanguageDriver;
import cn.goat.mybatis.session.Configuration;

/**
 Mybatis默认XML驱动类为XMLLanguageDriver，其主要作用于解析select|update|insert|delete节点为完整的SQL语句。
 该类就是为解析xml而生的
*/
public class XMLLanguageDriver implements LanguageDriver {



  @Override
  public SqlSource createSqlSource(Configuration configuration, XNode script, Class<?> parameterType) {
      return null;
  }

  @Override
  public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
      return null;
  }

}
