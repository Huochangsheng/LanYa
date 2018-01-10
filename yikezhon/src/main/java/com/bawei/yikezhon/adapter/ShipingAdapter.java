package com.bawei.yikezhon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yikezhon.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 霍长生 on 2018/1/9 0009.
 */

public class ShipingAdapter extends RecyclerView.Adapter<ShipingAdapter.ViewHolder> {
    private Context context;
    private List<?> list;
    private View view;

    @Override
    public ShipingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.shipinitem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShipingAdapter.ViewHolder holder, int position) {
       //holder.sd.setImageURI(Uri.parse(?));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sd;
        public ViewHolder(View itemView) {
            super(itemView);
            sd = (SimpleDraweeView)itemView.findViewById(R.id.sd);
        }
    }
}
