package org.adrien.mocker.pojo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.adrien.mocker.pojo.entity.MockerApi;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Xieningjun
 * @date 2023/6/10 22:22
 * @description mocker对外api数据库连接
 */
@Mapper
public interface MockerApiMapper extends BaseMapper<MockerApi> {
}
