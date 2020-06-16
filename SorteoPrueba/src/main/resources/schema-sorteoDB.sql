drop table if exists persona;
drop table if exists premio;

create table premio(
    codigo int primary key auto_increment,
    nombre varchar(200) not  null,
    cantidad int not null
);

insert into premio
(codigo,nombre,cantidad) values
(1,'Balón Blanco',10),
(2,'Balón Negro',4),
(3,'Dulce Blanco',5);

create table persona(
    id int primary key auto_increment,
    nro_documento varchar(10) not null,
    tipo_documento varchar(10) not null,
    nombres varchar(300) not null,
    apellidos varchar(300) not null,
    fecha_nacimiento varchar(20),
    premio_codigo int
);

alter table persona
add foreign key (premio_codigo) references premio(codigo);

ALTER TABLE persona
ADD CONSTRAINT uk_nro_documento UNIQUE (nro_documento);
