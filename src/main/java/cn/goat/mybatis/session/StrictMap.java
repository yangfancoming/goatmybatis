package cn.goat.mybatis.session;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class StrictMap<V> extends HashMap<String, V> {

    private static final long serialVersionUID = -4950446264854982944L;
    private final String name;
    private BiFunction<V, V, String> conflictMessageProducer;

    public StrictMap(String name, int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.name = name;
    }

    public StrictMap(String name, int initialCapacity) {
        super(initialCapacity);
        this.name = name;
    }

    public StrictMap(String name) {
        super();
        this.name = name;
    }

    public StrictMap(String name, Map<String, ? extends V> m) {
        super(m);
        this.name = name;
    }

    /**
     * Assign a function for producing a conflict error message when contains value with the same key.
     * 当包含具有相同键的值时，分配用于生成冲突错误消息的函数
     * function arguments are 1st is saved value and 2nd is target value.
     * 函数参数是第一个是保存值，第二个是目标值
     * @param conflictMessageProducer A function for producing a conflict error message
     * @return a conflict error message
     * @since 3.5.0
     */
    public StrictMap<V> conflictMessageProducer(BiFunction<V, V, String> conflictMessageProducer) {
        this.conflictMessageProducer = conflictMessageProducer;
        return this;
    }

    /**
     * 通过代码可以看出，重写put方法重要是为了，当key值有重复时，抛出异常。
     * 而不像原生map那样 直接覆盖掉之前的键值
     */
    @Override
    @SuppressWarnings("unchecked")
    public V put(String key, V value) {
        if (containsKey(key)) { //  #101
            throw new IllegalArgumentException(name + " already contains value for " + key + (conflictMessageProducer == null ? "" : conflictMessageProducer.apply(super.get(key), value)));
        }
        if (key.contains(".")) {
            final String shortKey = getShortName(key);
            if (super.get(shortKey) == null) {
                super.put(shortKey, value);
            } else {
                super.put(shortKey, (V) new Ambiguity(shortKey));
            }
        }
        return super.put(key, value);
    }

    @Override
    public V get(Object key) {
        V value = super.get(key);
        if (value == null) {
            // name： Mapped Statements collection
            // key ： org.apache.goat.chapter100.A044.FooMapper.selectById
            throw new IllegalArgumentException(name + " does not contain value for " + key);
        }
        if (value instanceof Ambiguity) {
            throw new IllegalArgumentException(((Ambiguity) value).getSubject() + " is ambiguous in " + name  + " (try using the full name including the namespace, or rename one of the entries)");
        }
        return value;
    }

    protected static class Ambiguity {

        final private String subject;

        public Ambiguity(String subject) {
            this.subject = subject;
        }

        public String getSubject() {
            return subject;
        }
    }

    private String getShortName(String key) {
        final String[] keyParts = key.split("\\.");
        return keyParts[keyParts.length - 1];
    }
}

