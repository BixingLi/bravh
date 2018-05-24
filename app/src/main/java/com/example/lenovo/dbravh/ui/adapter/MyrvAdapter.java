package com.example.lenovo.dbravh.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.dbravh.R;
import com.example.lenovo.dbravh.ui.bean.Bean;

import java.util.List;

/**
 * Created by lenovo
 * on 2018/5/9.
 * at 北京
 */

public class MyrvAdapter extends BaseQuickAdapter<Bean, BaseViewHolder> {


    public MyrvAdapter(int layoutResId, @Nullable List<Bean> data) {

        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean item) {
        helper.setText(R.id.mText, item.getName());
        helper.setImageResource(R.id.mImg, item.getImg());


//        加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar())
//                .crossFade()
//                .into((ImageView) helper.getView(R.id.iv));
    }
}
