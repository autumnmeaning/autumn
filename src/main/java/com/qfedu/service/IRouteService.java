package com.qfedu.service;

import com.qfedu.pojo.Route;

import java.util.List;

public interface IRouteService {
    List<Object> getAllRoute(int page, int limit);

    Route getRouteById(int id);

    int getLastId();

    int getCount();

    boolean saveRoute(Route route);

    boolean updateRoute(Route route);

    boolean removeRoute(int id);
}
