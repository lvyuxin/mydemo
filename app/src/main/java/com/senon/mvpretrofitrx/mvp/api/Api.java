package com.senon.mvpretrofitrx.mvp.api;

import com.senon.mvpretrofitrx.mvp.base.BaseApi;

/**
 *
 */

public class Api {

//    private String baseUrl = "http://ydcg.cpylss.com:8081/ydcg/";
//    private String baseUrl2 = "http://c.m.163.com/";

    public static final String baseUrl = "http://ydcg.cpylss.com:8081/";
    public static final String baseUrl2 = "http://v.juhe.cn/";//今日头条
    public static final String baseUrl_wx = "http://v.juhe.cn/";
    public static final String baseUrl_wb = "http://v.juhe.cn/";

    public static final String baseUrl_xx = "http://wanandroid.com/";
    private volatile static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        BaseApi baseApi = new BaseApi();
        apiService = baseApi.getRetrofit(baseUrl2).create(ApiService.class);
    }
}
