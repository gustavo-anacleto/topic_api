CREATE TABLE topic_api.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE topic_api.courses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);


CREATE TABLE topic_api.topics (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_user BIGINT NOT NULL,
    id_course BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_topic_author FOREIGN KEY (id_user) REFERENCES topic_api.users(id),
    CONSTRAINT fk_topic_course FOREIGN KEY (id_course) REFERENCES topic_api.courses(id)
);

CREATE TABLE topic_api.answers (
    id SERIAL PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_user BIGINT NOT NULL,
    id_topic BIGINT NOT NULL,
    is_solution BOOLEAN,
    CONSTRAINT fk_answers_user FOREIGN KEY (id_user) REFERENCES topic_api.users(id),
    CONSTRAINT fk_answers_topic FOREIGN KEY (id_topic) REFERENCES topic_api.topics(id)
);



