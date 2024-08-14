CREATE TABLE "Payment" (
                           id BIGSERIAL PRIMARY KEY,
                           reservation_id BIGINT NOT NULL,
                           amount NUMERIC(10, 2) NOT NULL,
                           payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           payment_method VARCHAR(50),
                           status VARCHAR(50),
                           FOREIGN KEY (reservation_id) REFERENCES "Reservation"(id) ON DELETE CASCADE
);

COMMENT ON TABLE "Payment" IS '결제 테이블';
COMMENT ON COLUMN "Payment".id IS '결제 ID';
COMMENT ON COLUMN "Payment".reservation_id IS '예약 ID';
COMMENT ON COLUMN "Payment".amount IS '결제 금액';
COMMENT ON COLUMN "Payment".payment_date IS '결제일시';
COMMENT ON COLUMN "Payment".payment_method IS '결제 방법 (예: CARD, CASH)';
COMMENT ON COLUMN "Payment".status IS '결제 상태 (예: paid, refunded)';
