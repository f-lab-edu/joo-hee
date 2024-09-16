CREATE TABLE Reservation_Service
(
    reservation_id VARCHAR(255)   NOT NULL COMMENT '예약 ID',
    service_id     VARCHAR(255)   NOT NULL COMMENT '서비스 ID',
    quantity       INT            NOT NULL COMMENT '수량',
    price          DECIMAL(10, 2) NOT NULL COMMENT '단가',
    total_price    DECIMAL(10, 2) GENERATED ALWAYS AS (quantity * price) VIRTUAL COMMENT '총 가격 (수량 * 단가)',
    PRIMARY KEY (reservation_id, service_id),
    FOREIGN KEY (reservation_id) REFERENCES Reservation (id) ON DELETE CASCADE,
    FOREIGN KEY (service_id) REFERENCES Service (id) ON DELETE CASCADE
);
