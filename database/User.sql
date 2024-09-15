CREATE TABLE User
(
    user_id         VARCHAR(255) PRIMARY KEY COMMENT 'ID',
    name            VARCHAR(255)        NOT NULL COMMENT '이름',
    email           VARCHAR(255) UNIQUE NOT NULL COMMENT 'email',
    social_provider VARCHAR(50) COMMENT '소셜 로그인 제공자',
    social_id       VARCHAR(255) UNIQUE COMMENT '소셜 로그인 계정 ID',
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    deleted_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '삭제일시'
);
