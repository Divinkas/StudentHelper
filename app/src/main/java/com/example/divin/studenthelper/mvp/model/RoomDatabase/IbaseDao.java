package com.example.divin.studenthelper.mvp.model.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.divin.studenthelper.mvp.model.Data.Days;
import com.example.divin.studenthelper.mvp.model.Data.Group;
import com.example.divin.studenthelper.mvp.model.Data.Para;
import com.example.divin.studenthelper.mvp.model.Data.Teacher;
import com.example.divin.studenthelper.mvp.model.Data.TypeZn;

import java.util.List;

@Dao
public interface IbaseDao {

    @Query("select * from Days")
    List<Days> getDays();

    @Query("select * from `Group`")
    List<Group> getGroup();

    @Query("select * from Para")
    List<Para> getPara();

    @Query("select * from Teacher")
    List<Teacher> getTeachers();

    @Query("select * from TypeZn")
    List<TypeZn> getTypeZn();


}
