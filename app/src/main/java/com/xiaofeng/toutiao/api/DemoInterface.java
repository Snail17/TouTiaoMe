package com.xiaofeng.toutiao.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/2/6.
 */

public interface DemoInterface {

    // @GET中所填写的value和baseUrl组成完整的路径
    @GET("users")
    Call getUSer();

    // 动态的url访问@PATH
    // http://192.168.1.102:8080/springmvc_users/user/name
    // 即通过不同的username访问不同用户的信息，返回数据为json字符串。
    @GET("{username}")
    Call getUserName(@Path("username") String name);

    // 查询参数的设置@Query
    // http://baseurl/users?sortby=username
    @GET("username")
    Call getUserName2(@Query("sortby") String username);


    // 通过@POST指明url，添加FormUrlEncoded，然后通过@Field添加参数即可。
    @POST("login")
    @FormUrlEncoded
    Call login(@Field("username") String name, @Field("pass") String pass);


}
