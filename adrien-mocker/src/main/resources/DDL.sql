create table mocker_api
(
    id   int auto_increment comment '主键id'
        primary key,
    path varchar(50) null comment '匹配mocker路径',
    constraint mocker_path
        unique (path)
)
    comment 'mocker开放api';

create table mocker
(
    id             int auto_increment comment '主键id'
        primary key,
    mocker_api_path varchar(50)             not null comment 'mocker开放api业务aid',
    delay          int                     not null comment '延迟',
    req_sign       varchar(255) default '' not null comment '请求信号',
    res_data       varchar(255) default '' not null comment '响应数据',
    constraint api_and_req_sign
        unique (mocker_api_path, req_sign)
)
    comment 'mocker';