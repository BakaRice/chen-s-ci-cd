package com.ricemarch.chen.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author RiceMarch
 * @date 2021/5/10 22:52
 */
@Data
@Accessors(chain = true)
public class LinkDataPageVo {
    private Long id;
    private String hash;
    private String send;
    private String rece;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String createBy;
    private String updateBy;

    private int pageSize;
    private int pageNum;
}