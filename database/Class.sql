CREATE TABLE "Class" (
                         id BIGSERIAL PRIMARY KEY,
                         service_id BIGINT NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         description TEXT,
                         start_time TIMESTAMP NOT NULL,
                         end_time TIMESTAMP NOT NULL,
                         location VARCHAR(255),
                         capacity INT NOT NULL,
                         instructor_id BIGINT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (service_id) REFERENCES "Service"(id) ON DELETE CASCADE,
                         FOREIGN KEY (instructor_id) REFERENCES "Instructor"(id) ON DELETE SET NULL
);

COMMENT ON TABLE "Class" IS '특정 서비스와 관련된 클래스(세션)의 정보를 저장하는 테이블';
COMMENT ON COLUMN "Class".id IS '클래스 ID';
COMMENT ON COLUMN "Class".service_id IS '서비스 ID';
COMMENT ON COLUMN "Class".title IS '제목';
COMMENT ON COLUMN "Class".description IS '설명';
COMMENT ON COLUMN "Class".start_time IS '시작 시간';
COMMENT ON COLUMN "Class".end_time IS '종료 시간';
COMMENT ON COLUMN "Class".location IS '장소';
COMMENT ON COLUMN "Class".capacity IS '수용 인원';
COMMENT ON COLUMN "Class".instructor_id IS '강사 ID';
COMMENT ON COLUMN "Class".created_at IS '생성일시';
COMMENT ON COLUMN "Class".updated_at IS '수정일시';
