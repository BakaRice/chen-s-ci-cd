package com.ricemarch.chen.controller;


import com.github.pagehelper.PageInfo;
import com.ricemarch.chen.service.DataService;
import com.ricemarch.chen.vo.DataPageVo;
import com.ricemarch.chen.vo.DataVo;
import com.ricemarch.chen.vo.LinkDataPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 数据表 前端控制器
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/chen/data")
public class DataController {

    @Autowired
    DataService dataService;

    //条件查询所有
    @PostMapping
    public PageInfo<DataVo> list(@RequestBody DataPageVo dataPageVo) {
        String hash = dataPageVo.getHash();
        String send = dataPageVo.getSend();
        String rece = dataPageVo.getRece();
        String name = dataPageVo.getName();

        int pageNum = dataPageVo.getPageNum();
        int pageSize = dataPageVo.getPageSize();

        List<DataVo> dataVoList = dataService.listByDataVo(dataPageVo);

        PageInfo<DataVo> dataVoPageInfo = new PageInfo<>(dataVoList);
        dataVoPageInfo.setStartRow(pageNum);
        dataVoPageInfo.setPageSize(pageSize);

        return dataVoPageInfo;
    }

    //    单个递归查询
    @PostMapping("/link")
    public PageInfo<DataVo> listLink(@RequestBody LinkDataPageVo linkDataPageVo) {
        Long id = linkDataPageVo.getId();
        int pageNum = linkDataPageVo.getPageNum();
        int pageSize = linkDataPageVo.getPageSize();
        List<DataVo> dataVoList = dataService.listByLink(id);
        PageInfo<DataVo> linkPageInfoList = new PageInfo<>(dataVoList);
        linkPageInfoList.setStartRow(pageNum);
        linkPageInfoList.setPageSize(pageSize);

        return linkPageInfoList;
    }

}

