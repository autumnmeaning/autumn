package com.qfedu.dao;

import com.qfedu.pojo.Route;

import java.util.List;

public interface IRouteDao {

    List<Route> getAllRoute();

    Route getRouteById(int id);

    int getLastId();

    int getCount();

    int saveRoute(Route route);

    int updateRoute(Route route);

    int removeRoute(int id);

}
