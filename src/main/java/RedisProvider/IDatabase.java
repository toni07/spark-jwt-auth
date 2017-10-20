package RedisProvider;

/**
 * Created by previousdeveloper on 14.09.2015.
 */
public interface IDatabase {

    String set(String key, String value);

    String get(String key);
}
