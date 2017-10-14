package com.syjgin.registrationform.interactor;

import com.syjgin.registrationform.model.DaDataRequest;
import com.syjgin.registrationform.model.DaDataResponse;
import com.syjgin.registrationform.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by user1 on 13.10.17.
 */

public class SuggestionInteractor {
    private Disposable disposable;

    public void unsubscribe() {
        if(disposable != null) {
            if(!disposable.isDisposed())
                disposable.dispose();
        }
    }

    public void startLoading(String query) {
        DaDataRequest request = new DaDataRequest();
        request.query = query;
        Repository.getRepository().getSuggestion(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<DaDataResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onSuccess(@NonNull DaDataResponse daDataResponse) {
                EventBus.getDefault().post(daDataResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                DaDataResponse response = new DaDataResponse();
                response.suggestions = new ArrayList<>();
                EventBus.getDefault().post(response);
            }
        });
    }
}
