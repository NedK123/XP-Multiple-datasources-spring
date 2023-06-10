CREATE TABLE information_schema.sequences
(
    SEQUENCE_NAME VARCHAR(64) NOT NULL,
    LAST_VALUE    BIGINT(20) NOT NULL,
    PRIMARY KEY (SEQUENCE_NAME)
);
