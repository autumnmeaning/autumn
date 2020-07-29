package com.qfedu.dao;

import com.qfedu.pojo.Client;

import java.util.List;
import java.util.Map;

public interface IClientDao {

    // 查找所有客户
    List<Client> getAllClient();

    // 查找指定id的客户getClientByNickname
    Client getClientById(int id);

    Client getClientByNickname(String nickname);

    List<Map> getNickName();

    // 增
    int saveClient(Client client);

    // 删
    int removeClient(int id);

    // 改
    int updateClient(Client client);

    int getLastId();

    int getCount();
}
