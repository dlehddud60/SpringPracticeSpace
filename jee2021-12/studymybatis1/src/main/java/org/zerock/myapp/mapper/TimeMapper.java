package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TimeMapper {

//    @Delete("DELETE FROM ...")
//    @Update("UPDATE ...")
//    @Insert("INSERT INTO ,,,")

    @Select("SELECT current_date FROM dual")
    public abstract String getNow();

}
