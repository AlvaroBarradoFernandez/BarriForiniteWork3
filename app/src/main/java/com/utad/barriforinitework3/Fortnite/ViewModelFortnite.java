package com.utad.barriforinitework3.Fortnite;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelFortnite extends ViewModel {

    private RepositoryFortnite repositoryFortnite = RepositoryFortnite.getInstance();
    public MutableLiveData<List<RankFortnite>> fortniteData = new MutableLiveData<>();
    public List<RankFortnite> dataList = new ArrayList<>();


    public void getData(String platformGame, String epic_nickname){

        repositoryFortnite.getFortniteInfo(platformGame,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserFortnite>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFortnite forniteObject) {
                        if(forniteObject==null) {
                            dataList.clear();
                        }

                        else{

                            dataList.clear();
                            GeneralDataFortnite data = forniteObject.getStats().getP2();
                            dataList.add(data.getScore());
                            dataList.add(data.getScorePerMatch());
                            dataList.add(data.getMatches());
                            dataList.add(data.getKills());
                            fortniteData.postValue(dataList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}