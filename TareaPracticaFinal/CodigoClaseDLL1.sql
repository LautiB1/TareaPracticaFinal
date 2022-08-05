/* USE para usar la base de datos */
USE basetareafinalsql;
/* CREATE TABLE para crear la tabla en la base de datos */
CREATE TABLE usuarios(
id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(45) NOT NULL,
apellido VARCHAR(45) NOT NULL,
email VARCHAR(45) NOT NULL,
telefono VARCHAR(45) NOT NULL);

/* SELECT * FROM para ver el contenido de la tabla */
 SELECT * FROM usuarios;

