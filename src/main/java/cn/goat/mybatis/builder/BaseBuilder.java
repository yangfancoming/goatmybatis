
package cn.goat.mybatis.builder;

import javax.security.auth.login.Configuration;

/**
 * BaseBuilder 并没有对子类进行任何’约束’, 只是重复性代码的容器
 * 这个父类维护了一个全局的Configuration对象，MyBatis的配置文件解析后就以Configuration对象的形式存储。
 * MapperBuilderAssistant
 * ParameterMappingTokenHandler
 * SqlSourceBuilder
 * XMLConfigBuilder ： 解析mybatis中configLocation属性中的全局xml文件，内部会使用XMLMapperBuilder解析各个xml文件。
 * XMLMapperBuilder ： 遍历mybatis中mapperLocations属性中的xml文件中每个节点的Builder，比如user.xml，内部会使用XMLStatementBuilder处理xml中的每个节点。
 * XMLScriptBuilder ： 解析xml中各个节点sql部分的Builder。
 * XMLStatementBuilder ： 解析xml文件中各个节点，比如select,insert,update,delete节点，内部会使用XMLScriptBuilder处理节点的sql部分，遍历产生的数据会丢到Configuration的mappedStatements中。
*/
public abstract class BaseBuilder {
  //Mybatis初始化过程的核心对象，Mybatis中几乎全部的配置信息会保存到该对象中。该对象在Mybatis初始化过程中创建且是全局唯一的
  protected final Configuration configuration;


  public BaseBuilder(Configuration configuration) {
    this.configuration = configuration;

  }

  public Configuration getConfiguration() {
    return configuration;
  }

}
