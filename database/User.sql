CREATE TABLE "User" (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        social_provider VARCHAR(50),
                        social_id VARCHAR(255) UNIQUE,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE "User" IS '사용자 테이블';
COMMENT ON COLUMN "User".id IS 'ID';
COMMENT ON COLUMN "User".name IS '이름';
COMMENT ON COLUMN "User".email IS 'email';
COMMENT ON COLUMN "User".social_provider IS '소셜 로그인 제공자';
COMMENT ON COLUMN "User".social_id IS '소셜 로그인 계정 ID';
COMMENT ON COLUMN "User".created_at IS '생성일시';
COMMENT ON COLUMN "User".updated_at IS '수정일시';
