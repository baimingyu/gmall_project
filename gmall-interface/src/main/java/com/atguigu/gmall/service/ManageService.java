package com.atguigu.gmall.service;

import com.auguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {

    List<BaseCatalog1> getBaseCatalog1();
    List<BaseCatalog2> getBaseCatalog2(String catalog1Id);
    List<BaseCatalog3> getBaseCatalog3(String catalog2Id);
    List<BaseAttrInfo> getBaseAttrInfo(String catalog3Id);

    /**
     * 添加和修改平台属性
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     *修改平台属性 1.回显
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(String attrId);

    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    /**
     * 获取所有基础销售属性
     * @return
     */
    List<BaseSaleAttr> getBaseSaleAttrList();

    /**
     * 保存整个spu信息
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);
}
