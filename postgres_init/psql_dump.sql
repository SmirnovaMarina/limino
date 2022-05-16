SELECT 'CREATE DATABASE demodb'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'demodb')\gexec

\connect demodb

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS card;

CREATE TABLE IF NOT EXISTS card (
    id UUID NOT NULL PRIMARY KEY,
    description TEXT,
    imagePath VARCHAR(255) NOT NULL,
    tags TEXT NOT NULL
);

INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_meme_study1.jpeg', 'meme, study');
INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_study1.jpg', 'study');
INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_meme1.jpg', 'meme');
INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_life1.jpg', 'life');
INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_life_meme1.jpg', 'life,meme');
INSERT INTO card VALUES (uuid_generate_v4(), 'description', '/images/img_deep1.jpg', 'deep');
