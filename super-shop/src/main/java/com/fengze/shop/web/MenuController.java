package com.fengze.shop.web;

import com.fengze.shop.model.MenuDTO;
import com.fengze.shop.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangls on 2016/12/20 0020.
 */
@Slf4j
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired(required = false)
    private MenuService menuService;

    @ResponseBody
    @GetMapping(value = "/list",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<Long, List<MenuDTO>> menuListByJson() {
        return menuService.loadMenuAll().getResult();
    }

    @ResponseBody
    @PostMapping(value = "/list", produces = {MediaType.APPLICATION_XML_VALUE})
    public Map<Long, List<MenuDTO>> menuListByXml() {
        return menuService.loadMenuAll().getResult();
    }

}
