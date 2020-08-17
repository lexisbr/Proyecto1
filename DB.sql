CREATE SCHEMA IF NOT EXISTS INTELAF;
USE INTELAF;

CREATE TABLE IF NOT EXISTS TIENDA(
codigo VARCHAR(45) NOT NULL,
nombre VARCHAR(45) NOT NULL,
direccion VARCHAR(45) NOT NULL,
telefono_1 VARCHAR(15) NOT NULL,
telefono_2 VARCHAR(15),
email VARCHAR(45),
horario VARCHAR(45),
PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS PRODUCTO(
codigo VARCHAR(45) NOT NULL,
nombre VARCHAR(45) NOT NULL,
fabricante VARCHAR(45) NOT NULL,
cantidad INT NOT NULL,
precio FLOAT NOT NULL,
descripcion VARCHAR(200),
garantia INT,
codigo_tienda VARCHAR(45) NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigo_tienda) REFERENCES TIENDA(codigo)
);

CREATE TABLE IF NOT EXISTS CLIENTE(
NIT VARCHAR(13) NOT NULL,
nombre VARCHAR(45) NOT NULL,
telefono VARCHAR(45) NOT NULL,
DPI VARCHAR(13),
email VARCHAR(45),
direccion VARCHAR(45),
credito_compra FLOAT,
PRIMARY KEY(NIT)
);

CREATE TABLE IF NOT EXISTS TIEMPO_DE_ENVIO(
ID INT NOT NULL AUTO_INCREMENT,
tienda_destino VARCHAR(45) NOT NULL,
tiempo INT NOT NULL,
codigo_tienda VARCHAR(45) NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(codigo_tienda) REFERENCES TIENDA(codigo)
);

CREATE TABLE IF NOT EXISTS EMPLEADO(
codigo VARCHAR(45),
nombre VARCHAR(45) NOT NULL,
telefono VARCHAR(45) NOT NULL,
NIT VARCHAR(13) NOT NULL,
DPI VARCHAR(13) NOT NULL,
email VARCHAR(45) NOT NULL,
direccion VARCHAR(45) NOT NULL,
PRIMARY KEY(codigo)
);

CREATE TABLE IF NOT EXISTS FACTURA(
codigo INT NOT NULL AUTO_INCREMENT,
fecha DATE NOT NULL,
total FLOAT NOT NULL,
codigo_tienda VARCHAR(45) NOT NULL,
nit_cliente VARCHAR(13) NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigo_tienda) REFERENCES TIENDA(codigo),
FOREIGN KEY(nit_cliente) REFERENCES CLIENTE(NIT)
);

CREATE TABLE IF NOT EXISTS VENTA(
ID INT NOT NULL AUTO_INCREMENT,
precio FLOAT NOT NULL,
cantidad INT NOT NULL,
codigo_producto VARCHAR(45) NOT NULL,
codigo_factura INT NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(codigo_factura) REFERENCES FACTURA(codigo),
FOREIGN KEY(codigo_producto) REFERENCES PRODUCTO(codigo)
);

CREATE TABLE IF NOT EXISTS PEDIDO(
codigo INT NOT NULL AUTO_INCREMENT,
fecha DATE NOT NULL,
cantidad INT NOT NULL,
total FLOAT NOT NULL,
anticipo FLOAT NOT NULL,
codigo_producto VARCHAR(45) NOT NULL,
nit_cliente VARCHAR(13) NOT NULL,
codigo_tienda VARCHAR(45) NOT NULL,
codigo_tiempo_de_envio INT NOT NULL,
PRIMARY KEY(codigo),
FOREIGN KEY(codigo_producto) REFERENCES PRODUCTO(codigo),
FOREIGN KEY(nit_cliente) REFERENCES CLIENTE(NIT),
FOREIGN KEY(codigo_tienda) REFERENCES TIENDA(codigo),
FOREIGN KEY(codigo_tiempo_de_envio) REFERENCES TIEMPO_DE_ENVIO(ID)
);

CREATE TABLE IF NOT EXISTS RECIBE(
ID INT NOT NULL AUTO_INCREMENT,
fecha_entrega DATE NOT NULL,
codigo_tienda VARCHAR(45) NOT NULL,
codigo_pedido INT NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(codigo_tienda) REFERENCES TIENDA(codigo),
FOREIGN KEY(codigo_pedido) REFERENCES PEDIDO(codigo)
);




