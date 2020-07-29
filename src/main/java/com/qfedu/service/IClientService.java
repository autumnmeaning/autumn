package com.qfedu.service;

import com.qfedu.pojo.Client;

import java.util.List;
import java.util.Map;

public interface IClientService {

    // 查找所有客户
    List<Object> getAllClient(int page, int limit);

    // 查找指定id的客户
    Client getClientById(int id);

    // 增
    boolean saveClient(Client client);

    // 删
    boolean removeClient(int id);

    // 改
    boolean updateClient(Client client);

    int getLastId();

    int getCount();

    List<Map> getNickName();
}
