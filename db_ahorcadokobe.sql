DROP DATABASE IF EXISTS db_ahorcadokobe;
CREATE DATABASE db_ahorcadokobe;

-- Usar la base de datos
USE db_ahorcadokobe;

-- Crear tabla de usuarios
CREATE TABLE useer (
  user_code INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(40) NOT NULL,
  user_password VARCHAR(10) NOT NULL,
  CONSTRAINT pk_user_code PRIMARY KEY (user_code)
);

-- Crear tabla de palabras
CREATE TABLE words (
  code_word INT NOT NULL AUTO_INCREMENT,
  word VARCHAR(255) NOT NULL,
  hint VARCHAR(100),
  CONSTRAINT pk_code_word PRIMARY KEY (code_word)
);

-- Procedimiento para agregar usuario
DELIMITER $$
CREATE PROCEDURE sp_AddUser(
  IN p_user_name VARCHAR(40),
  IN p_user_password VARCHAR(10)
)
BEGIN
  INSERT INTO useer(user_name, user_password)
  VALUES (p_user_name, p_user_password);
END$$
DELIMITER ;

-- Procedimiento para agregar palabra
DELIMITER $$
CREATE PROCEDURE sp_AddWord(
  IN p_word VARCHAR(20),
  IN p_hint VARCHAR(100)
)
BEGIN
  INSERT INTO words(word, hint)
  VALUES (p_word, p_hint);
END$$
DELIMITER ;

select * from useer;
select * from words;

CALL sp_AddUser('joshua', 'abc123');
CALL sp_AddUser('maria', 'pass001');
CALL sp_AddUser('carlos', 'clave12');
CALL sp_AddUser('sofia', 'key999');
CALL sp_AddUser('andres', 'qwe123');
CALL sp_AddUser('valeria', 'asd456');
CALL sp_AddUser('ricardo', 'zxc789');
CALL sp_AddUser('camila', 'lol321');
CALL sp_AddUser('fernando', 'uno111');
CALL sp_AddUser('diana', 'dos222');
CALL sp_AddUser('roberto', 'tres33');
CALL sp_AddUser('lucia', 'cuatro4');
CALL sp_AddUser('sebastian', 'cinco55');
CALL sp_AddUser('paola', 'seis666');
CALL sp_AddUser('gabriel', 'siete77');
CALL sp_AddUser('karla', 'ocho888');
CALL sp_AddUser('mateo', 'nueve99');
CALL sp_AddUser('alejandro', 'clave77');
CALL sp_AddUser('angelica', 'pass999');
CALL sp_AddUser('antonio', 'qaz123');
CALL sp_AddUser('beatriz', 'wsx456');
CALL sp_AddUser('victor', 'edc789');
CALL sp_AddUser('juana', 'rfv147');
CALL sp_AddUser('ignacio', 'tgb258');
CALL sp_AddUser('renata', 'yhn369');
CALL sp_AddUser('daniel', 'ujm741');
CALL sp_AddUser('elena', 'ikn852');
CALL sp_AddUser('oscar', 'olp963');
CALL sp_AddUser('soledad', 'plm159');
CALL sp_AddUser('hernan', 'bgt753');

CALL sp_AddWord('baloncesto', 'Deporte con aro y balón');
CALL sp_AddWord('computador', 'Máquina para procesar datos');
CALL sp_AddWord('programar', 'Escribir código en un lenguaje');
CALL sp_AddWord('teclado', 'Dispositivo para escribir');
CALL sp_AddWord('auriculares', 'Se usan para escuchar música');
CALL sp_AddWord('mariposas', 'Insectos con alas de colores');
CALL sp_AddWord('elefantes', 'Animales grandes con trompa');
CALL sp_AddWord('serpiente', 'Reptil que se arrastra');
CALL sp_AddWord('astronauta', 'Viaja al espacio exterior');
CALL sp_AddWord('bicicleta', 'Vehículo de dos ruedas');
CALL sp_AddWord('cafetera', 'Aparato para hacer café');
CALL sp_AddWord('noticiero', 'Programa que informa sucesos');
CALL sp_AddWord('universo', 'Todo lo que existe');
CALL sp_AddWord('futbolista', 'Persona que juega fútbol');
CALL sp_AddWord('medicina', 'Ciencia de la salud');
CALL sp_AddWord('relojero', 'Persona que arregla relojes');
CALL sp_AddWord('carniceria', 'Lugar donde venden carne');
CALL sp_AddWord('panaderia', 'Lugar donde venden pan');
CALL sp_AddWord('heladeros', 'Venden postres fríos');
CALL sp_AddWord('farmaceutico', 'Trabaja en una farmacia');
