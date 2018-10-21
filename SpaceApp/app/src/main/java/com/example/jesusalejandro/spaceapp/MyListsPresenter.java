package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyListsPresenter implements MyListsContract.Presenter {
    private MyListsRepository repo;
    private MyListsContract.View vm;
    private CompositeDisposable disposables = new CompositeDisposable();

    public MyListsPresenter(MyListsRepository repo, MyListsContract.View vm){
        this.repo = repo;
        this.vm = vm;
    }

    @Override
    public void getMyLists() {
        Disposable disposable = repo.getMyLists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<MyLists>>() {
                            @Override
                            public void accept(List<MyLists> lists) throws Exception {
                                vm.showMyLists(lists);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                vm.showError(throwable.getMessage());
                            }
                        }
                );
        disposables.add(disposable);
    }

    @Override
    public void doOnDestroy()
    {
        disposables.dispose();
    }
}
