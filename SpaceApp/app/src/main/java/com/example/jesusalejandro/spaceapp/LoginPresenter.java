package com.example.jesusalejandro.spaceapp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View vm;
    private LoginRepository repo;
    private CompositeDisposable disposables = new CompositeDisposable();

    public LoginPresenter(LoginContract.View vm, LoginRepository repo) {
        this.vm = vm;
        this.repo = repo;
    }

    @Override
    public void login(User user) {
        Disposable disposable = repo.getLogin(user)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) throws Exception {
                                vm.login(aBoolean);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        }
                );
        disposables.add(disposable);
    }

    @Override
    public void register(User user) {
        Disposable disposable = repo.getRegister(new User(1, "example@nasa.com", "1234"))
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<User>() {
                            @Override
                            public void accept(User user) throws Exception {
                                vm.register(user);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                
                            }
                        }
                );
        disposables.add(disposable);
    }
}
