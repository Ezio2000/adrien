package org.adrien.mocker.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Xieningjun
 * @date 2023/6/11 22:15
 * @description mocker信号
 */
@Data
public class MockerSign {

    @TableId(type = IdType.AUTO)
    private Integer id;

}
