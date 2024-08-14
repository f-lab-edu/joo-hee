CREATE TABLE "Instructor" (
                              id BIGSERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              bio TEXT,
                              contact_info VARCHAR(255),
                              photo_url VARCHAR(255),
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE "Instructor" IS '강사 테이블';
COMMENT ON COLUMN "Instructor".id IS '강사 ID';
COMMENT ON COLUMN "Instructor".name IS '강사명';
COMMENT ON COLUMN "Instructor".bio IS '강사 소개';
COMMENT ON COLUMN "Instructor".contact_info IS '연락처';
COMMENT ON COLUMN "Instructor".photo_url IS '프로필 사진 URL';
COMMENT ON COLUMN "Instructor".created_at IS '생성일시';
COMMENT ON COLUMN "Instructor".updated_at IS '수정일시';
