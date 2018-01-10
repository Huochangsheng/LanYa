package com.bawei.yikezhon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yikezhon.OneNewFragment;
import com.bawei.yikezhon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 霍长生 on 2018/1/9 0009.
 */

public class OneFragment extends Fragment {

    private View view;
    private List<String> list=new ArrayList<String>();
    private TabLayout tab;
    private ViewPager pa;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.onefragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tab = (TabLayout) view.findViewById(R.id.onetab);
        pa = (ViewPager) view.findViewById(R.id.onepager);
        list.add("热门");
        list.add("关注");
        pa.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {

                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                OneNewFragment newFragment = new OneNewFragment();
                Bundle bundle = new Bundle();
                if (list.get(position).equals("热门")){
                    bundle.putString("name","1");
                }else if (list.get(position).equals("关注")) {
                    bundle.putString("name", "2");
                }
                newFragment.setArguments(bundle);

                return newFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        //tablayout和viewpager关联
        tab.setupWithViewPager(pa);


    }
}
