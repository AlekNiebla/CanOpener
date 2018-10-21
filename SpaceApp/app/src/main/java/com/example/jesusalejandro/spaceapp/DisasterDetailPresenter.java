package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DisasterDetailPresenter implements DisasterDetailContract.Presenter {

    private DisasterRepository repo;
    private DisasterDetailContract.View vm;
    private CompositeDisposable disposables = new CompositeDisposable();

    public DisasterDetailPresenter(DisasterDetailContract.View vm, DisasterRepository repo) {
        this.repo = repo;
        this.vm = vm;
    }

    @Override
    public void getSupplies(NaturalDisaster disaster) {
        Disposable disposable = repo.getSupplies(disaster)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<String>>() {
                            @Override
                            public void accept(List<String> strings) throws Exception {
                                vm.showSupplies(strings);
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
    public void getActionItems(NaturalDisaster disaster) {
        Disposable disposable = repo.getActionItems(disaster)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<String>>() {
                            @Override
                            public void accept(List<String> strings) throws Exception {
                                vm.showActionItems(strings);
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
    public void getImages(NaturalDisaster disaster) {
        Disposable disposable = repo.getImages(disaster)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<DisasterImage>>() {
                            @Override
                            public void accept(List<DisasterImage> images) throws Exception {
                                vm.showImages(images);
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
    public void getVideo(NaturalDisaster disaster) {

    }

    @Override
    public void doOnDestroyed() {
        disposables.dispose();
    }
}
