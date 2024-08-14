CREATE TABLE "Notification" (
                                id BIGSERIAL PRIMARY KEY,
                                user_id BIGINT NOT NULL,
                                type VARCHAR(50) NOT NULL,
                                message TEXT NOT NULL,
                                status VARCHAR(50) DEFAULT 'PENDING',
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                sent_at TIMESTAMP,
                                FOREIGN KEY (user_id) REFERENCES "User"(id) ON DELETE CASCADE
);

COMMENT ON TABLE "Notification" IS '알림 테이블';
COMMENT ON COLUMN "Notification".id IS '알림 ID';
COMMENT ON COLUMN "Notification".user_id IS '사용자 ID';
COMMENT ON COLUMN "Notification".type IS '알림 타입 (예: EMAIL, SMS, PUSH)';
COMMENT ON COLUMN "Notification".message IS '알림 내용';
COMMENT ON COLUMN "Notification".status IS '알림 상태 (예: PENDING, SENT, FAILED)';
COMMENT ON COLUMN "Notification".created_at IS '생성일시';
COMMENT ON COLUMN "Notification".sent_at IS '발송일시';
