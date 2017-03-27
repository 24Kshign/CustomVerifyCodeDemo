package com.share.jack.customverifycodeviewdemo.model.api;


import com.share.jack.customverifycodeviewdemo.http.BaseResponse;
import com.share.jack.customverifycodeviewdemo.model.entity.RecyclerViewBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 *
 */

public interface MainApi {

    @GET("/api/teacher?type=4&num=30")
    Observable<BaseResponse<List<RecyclerViewBean>>> getMainInfoByGet();

    @POST("/api/teacher?type=4&num=30")
    Observable<BaseResponse<List<RecyclerViewBean>>> getMainInfoByPost();
}