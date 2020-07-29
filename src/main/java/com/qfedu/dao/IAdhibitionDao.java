package com.qfedu.dao;

import com.qfedu.pojo.Adhibition;

import java.util.List;

public interface IAdhibitionDao {
    List<Adhibition> getAllAdhibition();

    Adhibition getAdhibitionById(int id);

    int getLastId();

    int getCount();

    int saveAdhibition(Adhibition adhibition);

    int updateAdhibition(Adhibition adhibition);

    int removeAdhibition(int id);

    int removeAdhibitionByCusId(int cusId);

    Adhibition getAdhibitionByCusId(int cusId);
}
