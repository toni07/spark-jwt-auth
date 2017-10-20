package DataAccess;

import Model.UserModel;
import RedisProvider.IDatabase;
import Util.JsonTransformer;
import com.google.inject.Inject;

/**
 * Created by previousdeveloper on 14.09.2015.
 */
public class SignupRepositoryImpl implements ISignupRepository {

    private IDatabase redis;

    @Inject
    public SignupRepositoryImpl(IDatabase redis) {

        this.redis = redis;
    }

    public void saveUser(UserModel userModel) {

        String value = null;

        try {
            value = new JsonTransformer().render(userModel);
            redis.set("user", value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
