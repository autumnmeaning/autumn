package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.IAdhibitionDao;
import com.qfedu.dao.IClientDao;
import com.qfedu.pojo.Adhibition;
import com.qfedu.pojo.Client;
import com.qfedu.service.IClientService;
import com.qfedu.util.Idutil;
import com.qfedu.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements IClientService {

    @Resource
    private IClientDao clientDao;

    @Resource
    private IAdhibitionDao adhibitionDao;

    @Override
    public List<Object> getAllClient(int page, int limit) {
        Map<String, Object> map  = null;
        List<Object> list = new ArrayList<>();
        PageHelper.startPage(page, limit);
        List<Client> allClient = clientDao.getAllClient();
        for (Client c : allClient) {
            map = new HashMap<>();
            map.put("id", c.getId());
            map.put("username", c.getUsername());
            map.put("password", c.getPassword());
            map.put("nickname", c.getNickname());
            map.put("address", c.getAddress());
            map.put("money", c.getMoney());
            if (1 == c.getState()) {
                map.put("state", "正常");
            } else {
                map.put("state", "停用");
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }



    @Override
    public boolean saveClient(Client client) {
        client.setId(Idutil.getId(clientDao.getLastId()));
        client.setPassword(MD5Util.getSaltMD5(client.getPassword()));
        return clientDao.saveClient(client) > 0;
    }

    @Override
    public boolean removeClient(int id) {
        Adhibition adhibition = adhibitionDao.getAdhibitionByCusId(id);
        if (adhibition != null) {
            adhibitionDao.removeAdhibitionByCusId(id);
            clientDao.removeClient(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateClient(Client client) {
        return clientDao.updateClient(client) > 0;
    }

    @Override
    public int getLastId() {
        return clientDao.getLastId();
    }

    @Override
    public int getCount() {
        return clientDao.getCount();
    }

    @Override
    public List<Map> getNickName() {
        return clientDao.getNickName();
    }

//    @Override
//    public List<Map> getNickName() {
//        return ;
//    }
}
