package com.syjgin.registrationform.repository;

import com.syjgin.registrationform.model.DaDataRequest;
import com.syjgin.registrationform.model.DaDataResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by user1 on 13.10.17.
 */

public interface DaDataApi {
    @POST("suggestions/api/4_1/rs/suggest/address")
    Single<DaDataResponse> getSuggestion(@Body DaDataRequest request);
}
