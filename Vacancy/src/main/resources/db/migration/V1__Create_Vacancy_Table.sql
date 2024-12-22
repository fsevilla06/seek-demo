CREATE TABLE vacancy
(
   id               BIGINT                                    NOT NULL AUTO_INCREMENT,
   name             VARCHAR(100)                              NOT NULL,
   company         VARCHAR(100)                              NOT NULL,
   email            VARCHAR(120)                              NOT NULL,
   description     VARCHAR(1000)                               NOT NULL,
   status           VARCHAR(10)                                NOT NULL,
   max_salary_offer  VARCHAR(20)                                    ,
   min_salary_offer  VARCHAR(20)                                        ,
   created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
   updated_at       TIMESTAMP ,
   CONSTRAINT pk_candidate PRIMARY KEY (id)
);