package org.adrien.mocker.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.adrien.mocker.pojo.entity.Mocker;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xieningjun
 * @date 2023/6/10 22:40
 * @description mocker数据库连接
 */
@Mapper
public interface MockerMapper extends BaseMapper<Mocker> {
}
