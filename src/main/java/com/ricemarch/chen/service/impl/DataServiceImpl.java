package com.ricemarch.chen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.chen.entity.CData;
import com.ricemarch.chen.mapper.DataMapper;
import com.ricemarch.chen.service.DataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ricemarch.chen.vo.DataPageVo;
import com.ricemarch.chen.vo.DataVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 数据表 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, CData> implements DataService {

    @Autowired
    DataMapper dataMapper;

    @Override
    public List<DataVo> listByDataVo(DataPageVo dataPageVo) {
        String hash = dataPageVo.getHash();
        String send = dataPageVo.getSend();
        String rece = dataPageVo.getRece();
        String name = dataPageVo.getName();
        QueryWrapper<CData> queryWrapper = new QueryWrapper<>();
        if (hash != null) {
            queryWrapper.eq("hash", hash);
        }
        if (send != null) {
            queryWrapper.eq("send", send);
        }
        if (rece != null) {
            queryWrapper.eq("rece", rece);
        }
        if (name != null) {
            queryWrapper.eq("name", name);
        }
        List<CData> cData = dataMapper.selectList(queryWrapper);
        List<DataVo> dataVos = new ArrayList<>();
        for (CData cDatum : cData) {
            DataVo dataVo = new DataVo();
            BeanUtils.copyProperties(cDatum, dataVo);
            dataVos.add(dataVo);
        }
        return dataVos;
    }

    @Override
    public List<DataVo> listByLink(Long id) {
        List<DataVo> cDataList = new ArrayList<>();
        CData cData = dataMapper.selectById(id);
        QueryWrapper<CData> queryWrapper = new QueryWrapper<>();
        DataVo dataVo = new DataVo();
        BeanUtils.copyProperties(cData, dataVo);
        cDataList.add(dataVo);
        CData cDataw = cData;
        while (null != cDataw.getPreviousHash()) {
            DataVo dataVow = new DataVo();
            //通过查找前一项hash 找到关联
            queryWrapper.eq("hash", cDataw.getPreviousHash());
            cDataw = dataMapper.selectOne(queryWrapper);
            if (cDataw == null) {
                break;
            }
            BeanUtils.copyProperties(cDataw, dataVow);
            cDataList.add(dataVow);
            queryWrapper.clear();
        }
        return cDataList;
    }
}
