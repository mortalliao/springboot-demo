package com.springboot.mybatis.dao;

import com.springboot.mybatis.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 DAO 接口类
 * <p>
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
