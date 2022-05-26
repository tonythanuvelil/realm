--
-- Houses
--
CREATE SEQUENCE IF NOT EXISTS house_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE houses (
   id BIGINT NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
   updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
   name VARCHAR(255),
   words VARCHAR(255),
   established date,
   person_id BIGINT,
   CONSTRAINT pk_houses PRIMARY KEY (id)
);

--
-- Person
--
CREATE SEQUENCE IF NOT EXISTS person_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE persons (
   id BIGINT NOT NULL,
   created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
   updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255),
   house_id BIGINT,
   dob date NOT NULL,
   status VARCHAR(255),
   CONSTRAINT pk_persons PRIMARY KEY (id)
);

ALTER TABLE houses ADD CONSTRAINT uc_houses_name UNIQUE (name);

ALTER TABLE houses ADD CONSTRAINT FK_HOUSES_ON_PERSON FOREIGN KEY (person_id) REFERENCES persons (id);

ALTER TABLE persons ADD CONSTRAINT uc_persons_email UNIQUE (email);

ALTER TABLE persons ADD CONSTRAINT FK_PERSONS_ON_HOUSE FOREIGN KEY (house_id) REFERENCES houses (id);