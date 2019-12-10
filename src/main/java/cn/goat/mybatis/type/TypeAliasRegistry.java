
package cn.goat.mybatis.type;



import cn.goat.mybatis.exception.TypeException;
import cn.goat.mybatis.io.Resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.*;

/**
 TypeAliasRegistry（类型别名注册器）
 在类型别名注册器类TypeAliasRegistry的无参构造器中进行了大量的基础类型别名的注册（设置），涉及到的有：
 　　　　1.字符串类型（别名类似string）
 　　　　2.基本类型包装器类型及其数组类型（别名类似byte、byte[]）
 　　　　3.基本类型及其数组类型（别名类似_byte、_byte[]）
 　　　　4.日期类型及其数组类型（别名类似date、date[]）
 　　　　5.大数字类型及其数组类型（别名类似bigdecimal、bigdecimal[]）
 　　　　6.Object类型及其数组类型（别名类似object、object[]）
 　　　　7.集合类型（别名类似collection、map、list、hsahmap、arraylist、iterator）
 　　　　8.ResultSet结果集类型（别名为ResultSet）
 　注意：这并不是全部的MyBatis内置的类型别名，还有一部分类型别名是在创建Configuration实例的时候在其无参构造器中进行注册的，这里暂不介绍。
*/
public class TypeAliasRegistry {
  //这就是核心所在啊， 原来别名就仅仅通过一个HashMap来实现， key为别名， value就是别名对应的类型（class对象）
  private final Map<String, Class<?>> typeAliases = new HashMap<>();

  //构造函数里注册系统内置的类型别名
  public TypeAliasRegistry() {
    //字符串类型
    registerAlias("string", String.class);
    //基本包装类型
    registerAlias("byte", Byte.class);
    registerAlias("long", Long.class);
    registerAlias("short", Short.class);
    registerAlias("int", Integer.class);
    registerAlias("integer", Integer.class);
    registerAlias("double", Double.class);
    registerAlias("float", Float.class);
    registerAlias("boolean", Boolean.class);
    //基本数组包装类型
    registerAlias("byte[]", Byte[].class);
    registerAlias("long[]", Long[].class);
    registerAlias("short[]", Short[].class);
    registerAlias("int[]", Integer[].class);
    registerAlias("integer[]", Integer[].class);
    registerAlias("double[]", Double[].class);
    registerAlias("float[]", Float[].class);
    registerAlias("boolean[]", Boolean[].class);
    //加个下划线，就变成了基本类型
    registerAlias("_byte", byte.class);
    registerAlias("_long", long.class);
    registerAlias("_short", short.class);
    registerAlias("_int", int.class);
    registerAlias("_integer", int.class);
    registerAlias("_double", double.class);
    registerAlias("_float", float.class);
    registerAlias("_boolean", boolean.class);
    //加个下划线，就变成了基本数组类型
    registerAlias("_byte[]", byte[].class);
    registerAlias("_long[]", long[].class);
    registerAlias("_short[]", short[].class);
    registerAlias("_int[]", int[].class);
    registerAlias("_integer[]", int[].class);
    registerAlias("_double[]", double[].class);
    registerAlias("_float[]", float[].class);
    registerAlias("_boolean[]", boolean[].class);
    //日期数字型
    registerAlias("date", Date.class);
    registerAlias("decimal", BigDecimal.class);
    registerAlias("bigdecimal", BigDecimal.class);
    registerAlias("biginteger", BigInteger.class);
    registerAlias("object", Object.class);
    //集合型
    registerAlias("date[]", Date[].class);
    registerAlias("decimal[]", BigDecimal[].class);
    registerAlias("bigdecimal[]", BigDecimal[].class);
    registerAlias("biginteger[]", BigInteger[].class);
    registerAlias("object[]", Object[].class);
    //还有个ResultSet型
    registerAlias("map", Map.class);
    registerAlias("hashmap", HashMap.class);
    registerAlias("list", List.class);
    registerAlias("arraylist", ArrayList.class);
    registerAlias("collection", Collection.class);
    registerAlias("iterator", Iterator.class);

    registerAlias("ResultSet", ResultSet.class);
  }

    //注册类型别名
    public void registerAlias(String alias, Class<?> value) {
        if (alias == null) {
            throw new TypeException("The parameter alias cannot be null");
        }
        String key = alias.toLowerCase(Locale.ENGLISH);
        /**
         如果已经存在key了，且value和之前不一致，报错
         这里逻辑略显复杂，感觉没必要，一个key对一个value呗，存在key直接报错不就得了
         */
        if (typeAliases.containsKey(key) && typeAliases.get(key) != null && !typeAliases.get(key).equals(value)) {
            throw new TypeException("The alias '" + alias + "' is already mapped to the value '" + typeAliases.get(key).getName() + "'.");
        }
        typeAliases.put(key, value);
    }


}
