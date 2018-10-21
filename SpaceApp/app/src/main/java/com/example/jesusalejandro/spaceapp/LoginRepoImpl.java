package com.example.jesusalejandro.spaceapp;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRepoImpl implements LoginRepository {
    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private LoginService service = retrofit.create(LoginService.class);
    @Override
    public Single<Boolean> getLogin(User user) {
//        return service.login(user.getEmail(), user.getPassword());
        return Single.just(true);
    }

    @Override
    public Single<User> getRegister(User user) {
        return service.register(user);
    }
}
