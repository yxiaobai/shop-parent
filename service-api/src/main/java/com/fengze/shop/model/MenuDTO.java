package com.fengze.shop.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangls on 2016/12/26 0026.
 */
@Data
@XStreamAlias("menu")
public class MenuDTO implements Serializable {

    /**
     * 商品类型ID
     */
    @XStreamAsAttribute
    private Long typeId;

    /**
     * 商品类型名称
     */
    @XStreamAsAttribute
    private String typeName;

    /**
     * 商品类型父ID
     */
    @XStreamAsAttribute
    private Long typePId;

    /**
     * 菜单URL
     */
    @XStreamAsAttribute
    private String menuUri;

    /**
     * 菜单样式 1: 平铺,2: 层级菜单, 3: 图片 ,4: 仅链接
     */
    @XStreamAsAttribute
    private Byte menuStyle;

    /**
     *  1:是菜单  0:不是菜单
     */
    @XStreamAsAttribute
    private Byte isMenu;

    /**
     * 状态 1:可用状态  0:删除状态
     */
    @XStreamAsAttribute
    private Byte state;

    /**
     * 创建人ID
     */
    @XStreamAsAttribute
    private Long createBy;

    /**
     * 创建时间
     */
    @XStreamAsAttribute
    private Date createDate;

    /**
     * 修改人ID
     */
    @XStreamAsAttribute
    private Long updateBy;

    /**
     * 修改时间
     */
    @XStreamAsAttribute
    private Date updateDate;
}
