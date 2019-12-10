
package cn.goat.mybatis.session;


import cn.goat.mybatis.scripting.LanguageDriver;
import cn.goat.mybatis.scripting.LanguageDriverRegistry;
import cn.goat.mybatis.scripting.defaults.RawLanguageDriver;
import cn.goat.mybatis.scripting.xmltags.XMLLanguageDriver;

public class Configuration {

    //这个是指定解析的驱动，比如你可以使用velocity模板引擎来替代xml文件，默认是XMLLanguageDriver，也就是使用xml文件来写sql语句
    protected final LanguageDriverRegistry languageRegistry = new LanguageDriverRegistry();

    public Configuration() {
        languageRegistry.setDefaultDriverClass(XMLLanguageDriver.class);
        languageRegistry.register(RawLanguageDriver.class);
    }

    public LanguageDriver getLanguageDriver(Class<? extends LanguageDriver> langClass) {
        if (langClass == null) {
            return languageRegistry.getDefaultDriver();
        }
        languageRegistry.register(langClass);
        return languageRegistry.getDriver(langClass);
    }



}
