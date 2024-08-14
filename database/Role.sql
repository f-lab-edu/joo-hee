CREATE TABLE "Role" (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(50) UNIQUE NOT NULL,
                        description VARCHAR(255)
);

COMMENT ON TABLE "Role" IS '역할 테이블';
COMMENT ON COLUMN "Role".id IS '역할 ID';
COMMENT ON COLUMN "Role".name IS '역할 이름 (예: ADMIN, USER)';
COMMENT ON COLUMN "Role".description IS '역할 설명';
