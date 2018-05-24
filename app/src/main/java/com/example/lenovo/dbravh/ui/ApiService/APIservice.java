package com.example.lenovo.dbravh.ui.ApiService;

import com.example.lenovo.dbravh.ui.bean.BeanDuo;



import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lenovo
 * on 2018/5/9.
 * at 北京
 */

public interface APIservice {
   @GET("duobuju2.txt")
   Observable<BeanDuo> getData();
}
