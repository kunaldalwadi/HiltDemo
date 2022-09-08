package com.dalwadibrothers.kunal.hiltdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface ApiCalls {

    @GET
    Call<ResponseBody> makeGETServiceCall(@Url String URL);

    @POST
    Call<ResponseBody> makePOSTServiceCall(@Url String URL);

    @PUT
    Call<ResponseBody> makePUTServiceCall(@Url String URL);

    @DELETE
    Call<ResponseBody> makeDELETEServiceCall(@Url String URL);

    @HEAD
    Call<ResponseBody> makeHEADServiceCall(@Url String URL);

}
