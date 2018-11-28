package com.utad.barriforinitework3.Fortnite;

import io.reactivex.Observable;

public class RepositoryFortnite {

    private static volatile RepositoryFortnite ourInstance = new RepositoryFortnite();

    static RepositoryFortnite getInstance() {
        if (ourInstance == null) {
            synchronized (RepositoryFortnite.class) {
                if (ourInstance == null) {
                    ourInstance = new RepositoryFortnite();
                }
            }
        }
        return ourInstance;
    }


    private ForniteAPI forniteApi = ForniteAPI.Factory();
    public Observable<UserFortnite> getFortniteInfo(String platformGame, String epic_nickname){
        //return gerritAPI.loadChanges(status);
        return forniteApi.getFortniteInfo(platformGame,epic_nickname);
    }

}