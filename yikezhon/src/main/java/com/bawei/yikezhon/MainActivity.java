package com.bawei.yikezhon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bawei.yikezhon.fragment.OneFragment;
import com.bawei.yikezhon.fragment.ThreeFragment;
import com.bawei.yikezhon.fragment.TwoFragment;
import com.facebook.rebound.SpringConfig;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jpeng.jpspringmenu.MenuListener;
import com.jpeng.jpspringmenu.SpringMenu;


public class MainActivity extends AppCompatActivity implements MenuListener {


    private BottomTabBar mb;
    private SpringMenu mSpringMenu;
    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //沉浸式
        new ImmersionUtil().setImmersion(getWindow(), getSupportActionBar());
        tab();

        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        mSpringMenu = new SpringMenu(this, R.layout.view_menu);
        mSpringMenu.setMenuListener(this);
        mSpringMenu.setFadeEnable(true);
        mSpringMenu.setChildSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(20, 5));
        mSpringMenu.setDragOffset(0.4f);
        mTitleBar.setLeftText("Left");
        mTitleBar.setBackgroundColor(Color.parseColor("#64b4ff"));
        mTitleBar.setDividerColor(Color.GRAY);
        mTitleBar.setTitleColor(Color.WHITE);
        mTitleBar.setLeftTextColor(Color.WHITE);
        mTitleBar.setActionTextColor(Color.WHITE);
        mTitleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpringMenu.setDirection(SpringMenu.DIRECTION_LEFT);
                mSpringMenu.openMenu();
            }
        });


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mSpringMenu.dispatchTouchEvent(ev);
    }


    @Override
    public void onMenuOpen() {
        Toast.makeText(this, "Menu is opened!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMenuClose() {
        Toast.makeText(this, "Menu is closed!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(float value, boolean bouncing) {

    }


    //底部导航栏
    private void tab() {
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(16)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.parseColor("#1296db"),Color.DKGRAY)
                .addTabItem("推荐",R.drawable.untuijian,R.drawable.tuijian, OneFragment.class)
                .addTabItem("段子",R.drawable.unxiaolian,R.drawable.xiaolian, TwoFragment.class)
                .addTabItem("视频",R.drawable.unshipin,R.drawable.shipin, ThreeFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
