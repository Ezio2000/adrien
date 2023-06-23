package org.adrien.mocker.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Xieningjun
 * @date 2023/6/10 22:26
 * @description mocker
 */
@Data
public class Mocker {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * mockApi的aid
     */
    private String mockerApiPath;

    /**
     * 延迟
     */
    private Integer delay;

    /**
     * 请求信号
     */
    private String reqSign;

    /**
     * 响应数据
     */
    private String resData;

}
