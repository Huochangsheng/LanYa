package com.bawei.yikezhon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 霍长生 on 2018/1/9 0009.
 */

public class NewFragment extends Fragment {

    private View v;
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        v = View.inflate(getActivity(), R.layout.listview, null);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //接收传递过来的值
        String string = getArguments().getString("name", "1");
        rv = (RecyclerView)v.findViewById(R.id.shipingrv);
        rv.setLayoutManager(new GridLayoutManager(getContext(),2));

        //rv.setAdapter();

    }
}
