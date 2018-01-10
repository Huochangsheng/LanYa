package com.bawei.yikezhon.presenter;


import com.bawei.yikezhon.bean.ReMenBean;
import com.bawei.yikezhon.model.DataModel;
import com.bawei.yikezhon.model.IModel;
import com.bawei.yikezhon.view.IView;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;


/**
 * Created by 霍长生 on 2018/1/1 0001.
 */

public class DataPresenter implements BasePresenter {
    private IView iv;
    private DisposableSubscriber<ReMenBean> subscriber;

    public void acceachView(IView iv) {
        this.iv = iv;
    }

    public void detechView() {
        if (iv != null) {
            iv = null;
        }
        if (subscriber != null) {
            if (!subscriber.isDisposed()) {
                subscriber.dispose();
            }
        }
    }

    @Override
    public void gethomeData(Map<String, String> map) {

        IModel model = new DataModel(this);
        model.gethomeData(map);
    }

    public void getDatas(Flowable<ReMenBean> flowable) {

        subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ReMenBean>() {
                    //普通事件
                    @Override
                    public void onNext(ReMenBean listJsonRootBean) {

                        if (listJsonRootBean != null) {
                            String msg = listJsonRootBean.getMsg();

                        }

                    }

                    //异常事件
                    @Override
                    public void onError(Throwable t) {
                        iv.onFailes(new Exception(t));

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
