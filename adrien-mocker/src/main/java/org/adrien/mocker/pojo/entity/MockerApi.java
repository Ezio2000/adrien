package org.adrien.mocker.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Xieningjun
 * @date 2023/6/10 22:14
 * @description mocker对外api
 */
@Data
public class MockerApi {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 匹配mocker路径
     */
    private String path;

}
