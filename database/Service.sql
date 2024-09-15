CREATE TABLE Service
(
    service_id   VARCHAR(255) PRIMARY KEY COMMENT '서비스 ID',
    title        VARCHAR(255)   NOT NULL COMMENT '서비스명',
    description  TEXT COMMENT '서비스 설명',
    location_lat LONG COMMENT 'latitude',
    location_lng LONG COMMENT 'longitude',
    price        DECIMAL(10, 2) NOT NULL COMMENT '가격',
    capacity     INT COMMENT '수용량',
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    deleted_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '삭제일시'
);
