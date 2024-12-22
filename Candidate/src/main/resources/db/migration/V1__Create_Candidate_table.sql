CREATE TABLE candidate
(
   id               BIGINT                                    NOT NULL AUTO_INCREMENT,
   name             VARCHAR(100)                              NOT NULL,
   lastname         VARCHAR(100)                              NOT NULL,
   email            VARCHAR(120)                              NOT NULL,
   phone_number     VARCHAR(50)                               NOT NULL,
   gender           VARCHAR(1)                                NOT NULL,
   salary_expected  VARCHAR(20)                               NOT NULL,
   created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
   updated_at       TIMESTAMP ,
   CONSTRAINT pk_candidate PRIMARY KEY (id)
);