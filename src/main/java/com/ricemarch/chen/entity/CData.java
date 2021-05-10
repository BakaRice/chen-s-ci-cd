package com.ricemarch.chen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据表
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("data")
public class CData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 数据记录id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 当前hash值
     */
    private String hash;

    /**
     * 前hash值
     */
    private String previousHash;

    private String send;

    private String rece;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修人
     */
    private String updateBy;

    /**
     * 是否已经删除
     */
    private Integer isDelete;


}
