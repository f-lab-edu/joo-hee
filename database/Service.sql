CREATE TABLE "Service" (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           description TEXT,
                           price NUMERIC(10, 2) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE "Service" IS '서비스 테이블';
COMMENT ON COLUMN "Service".id IS '서비스 ID';
COMMENT ON COLUMN "Service".name IS '서비스명';
COMMENT ON COLUMN "Service".description IS '서비스 설명';
COMMENT ON COLUMN "Service".price IS '가격';
COMMENT ON COLUMN "Service".created_at IS '생성일시';
COMMENT ON COLUMN "Service".updated_at IS '수정일시';
