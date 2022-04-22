DROP DATABASE segundoparcial;
CREATE DATABASE segundoparcial;
USE segundoparcial;
CREATE TABLE bodegas

CREATE TABLE lineas
(
	codigo_linea VARCHAR(5) PRIMARY KEY,
    nombre_linea VARCHAR(60),
    estatus_linea VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE marcas
(
	codigo_marca VARCHAR(5) PRIMARY KEY,
    nombre_marca VARCHAR(60),
    estatus_marca VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE productos
(
	codigo_producto VARCHAR(18) PRIMARY KEY,
    nombre_producto VARCHAR(60),
    codigo_linea VARCHAR(5),
    codigo_marca VARCHAR(5),
    estatus_producto VARCHAR(1),
    FOREIGN KEY (codigo_linea) REFERENCES lineas(codigo_linea),
    FOREIGN KEY (codigo_marca) REFERENCES marcas(codigo_marca)
) ENGINE=INNODB DEFAULT CHARSET=latin1;
CREATE TABLE existencias
(

CREATE TABLE vendedores
(
	codigo_vendedor VARCHAR(5) PRIMARY KEY,
    nombre_vendedor VARCHAR(60),
    direccion_vendedor VARCHAR(60),
    telefono_vendedor VARCHAR(50),
    nit_vendedor VARCHAR(20),
    estatus_vendedor VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE clientes
(
	codigo_cliente VARCHAR(5) PRIMARY KEY,
    nombre_cliente VARCHAR(60),
    direccion_cliente VARCHAR(60),
    nit_cliente VARCHAR(20),
    telefono_cliente VARCHAR(50),
    codigo_vendedor VARCHAR(5),
    estatus_cliente VARCHAR(1),
    FOREIGN KEY (codigo_vendedor) REFERENCES vendedores(codigo_vendedor)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE proveedores
(
	codigo_proveedor VARCHAR(5) PRIMARY KEY,
    nombre_proveedor VARCHAR(60),
    direccion_proveedor VARCHAR(60),
    telefono_proveedor VARCHAR(50),
    nit_proveedor VARCHAR(50),
    estatus_proveedor VARCHAR(1)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

    