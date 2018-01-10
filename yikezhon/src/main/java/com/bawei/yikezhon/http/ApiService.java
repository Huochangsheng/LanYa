package com.bawei.yikezhon.http;

import com.bawei.yikezhon.bean.ReMenBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 霍长生 on 2018/1/1 0001.
 */

public interface ApiService {
    //首页数据
     @GET("homePageApi/homePage.do")
     Flowable<ReMenBean> gethomeData(@QueryMap Map<String, String> map);

}
