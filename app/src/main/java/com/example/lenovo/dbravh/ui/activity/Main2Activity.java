package com.example.lenovo.dbravh.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.dbravh.R;
import com.example.lenovo.dbravh.ui.ApiService.APIservice;
import com.example.lenovo.dbravh.ui.adapter.MyAdapterDuoView;
import com.example.lenovo.dbravh.ui.bean.Bean;
import com.example.lenovo.dbravh.ui.bean.BeanDuo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<BeanDuo.DataBean> list=new ArrayList<>();
    private MyAdapterDuoView adapterDuoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {

        new Retrofit.Builder().baseUrl("http://172.16.54.17:8080/test/")
                 .addConverterFactory(GsonConverterFactory.create(new Gson()))
                 .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .build().create(APIservice.class)
                 .getData().subscribeOn(Schedulers.newThread())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<BeanDuo>() {
                     @Override
                     public void onCompleted() {

                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onNext(BeanDuo beanDuo) {
                         List<BeanDuo.DataBean> data = beanDuo.getData();
                         for (BeanDuo.DataBean bean : data) {
                             if(bean.getThumbnail_pic_s()!=null){
                                 if(bean.getThumbnail_pic_s02()!=null){
                                     bean.setItemType(2);
                                     continue;
                                 }
                                 bean.setItemType(1);
                             }
                         }
                         list.addAll(data);
                         adapterDuoView.notifyDataSetChanged();

                     }
                 });
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        adapterDuoView = new MyAdapterDuoView(list);
        mRecyclerView.setAdapter(adapterDuoView);

    }
}
