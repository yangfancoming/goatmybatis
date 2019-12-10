
package cn.goat.mybatis.scripting.defaults;


import cn.goat.mybatis.mapping.SqlSource;
import cn.goat.mybatis.parsing.XNode;
import cn.goat.mybatis.scripting.xmltags.XMLLanguageDriver;
import cn.goat.mybatis.session.Configuration;


public class RawLanguageDriver extends XMLLanguageDriver {

  @Override
  public SqlSource createSqlSource(Configuration configuration, XNode script, Class<?> parameterType) {
    SqlSource source = super.createSqlSource(configuration, script, parameterType);
    checkIsNotDynamic(source);
    return source;
  }

  @Override
  public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
    SqlSource source = super.createSqlSource(configuration, script, parameterType);
    checkIsNotDynamic(source);
    return source;
  }

  private void checkIsNotDynamic(SqlSource source) {

  }

}
