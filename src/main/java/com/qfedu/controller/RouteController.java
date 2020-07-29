package com.qfedu.controller;

import com.qfedu.pojo.Route;
import com.qfedu.service.IRouteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RouteController {


    @Resource
    private IRouteService routeService;

    @GetMapping("/Routes")
    public Map getAllRoutes(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        List<Object> allRoute = routeService.getAllRoute(page, limit);
        Map<String, Object> routeMap = new HashMap<>();
        routeMap.put("code", 0);
        routeMap.put("msg", "");
        routeMap.put("count", routeService.getCount());
        routeMap.put("data", allRoute);
        return routeMap;
    }

    @GetMapping("/GetRouteById/{id}")
    public Route getRouteById(@PathVariable int id) {
        return routeService.getRouteById(id);
    }


    @PostMapping("/SaveRoute")
    public String saveRoute(Route route) {
        if (routeService.saveRoute(route)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateRoute")
    public String updateClient(Route route) {
        if (routeService.updateRoute(route)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveRoute/{id}")
    public String removeRoute(@PathVariable int id) {
        if (routeService.removeRoute(id)) {
            return "success";
        }
        return "failed";
    }
}
