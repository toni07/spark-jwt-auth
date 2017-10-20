package RedisProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by previousdeveloper on 14.09.2015.
 */
public class DatabaseImpl implements IDatabase {

    private static final Map<String, Object> STORAGE_ENGINE = new HashMap<>();


    @Override
    public String set(String key, String value) {

        System.out.println("setting key '"+ key +"' to val '"+ value +"'");
        STORAGE_ENGINE.put(key, value);
        return value;
    }


    @Override
    public String get(String key) {
        final String res = STORAGE_ENGINE.get(key).toString();
        System.out.println("getting key '"+ key +"' : val '"+ res +"'");
        return res;
    }
}