package com.example.divin.studenthelper.retofit;

import com.example.divin.studenthelper.mvp.model.Data.LectureItem;
import com.example.divin.studenthelper.mvp.model.Data.ResultTestInfo;
import com.example.divin.studenthelper.mvp.model.Data.RozkladObj;
import com.example.divin.studenthelper.mvp.model.Data.Rozklad_server_object;
import com.example.divin.studenthelper.mvp.model.Data.StudentInfo;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.model.Data.TestItem;
import com.example.divin.studenthelper.mvp.model.Data.TestList;
import com.example.divin.studenthelper.mvp.model.Data.UserRoleValue;

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
    @POST("Teacher/ChangeSTatus")
    Call<Void> change_status_test(@Field("id_test") int id_test, @Field("new_status") int new_status);

    @FormUrlEncoded
    @POST("TestStudent/SendResult")
    Call<Void> send_test_result(@Field("result_value") String result,
                                @Field("id_test") int id_test,
                                @Field("user_ident") String user_ident);

    @FormUrlEncoded
    @POST("Account/CheckVisit")
    Call<Void> add_visit_students(@Field("list_student") String list, @Field("data_visit") String data_visit,
                                  @Field("id_r") int id_r);

    @FormUrlEncoded
    @POST("User/Index")
    Call<Void> addUserToDatabases(@Field("mail") String mail, @Field("name") String name,
                                @Field("ident") String ident);
    @FormUrlEncoded
    @POST("Account/LecturesId")
    Call<Void> sendLectureChanges(@Field("saved") String saved, @Field("id_roz") int id,
                                @Field("time_val") int kod_time, @Field("type_zn") int kod_type,
                                  @Field("audyt") String audyt);

    @FormUrlEncoded
    @POST("User/GetRoleUserByIdent")
    Observable<UserRoleValue> getUserRole(@Field("ident") String ident);


    @FormUrlEncoded
    @POST("Rozklad/GetRozkladByGroupId")
    Observable<Rozklad_server_object> getRozklad(@Field("idGroup") int id, @Field("kodWeek") int kodWeek);

    @GET("/Teacher")
    Observable<List<Teacher>> getTeachers();

    @FormUrlEncoded
    @POST("Rozklad/getTeacherRozkl")
    Observable<Rozklad_server_object> getTeacherRozkl(@Field("ident") String ident, @Field("kodWeek") int kod);

    @FormUrlEncoded
    @POST("Account/LectureAPI_byIdent")
    Observable<LectureItem> getLectureDataById(@Field("ident") String ident, @Field("lecture_id") int lecture_id);

    @FormUrlEncoded
    @POST("Student/Index")
    Observable<List<StudentInfo>> getListStudentByGroupId(@Field("kod_g") int kod_g);

    @FormUrlEncoded
    @POST("Teacher/GetTestList")
    Observable<List<TestList>> getTestList(@Field("user_ident") String user_id);

    @FormUrlEncoded
    @POST("Teacher/GetAccessTestById")
    Observable<List<TestList>> get_access_TestList(@Field("ident") String user_id);

    @FormUrlEncoded
    @POST("TestStudent/GetTestBodyById")
    Observable<List<TestItem>> get_full_test_list(@Field("id") int id_test);

    @FormUrlEncoded
    @POST("Teacher/GetTestResultById")
    Observable<List<ResultTestInfo>> get_test_results_by_id(@Field("ident") String user_id);
}
