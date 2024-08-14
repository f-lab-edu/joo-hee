CREATE TABLE "User_Role" (
                             user_id BIGINT NOT NULL,
                             role_id BIGINT NOT NULL,
                             PRIMARY KEY (user_id, role_id),
                             FOREIGN KEY (user_id) REFERENCES "User"(id) ON DELETE CASCADE,
                             FOREIGN KEY (role_id) REFERENCES "Role"(id) ON DELETE CASCADE
);

COMMENT ON TABLE "User_Role" IS '사용자-역할 관계 테이블';
COMMENT ON COLUMN "User_Role".user_id IS '사용자 ID';
COMMENT ON COLUMN "User_Role".role_id IS '역할 ID';
