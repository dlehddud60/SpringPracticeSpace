package org.example.myapp.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {


    @Select("SELECT current_date FROM dual")
    public abstract String getNow();
}
