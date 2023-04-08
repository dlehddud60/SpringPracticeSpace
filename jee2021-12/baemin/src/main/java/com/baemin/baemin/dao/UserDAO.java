package com.baemin.baemin.dao;

import com.baemin.baemin.dto.Join;

public interface UserDAO {
    void join(Join join);
    int overlapCheck(String value, String valueType);
}

