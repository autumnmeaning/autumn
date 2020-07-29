package com.qfedu.service;

import com.qfedu.pojo.Adhibition;

import java.util.List;
import java.util.Map;

public interface IAdhibitionService {

    List<Object> getAllAdhibition(int page, int limit);

    Adhibition getAdhibitionById(int id);

    int getCount();

    boolean saveAdhibition(Adhibition adhibition);

    boolean updateAdhibition(Adhibition adhibition);

    boolean removeAdhibition(int id);
}
