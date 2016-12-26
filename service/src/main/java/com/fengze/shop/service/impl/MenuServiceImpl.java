package com.fengze.shop.service.impl;

import com.fengze.shop.common.Response;
import com.fengze.shop.model.MenuDTO;
import com.fengze.shop.model.MenuDo;
import com.fengze.shop.service.MenuService;
import com.fengze.shop.util.MyMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhangls on 2016/12/21 0021.
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired(required = false)
    private MyMapper<MenuDo> myMapper;

    @Override
    public Response<Map<Long, List<MenuDTO>>> loadMenuAll() {
        MenuDo menuDo = new MenuDo();
        menuDo.setTypePId(0L);
        Map<Long, List<MenuDo>> map = getMenuDetail(myMapper.select(menuDo), 0L, Maps.newHashMap());

        return new Response<>(getMenuConvertDTO(map));
    }

    private Map<Long, List<MenuDTO>> getMenuConvertDTO(Map<Long, List<MenuDo>> map) {
        Map<Long, List<MenuDTO>> res = Maps.newHashMap();

        try{
            for(Map.Entry<Long, List<MenuDo>> mapEntry : map.entrySet()){
                List<MenuDTO> ls = Lists.newArrayList();
                for (MenuDo menuDo : mapEntry.getValue()){
                    MenuDTO dto = new MenuDTO();
                    PropertyUtils.copyProperties(dto,menuDo);

                    ls.add(dto);
                }
                res.put(mapEntry.getKey(), ls);
            }
        }catch (Exception e){
            log.error("MenuServiceImpl==>getMenuConvertDTO, DO转DTO异常！");
        }

        return res;
    }

    /**
     * 递归方法，实现菜单信息的查询
     *
     * @return
     */
    private Map<Long, List<MenuDo>> getMenuDetail(List<MenuDo> ls, Long menuId, Map<Long, List<MenuDo>> map) {
        if (ls.size() != 0) {
            map.put(menuId, ls);
        }

        for (MenuDo menu : ls) {
            MenuDo menuDo = new MenuDo();
            menuDo.setTypePId(menu.getTypeId());
            getMenuDetail(myMapper.select(menuDo), menu.getTypeId(), map);
        }

        return map;
    }
}
