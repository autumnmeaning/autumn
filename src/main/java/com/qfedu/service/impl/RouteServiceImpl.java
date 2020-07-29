package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.IRouteDao;
import com.qfedu.pojo.Route;
import com.qfedu.service.IRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouteServiceImpl implements IRouteService {

    @Resource
    private IRouteDao routeDao;

    @Override
    public List<Object> getAllRoute(int page, int limit) {
        Map<String, Object> map  = null;
        List<Object> list = new ArrayList<>();
        PageHelper.startPage(page, limit);
        List<Route> allRoute = routeDao.getAllRoute();
        for (Route r : allRoute) {
            map = new HashMap<>();
            map.put("id", r.getId());
            map.put("gatewayApiName", r.getGatewayApiName());
            map.put("insideApiUrl", r.getInsideApiUrl());
            map.put("serviceId", r.getServiceId());
            map.put("description", r.getDescription());
            if (1 == r.getState()) {
                map.put("state", "有效");
            } else {
                map.put("state", "无效");
            }
            if (1 == r.getIdempotents()) {
                map.put("idempotents", "幂等");
            } else {
                map.put("idempotents", "非幂等");
            }
            if (1 == r.getNeedfee()) {
                map.put("needfee", "收费");
            } else  {
                map.put("needfee", "免费");
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public Route getRouteById(int id) {
        return routeDao.getRouteById(id);
    }

    @Override
    public int getLastId() {
        return routeDao.getLastId();
    }

    @Override
    public int getCount() {
        return routeDao.getCount();
    }

    @Override
    public boolean saveRoute(Route route) {
        return routeDao.saveRoute(route) > 0;
    }

    @Override
    public boolean updateRoute(Route route) {
        return routeDao.updateRoute(route) > 0;
    }

    @Override
    public boolean removeRoute(int id) {
        return routeDao.removeRoute(id) > 0;
    }
}
