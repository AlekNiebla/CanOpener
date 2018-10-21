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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                                vm.showError("Wrong username or password");
                            }
                        }
                );
        disposables.add(disposable);
    }

    @Override
    public void register(User user) {
        Disposable disposable = repo.getRegister(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
                                throwable.printStackTrace();
                            }
                        }
                );
        disposables.add(disposable);
    }
}
