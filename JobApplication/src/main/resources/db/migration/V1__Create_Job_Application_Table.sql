CREATE TABLE job_application
(
   id               BIGINT                                    NOT NULL AUTO_INCREMENT,
   vacancy_id       BIGINT                                    NOT NULL,
    candidate_id     BIGINT                                    NOT NULL,
    status           ENUM ('APPLIED', 'INVITED', 'REJECTED', 'HIRED') NOT NULL,
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
   created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
   updated_at       TIMESTAMP ,
   CONSTRAINT pk_candidate PRIMARY KEY (id)
);