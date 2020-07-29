package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.IAdhibitionDao;
import com.qfedu.dao.IClientDao;
import com.qfedu.pojo.Adhibition;
import com.qfedu.service.IAdhibitionService;
import com.qfedu.util.Idutil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdhibitionServiceImpl implements IAdhibitionService {

    @Resource
    private IAdhibitionDao adhibitionDao;

    @Resource
    private IClientDao clientDao;

    @Override
    public List<Object> getAllAdhibition(int page, int limit) {
        Map<String, Object> map  = null;
        List<Object> list = new ArrayList<>();
        PageHelper.startPage(page, limit);
        List<Adhibition> allAdhibition = adhibitionDao.getAllAdhibition();
        for (Adhibition a : allAdhibition) {
            map = new HashMap<>();
            map.put("id", a.getId());
            map.put("corpName", a.getCorpName());
            map.put("appName", a.getAppName());
            map.put("appKey", a.getAppKey());
            map.put("AppSecret", a.getAppSecret());
            map.put("redirectUrl", a.getRedirectUrl());
            map.put("linit", a.getLinit());
            map.put("description", a.getDescription());
            map.put("cusId", a.getCusId());
            if (1 == a.getState()) {
                map.put("state", "有效");
            } else {
                map.put("state", "失效");
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public Adhibition getAdhibitionById(int id) {
        return adhibitionDao.getAdhibitionById(id);
    }

    @Override
    public int getCount() {
        return adhibitionDao.getCount();
    }

    @Override
    public boolean saveAdhibition(Adhibition adhibition) {
        adhibition.setId(Idutil.getId(adhibitionDao.getLastId()));
        adhibition.setCorpName(clientDao.getClientById(Integer.parseInt(adhibition.getCorpName())).getNickname());
        adhibition.setAppKey("uuid()");
        adhibition.setAppSecret("uuid()");
        adhibition.setCusId(clientDao.getClientByNickname(adhibition.getCorpName()).getId());
        return adhibitionDao.saveAdhibition(adhibition) > 0;
    }

    @Override
    public boolean updateAdhibition(Adhibition adhibition) {
        adhibition.setCusId(clientDao.getClientByNickname(adhibition.getCorpName()).getId());
        return adhibitionDao.updateAdhibition(adhibition) > 0;
    }

    @Override
    public boolean removeAdhibition(int id) {
        return adhibitionDao.removeAdhibition(id) > 0;
    }
}
