CREATE TABLE "Audit" (
                         id BIGSERIAL PRIMARY KEY,
                         user_id BIGINT NOT NULL,
                         action VARCHAR(255) NOT NULL,
                         details TEXT,
                         timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES "User"(id) ON DELETE CASCADE
);

COMMENT ON TABLE "Audit" IS '사용자의 활동 기록을 저장하는 테이블';
COMMENT ON COLUMN "Audit".id IS '활동 기록 ID';
COMMENT ON COLUMN "Audit".user_id IS '사용자 ID';
COMMENT ON COLUMN "Audit".action IS '활동내역 (예: CREATE_RESERVATION, CANCEL_RESERVATION)';
COMMENT ON COLUMN "Audit".details IS '상세 정보';
COMMENT ON COLUMN "Audit".timestamp IS '발생일시';

