INSERT INTO credenciales_autenticacion (id, email, password, nombre) VALUES  
('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'user@users.com', '$2a$10$k5GVTwJ85wwmTRLF4A3la.s7khdpEMV8GXLjLLkZfNtIHVNws6nVG', 'usuario dos')
;

-- Insertar un usuario de ejemplo

-- Insertar un usuario de ejemplo con todos los campos necesarios
INSERT INTO usuario (id, name, email, password, is_active, token, created, modified, last_login) VALUES 
('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Usuario Prueba', 'usuario@ejemplo.com', 'contraseña-codificada', TRUE, 'token-de-ejemplo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- Insertar un teléfono de ejemplo asociado al usuario
INSERT INTO phone (id, number, citycode, contrycode, id_usuario) VALUES 
('d3b07384-d113-4ec6-9e33-7f56778f0b6a', '12345678', '1', '57', 'f47ac10b-58cc-4372-a567-0e02b2c3d479');


