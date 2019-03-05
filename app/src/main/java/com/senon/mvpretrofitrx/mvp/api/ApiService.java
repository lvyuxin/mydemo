package com.senon.mvpretrofitrx.mvp.api;

import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.base.Response;
import com.senon.mvpretrofitrx.mvp.bean.NewsSummary;
import com.senon.mvpretrofitrx.mvp.bean.TodayNews;
import com.senon.mvpretrofitrx.mvp.bean.itemNews;
import com.senon.mvpretrofitrx.mvp.bean.newBean;
import com.senon.mvpretrofitrx.mvp.bean.smalBean;
import com.senon.mvpretrofitrx.mvp.bean.videoItem;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.entity.learnDate;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * api service
 */
public interface ApiService {
    //    http://c.m.163.com/nc/article/headline/T1348647909107/0-20.htm
    @Headers({"url_name:newss"})
    @GET("nc/article")
    Observable<BaseResponse> getDate(@QueryMap Map<String, String> map);



    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    @Headers({"url_name:news"})
    Observable<Map<String, List<NewsSummary>>> getNews(
            @Path("type") String type,
            @Path("id") String id,
            @Path("startPage") String startPage);

    //微新闻精选
    @GET("post/toutiao")
    @Headers({"url_name:wb"})
    Observable<BaseResponse<List<smalBean>>> getSmalNews(@QueryMap Map<String, String> map);

    //今日头条
    @GET("toutiao/index")
    @Headers({"url_name:wb"})
    Observable<Response> getfilm(@QueryMap Map<String, String> map);

    @GET("toutiao/index")
    @Headers({"url_name:wb"})
    Observable<BaseResponse<List<itemNews>>> getTodayNews(@QueryMap Map<String, String> map);

    //今日头条视频
    @GET("video/toutiao")
    @Headers({"url_name:wb"})
    Observable<BaseResponse<List<videoItem>>> getTodayVideo(@QueryMap Map<String, String> map);
    //注册
    @FormUrlEncoded
    @POST("user/login")//post 不带参数
    @Headers({"url_name:xx"})
    Observable<BaseResponse> login(@Field("username") String userName,@Field("password") String pas);
    @FormUrlEncoded
    @POST("user/register")
    @Headers({"url_name:xx"})
    Observable<BaseResponse> regsin(@FieldMap Map<String, String> map);
    //豌豆学习
    @GET("article/list/{page}/json ")
    @Headers({"url_name:xx"})//替换接口中{}字段
    Observable<BaseResponse> getLearnDate(@Path("page") String page);

    @POST("lg/collect/{originId}/json")//收藏
    @Headers({"url_name:xx"})
    Observable<BaseResponse> Collect(@Path("originId") String page);

    //    http://wanandroid.com/lg/uncollect_originId/7958/json
    @POST("uncollect_originId/{originId}/json")//取消收藏
    @Headers({"url_name:xx"})
    Observable<BaseResponse> cancelCollect(@Path("originId") String page);

    @POST("lg/collect/list/{originId}/json")//取消收藏
    @Headers({"url_name:xx"})
    Observable<BaseResponse> CollectList(@Path("originId") String page);

    @POST("query")
    Observable<BaseResponse<List<Login>>> logout(@QueryMap Map<String, String> map);

    // 登录的请求
    @POST("user/clientlogin.do")
    Observable<BaseResponse> login2(@QueryMap Map<String, String> map);


}
