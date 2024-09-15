CREATE TABLE Reservation
(
    id               VARCHAR(255) PRIMARY KEY COMMENT '예약 ID',
    user_id          VARCHAR(255) NOT NULL COMMENT '사용자 ID',
    reservation_date TIMESTAMP    NOT NULL COMMENT '예약 일시',
    status           VARCHAR(50)  NOT NULL COMMENT '예약 상태 (예: pending, confirmed, cancelled)',
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
    FOREIGN KEY (user_id) REFERENCES User (id) ON DELETE CASCADE
);
