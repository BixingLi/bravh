package com.example.lenovo.dbravh.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lenovo.dbravh.ui.adapter.MyrvAdapter;
import com.example.lenovo.dbravh.R;
import com.example.lenovo.dbravh.ui.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<Bean> list=new ArrayList<>();
    private MyrvAdapter adapter;

    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        for (int i = 0; i <20 ; i++) {
            Bean bean = new Bean("张三" + i, R.mipmap.ic_launcher);
            list.add(bean);
        }
        adapter.notifyDataSetChanged();
    }
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        adapter = new MyrvAdapter(R.layout.layout_item, list);

  //动画效果
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);     //缩放效果
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);  //从左到右
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);   //从右到左
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM); //从下到上
        adapter.isFirstOnly(false); //重复执行动画

  //上拉加载   效果不正确!!!!!!
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (index >= list.size()-1) {
                            //数据全部加载完毕
                            adapter.loadMoreEnd();
                        }
                        }
                }, 1000);
            }
        }, mRecyclerView);

        mRecyclerView.setAdapter(adapter);
//短按事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                index = position;
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        });
//长按事件
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final BaseQuickAdapter adapter, View view, final int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("请选择操作")
                        .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("修改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Bean bean = list.get(position);
                                bean.setName("李四");
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .create()
                        .show();
                return true;
            }
        });
    }


}
