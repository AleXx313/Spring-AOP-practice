DROP TABLE IF EXISTS stats;

CREATE TABLE IF NOT EXISTS stats (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    class_name  VARCHAR(250) NOT NULL,
    method_name  VARCHAR(250) NOT NULL,
    time BIGINT NOT NULL,
    timestamp TIMESTAMP NOT NULL
);