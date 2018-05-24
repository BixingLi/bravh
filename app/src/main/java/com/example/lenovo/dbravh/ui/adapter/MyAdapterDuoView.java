package com.example.lenovo.dbravh.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lenovo.dbravh.R;
import com.example.lenovo.dbravh.ui.bean.BeanDuo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lenovo
 * on 2018/5/9.
 * at 北京
 */

public class MyAdapterDuoView extends BaseMultiItemQuickAdapter<BeanDuo.DataBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyAdapterDuoView(List<BeanDuo.DataBean> data) {
        super(data);
        addItemType(BeanDuo.DataBean.tag1, R.layout.layout_itemduo1);
        addItemType(BeanDuo.DataBean.tag2, R.layout.layout_itemduo2);
    }

    @Override
    protected void convert(BaseViewHolder helper, BeanDuo.DataBean item) {
        switch (helper.getItemViewType()) {
            case BeanDuo.DataBean.tag1:
                helper.setText(R.id.mTitle, item.getTitle());
                Picasso.with(mContext).load(item.getThumbnail_pic_s()).into((ImageView)helper.getView(R.id.mImg));
                break;
            case BeanDuo.DataBean.tag2:
                helper.setText(R.id.mTitle, item.getTitle());
                Picasso.with(mContext).load(item.getThumbnail_pic_s()).into((ImageView)helper.getView(R.id.mImg));
                Picasso.with(mContext).load(item.getThumbnail_pic_s02()).into((ImageView)helper.getView(R.id.mImg2));
                break;
        }
    }


}




