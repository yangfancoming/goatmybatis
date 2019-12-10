
package cn.goat.mybatis.mapping;




/**
 * An actual SQL String got from an {@link SqlSource} after having processed any dynamic content.
 * The SQL may have SQL placeholders "?" and an list (ordered) of an parameter mappings
 * with the additional information for each parameter (at least the property name of the input object to read the value from).
 * Can also have additional parameters that are created by the dynamic language (for loops, bind...).
 *  其中包含sql语句(该sql语句中可能包含 ? 这样的占位符), 以及一组parameter mapping(ParameterMapping类的实例), 注意这组parameter mapping是Mybatis内部生成的(通过读取#{xx}中的内容)
 *  再强调一次,以上的ParameterMapping实例是在ParameterHandler接口的唯一默认实现类 DefaultParameterHandler 中被消费的.
 */
public class BoundSql {


}
