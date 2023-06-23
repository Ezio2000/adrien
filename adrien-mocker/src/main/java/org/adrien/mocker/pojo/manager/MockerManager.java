package org.adrien.mocker.pojo.manager;

import lombok.Getter;
import org.adrien.mocker.pojo.entity.Mocker;
import org.adrien.mocker.pojo.entity.MockerApi;
import org.adrien.mocker.pojo.mapper.MockerApiMapper;
import org.adrien.mocker.pojo.mapper.MockerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xieningjun
 * @date 2023/6/11 1:18
 * @description mocker缓存管理器
 */
@Component
public class MockerManager {

    @Autowired
    private MockerApiMapper mockerApiMapper;

    @Autowired
    private MockerMapper mockerMapper;

    @Getter
    private final Map<String, MockerApi> mockerApiMap = new HashMap<>();

    @Getter
    private final List<Mocker> mockerList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.load();
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void refresh() {
        this.load();
    }

    private void load() {
        this.loadMockerApi();
        this.loadMocker();
    }

    private void loadMockerApi() {
        List<MockerApi> mockerApiList = mockerApiMapper.selectList(null);
        for (MockerApi mockerApi : mockerApiList) {
            this.mockerApiMap.put(mockerApi.getPath(), mockerApi);
        }
    }

    private void loadMocker() {
        List<Mocker> mockerList = mockerMapper.selectList(null);
        this.mockerList.clear();
        this.mockerList.addAll(mockerList);
    }

}














