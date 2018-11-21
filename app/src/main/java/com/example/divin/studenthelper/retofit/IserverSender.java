package com.example.divin.studenthelper.retofit;

import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad_server_object;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface IserverSender {

    @FormUrlEncoded
    @POST("User/Index")
    Call<Void> addUserToDatabases(@Field("mail") String mail,
                                @Field("name") String name,
                                @Field("ident") String ident);

    @GET("/Database/Versiondb")
    Observable<Integer> getServerDbVersion();

    @FormUrlEncoded
    @POST("Rozklad/GetRozkladByGroupId")
    Observable<Rozklad_server_object> getRozklad(@Field("idGroup") int id, @Field("kodWeek") int kodWeek);


}
