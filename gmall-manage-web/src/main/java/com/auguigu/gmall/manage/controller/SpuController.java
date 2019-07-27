package com.auguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.service.ManageService;
import com.auguigu.gmall.bean.BaseSaleAttr;
import com.auguigu.gmall.bean.SpuInfo;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class SpuController {
    @Reference
    private ManageService manageService;

    @Value("${fileServer.url}")
    private String url;

    @RequestMapping("spuList")
    public List<SpuInfo> getspuList(String catalog3Id){
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
        return manageService.getSpuList(spuInfo);
    }

    @RequestMapping("fileUpload")
    public String fileUpload(MultipartFile file) throws IOException, MyException {
        String imgUrl = url;
        if(file !=null){
            String fileUpLoad = this.getClass().getResource("/tracker.conf").getFile();
            ClientGlobal.init(fileUpLoad);
            TrackerClient trackerClient=new TrackerClient();
            TrackerServer trackerServer=trackerClient.getConnection();
            StorageClient storageClient=new StorageClient(trackerServer,null);
            String originalFilename = file.getOriginalFilename();
            String exName = StringUtils.substringAfterLast(originalFilename, ".");
            String[] upload_file = storageClient.upload_file(file.getBytes(), exName, null);
            for (int i = 0; i < upload_file.length; i++) {
                String s = upload_file[i];
                imgUrl+="/"+s;
            }
        }
        return imgUrl;
    }

    /**
     * 获取所有基础销售属性
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    public List<BaseSaleAttr> getBaseSaleAttrList(){
        return manageService.getBaseSaleAttrList();
    }

    /**
     * 保存整个SpuInfo信息
     */
    @RequestMapping("saveSpuInfo")
    public void saveSpuInfo(@RequestBody SpuInfo spuInfo){
        manageService.saveSpuInfo(spuInfo);
    }

}
