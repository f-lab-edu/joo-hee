CREATE TABLE "Reservation_Service" (
                                       reservation_id BIGINT NOT NULL,
                                       service_id BIGINT NOT NULL,
                                       class_id BIGINT,
                                       quantity INT NOT NULL,
                                       price NUMERIC(10, 2) NOT NULL,
                                       total_price NUMERIC(10, 2) GENERATED ALWAYS AS (quantity * price) STORED,
                                       PRIMARY KEY (reservation_id, service_id, class_id),
                                       FOREIGN KEY (reservation_id) REFERENCES "Reservation"(id) ON DELETE CASCADE,
                                       FOREIGN KEY (service_id) REFERENCES "Service"(id) ON DELETE CASCADE,
                                       FOREIGN KEY (class_id) REFERENCES "Class"(id) ON DELETE SET NULL
);

COMMENT ON TABLE "Reservation_Service" IS '예약 서비스 관계 테이블';
COMMENT ON COLUMN "Reservation_Service".reservation_id IS '예약 ID';
COMMENT ON COLUMN "Reservation_Service".service_id IS '서비스 ID';
COMMENT ON COLUMN "Reservation_Service".class_id IS '클래스 ID';
COMMENT ON COLUMN "Reservation_Service".quantity IS '수량';
COMMENT ON COLUMN "Reservation_Service".price IS '단가';
COMMENT ON COLUMN "Reservation_Service".total_price IS '총 가격 (수량 * 단가)';
