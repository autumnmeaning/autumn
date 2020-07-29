package com.qfedu.controller;

import com.qfedu.pojo.Adhibition;
import com.qfedu.service.IAdhibitionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdhibitionController {

    @Resource
    private IAdhibitionService adhibitionService;

    @GetMapping("/Adhibitions")
    public Map getAllAdhibitions(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        List<Object> allAdhibition = adhibitionService.getAllAdhibition(page, limit);
        Map<String, Object> adhibitionMap = new HashMap<>();
        adhibitionMap.put("code", 0);
        adhibitionMap.put("msg", "");
        adhibitionMap.put("count", adhibitionService.getCount());
        adhibitionMap.put("data", allAdhibition);
        return adhibitionMap;
    }

    @GetMapping("/GetAdhibitionById/{id}")
    public Adhibition getAdhibitionById(@PathVariable int id) {
        return adhibitionService.getAdhibitionById(id);
    }

    @PostMapping("/SaveAdhibition")
    public String saveAdhibition(Adhibition adhibition) {
        System.out.println(adhibition.getCorpName());
        if (adhibitionService.saveAdhibition(adhibition)) {
            return "success";
        }
        return "failed";
    }

    @PostMapping("/UpdateAdhibition")
    public String updateAdhibition(Adhibition adhibition) {
        if (adhibitionService.updateAdhibition(adhibition)) {
            return "success";
        }
        return "failed";
    }

    @GetMapping("/RemoveAdhibition/{id}")
    public String removeAdhibition(@PathVariable int id) {
        if (adhibitionService.removeAdhibition(id)) {
            return "success";
        }
        return "failed";
    }
}
