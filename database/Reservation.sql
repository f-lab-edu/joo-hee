CREATE TABLE "Reservation" (
                               id BIGSERIAL PRIMARY KEY,
                               user_id BIGINT NOT NULL,
                               reservation_date TIMESTAMP NOT NULL,
                               status VARCHAR(50) NOT NULL,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (user_id) REFERENCES "User"(id) ON DELETE CASCADE
);

COMMENT ON TABLE "Reservation" IS '예약 테이블';
COMMENT ON COLUMN "Reservation".id IS '예약 ID';
COMMENT ON COLUMN "Reservation".user_id IS '사용자 ID';
COMMENT ON COLUMN "Reservation".reservation_date IS '예약 날짜 및 시간';
COMMENT ON COLUMN "Reservation".status IS '예약 상태 (예: pending, confirmed, cancelled)';
COMMENT ON COLUMN "Reservation".created_at IS '생성일';
COMMENT ON COLUMN "Reservation".updated_at IS '수정일';
