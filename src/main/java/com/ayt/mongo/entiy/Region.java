package com.ayt.mongo.entiy;

import java.util.Date;
import java.util.List;

/**
 * @Auther: ayt
 * @Date: 2018/9/9 21:22
 * @Description: Don't worry ,just try
 */
public class Region {
    /**
     * regionId，区域|区块的业务Id
     */
    private Integer regionId;

    /**
     * 仅区域有，指的区块的Id
     */
    private Integer parentId;

    /**
     * 城市Id
     */
    private Integer cityId;

    /**
     * 计划的Code,
     */
    private String planCode;

    /**
     * 区域|区域的名称
     */
    private String name;

    /**
     * 类型，区块(10) | 区域(20)
     */
    private Byte type;

    /**
     * 状态，
     */
    private Byte status;

    /**
     * 地理坐标信息，仅区域(type=20)有该字段
     */
//    private LBSPolygon space;

    /**
     * 备注说明
     */
    private String remarks;

    /**
     * 生效时间
     */
    private Date effectTime;

    /**
     * 失效时间
     */
    private Date expireTime;

    /**
     * bmCode, 对应区块(type=10)
     */
    private String bmCode;


    /**
     * amCode, 对应区域(type=20)
     */
    private String amCode;

    @Deprecated
    private List<String> bdCodeList;

    /**
     * 点我达送餐渠道维护BD，对应区域(type=20)
     */
    private String maintenanceBD;

    /**
     * 点我达跑腿渠道维护BD
     */
    private String maintenanceBD2;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Date modifyTime;

}
