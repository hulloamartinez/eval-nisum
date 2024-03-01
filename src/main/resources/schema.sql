CREATE TABLE IF NOT EXISTS credenciales_autenticacion (
    id UUID PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS usuario (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN NOT NULL,
    token VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS phone (
    id UUID PRIMARY KEY,
    number VARCHAR(255) NOT NULL,
    citycode VARCHAR(255),
    contrycode VARCHAR(255),
    id_usuario UUID,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id)
);

