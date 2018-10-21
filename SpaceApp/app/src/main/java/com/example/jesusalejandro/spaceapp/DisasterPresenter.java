package com.example.jesusalejandro.spaceapp;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DisasterPresenter implements NaturalDisasterContract.Presenter {
    private DisasterRepository repo;
    private NaturalDisasterContract.View vm;
    private CompositeDisposable disposables = new CompositeDisposable();

    public DisasterPresenter(DisasterRepository repo, NaturalDisasterContract.View vm){
        this.repo = repo;
        this.vm = vm;
    }

    @Override
    public void getDisasters() {
        Disposable disposable = repo.getDisasters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<NaturalDisaster>>() {
                            @Override
                            public void accept(List<NaturalDisaster> disasters) throws Exception {
                                vm.showDisasters(disasters);
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
    public void doOnDestroy() {
        disposables.dispose();
    }
}
