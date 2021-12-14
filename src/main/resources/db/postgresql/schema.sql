CREATE TABLE IF NOT EXISTS specialties
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS vets
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(30),
    description  VARCHAR(255),
    member_id    integer,
    specialty_id integer,
    FOREIGN KEY (specialty_id) REFERENCES specialties (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS owners
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(30),
    member_id   integer
);

CREATE TABLE IF NOT EXISTS pets
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    type       VARCHAR(20) NOT NULL,
    owner_id   integer
);

CREATE TABLE IF NOT EXISTS visits
(
    id          SERIAL PRIMARY KEY,
    pet_id      integer NOT NULL,
    vet_id      integer NOT NULL,
    visit_date  DATE,
    description VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES pets (id) ON DELETE CASCADE,
    FOREIGN KEY (vet_id) REFERENCES vets (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS treatments
(
    id           SERIAL PRIMARY KEY,
    visit_id     integer NOT NULL,
    vet_id       integer NOT NULL,
    description  VARCHAR(255),
    prescription VARCHAR(255),
    FOREIGN KEY (visit_id) REFERENCES visits (id) ON DELETE CASCADE,
    FOREIGN KEY (vet_id) REFERENCES vets (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS members
(
    id        SERIAL PRIMARY KEY,
    username  VARCHAR(30)  NOT NULL,
    password  VARCHAR(255) NOT NULL,
    email     VARCHAR(30)  NOT NULL,
    role_name VARCHAR(30)  NOT NULL
);

SELECT setval(pg_get_serial_sequence('vets', 'id'), coalesce(max(id), 0) + 1, false)
FROM vets;
SELECT setval(pg_get_serial_sequence('specialties', 'id'), coalesce(max(id), 0) + 1, false)
FROM specialties;
SELECT setval(pg_get_serial_sequence('owners', 'id'), coalesce(max(id), 0) + 1, false)
FROM owners;
SELECT setval(pg_get_serial_sequence('pets', 'id'), coalesce(max(id), 0) + 1, false)
FROM pets;
SELECT setval(pg_get_serial_sequence('visits', 'id'), coalesce(max(id), 0) + 1, false)
FROM visits;
SELECT setval(pg_get_serial_sequence('treatments', 'id'), coalesce(max(id), 0) + 1, false)
FROM treatments;
SELECT setval(pg_get_serial_sequence('members', 'id'), coalesce(max(id), 0) + 1, false)
FROM members;

