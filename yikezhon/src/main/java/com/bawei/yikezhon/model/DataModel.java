package com.bawei.yikezhon.model;


import com.bawei.yikezhon.bean.ReMenBean;
import com.bawei.yikezhon.http.RetrofitUtil;
import com.bawei.yikezhon.presenter.DataPresenter;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by 霍长生 on 2018/1/1 0001.
 */

public class DataModel implements IModel {
    private DataPresenter presenter;


    //首页model
    public DataModel(DataPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void gethomeData(Map<String, String> map) {
        Flowable<ReMenBean> flowable = RetrofitUtil.getInstant("http://api.svipmovie.com/front/").getApiService().gethomeData(map);
        presenter.getDatas(flowable);
    }

}
