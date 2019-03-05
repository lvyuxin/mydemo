package com.senon.mvpretrofitrx.mvp.api;

import android.support.annotation.NonNull;
import android.util.Log;

import com.senon.mvpretrofitrx.mvp.utils.AppDate;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MoreBaseUrlInterceptor implements Interceptor {
    String tag="首页";
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //获取原始的originalRequest
        Request originalRequest = chain.request();
        //获取老的url
        HttpUrl oldUrl = originalRequest.url();
        //获取originalRequest的创建者builder
        Request.Builder builder = originalRequest.newBuilder();
        //获取头信息的集合如：manage,mdffx
        List<String> urlnameList = originalRequest.headers("url_name");
        if (urlnameList != null && urlnameList.size() > 0) {
            //删除原有配置中的值,就是namesAndValues集合里的值
            builder.removeHeader("url_name");
            //获取头信息中配置的value,如：manage或者mdffx
            String urlname = urlnameList.get(0);
            Log.i(tag,"头部   "+ urlname);
            HttpUrl baseURL = null;
            //根据头信息中配置的value,来匹配新的base_url地址
            if ("news".equals(urlname)) {
                baseURL = HttpUrl.parse(Api.baseUrl2);
            } else if ("wx".equals(urlname)) {
                baseURL = HttpUrl.parse(Api.baseUrl_wx);
            }else if ("wb".equals(urlname)) {
                baseURL = HttpUrl.parse(Api.baseUrl_wb);
            }else if ("xx".equals(urlname)) {
                baseURL = HttpUrl.parse(Api.baseUrl_xx);
            }
            Log.e(tag, "intercept: " + baseURL);
            //重建新的HttpUrl，需要重新设置的url部分
            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())//http协议如：http或者https
                    .host(baseURL.host())//主机地址
                    .port(baseURL.port())//端口
                    .build();
            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).build();
            Log.i(tag, "ppp " + newHttpUrl);
            Log.i(tag, "pppvvv " + baseURL.scheme() + "---" + baseURL.host() + "---" + baseURL.port());
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(originalRequest);
        }

    }
}
