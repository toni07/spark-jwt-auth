package DataAccess;

import Model.UserModel;
import RedisProvider.IDatabase;
import com.google.gson.Gson;
import com.google.inject.Inject;

/**
 * Created by previousdeveloper on 16.09.2015.
 */
public class UserRepositoryImpl implements IUserRepository {

    private IDatabase redis;
    private Gson gson;
    private UserModel userModel = null;

    @Inject
    public UserRepositoryImpl(IDatabase redis) {
        this.redis = redis;
        gson = new Gson();
    }

    @Override
    public UserModel getUser() {

        String user = redis.get("user");
        this.userModel = gson.fromJson(user, UserModel.class);

        return userModel;
    }
}
