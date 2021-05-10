package com.ricemarch.chen.service;

import com.ricemarch.chen.entity.CData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ricemarch.chen.vo.DataPageVo;
import com.ricemarch.chen.vo.DataVo;

import java.util.List;

/**
 * <p>
 * 数据表 服务类
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
public interface DataService extends IService<CData> {

    List<DataVo> listByDataVo(DataPageVo dataPageVo);

    List<DataVo> listByLink(Long id);
}
