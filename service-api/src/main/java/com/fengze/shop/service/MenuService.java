package com.fengze.shop.service;


import com.fengze.shop.common.Response;
import com.fengze.shop.model.MenuDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangls on 2016/12/20 0020.
 */
public interface MenuService {

    /**
     * 查询菜单
     * @return
     */
    public Response<Map<Long, List<MenuDTO>>> loadMenuAll() ;
}
