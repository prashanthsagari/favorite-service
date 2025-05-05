drop table favorites;

drop sequence favorites_seq;

CREATE TABLE favorites (
    id NUMBER PRIMARY KEY,
    user_id NUMBER NOT NULL,
    flat_id NUMBER NOT NULL,
    favorited_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


CREATE SEQUENCE favorites_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;


COMMIT;




CREATE TABLE user_flat_favorites (
    id BIGINT auto_increment PRIMARY KEY,
    user_id BIGINT NOT NULL,
    flat_id BIGINT NOT NULL,
    favorited_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);


INSERT INTO user_flat_favorites (user_id, flat_id) VALUES (101, 501);
INSERT INTO user_flat_favorites (user_id, flat_id) VALUES (102, 502);
INSERT INTO user_flat_favorites (user_id, flat_id) VALUES (103, 503);
INSERT INTO user_flat_favorites (user_id, flat_id) VALUES (101, 504);
INSERT INTO user_flat_favorites (user_id, flat_id) VALUES (102, 505);
commit;
select * from user_flat_favorites;