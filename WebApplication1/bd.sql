
CREATE TABLE usuarios(
	id_usuario integer NOT NULL,
	cedula_identidad integer NOT NULL,
	nombre varchar(40) NOT NULL,
	apellido varchar(30),
	fecha_nacimiento date NOT NULL,
	correo varchar(40) NOT NULL,
	telefono_celular integer NOT NULL
);
alter table usuarios
  add constraint pkusuarios primary key (id_usuario);

CREATE TABLE hijos(
	ci_numero integer NOT NULL,
	nombre varchar(30) NOT NULL,
	apellido varchar(30) NOT NULL,
	fecha_nacimiento date NOT NULL,
	lugar_nacimiento varchar(30) NOT NULL,
	sexo boolean NOT NULL,
	nacionalidad varchar(30) NOT NULL,
	direccion varchar(30) NOT NULL,
	departamento varchar(30),
	municipio varchar(30),
	barrio varchar(30),
	referencia_domicilio varchar(30),
	responsable varchar(30) NOT NULL,
	telefono_contacto integer NOT NULL,
	seguro_medico varchar(30),
	alergias varchar(60)
);

alter table hijos
  add constraint pkhijos primary key (ci_numero);
alter table hijos
  add constraint r_usuario foreign key (id_usuario)
  references usuarios (id_usuario);

CREATE TABLE vacuna(
	codigo varchar(10) NOT NULL,
	descripcion varchar(100) NOT NULL,
	estado boolean NOT NULL,
	mes_aplicacion integer NOT NULL,
	dosis varchar(5) NOT NULL,
	unidad_medida varchar(5) NOT NULL,
	obligatorio boolean NOT NULL
);


alter table vacuna
  add constraint pkvacuna primary key (codigo);
 alter table vacuna
  add constraint r_hijo foreign key (ci_numero)
  references hijos (ci_numero);
 
  
CREATE TABLE agenda(
	id_agenda integer NOT NULL,
	fecha_agendada date NOT NULL,
	hora_agendada time NOT NULL,
	cedula_vacunante integer NOT NULL
);
alter table agenda
  add constraint pkagenda primary key (id_agenda);

alter table agenda
  add constraint r_hijos foreign key (ci_numero)
  references hijos (ci_numero);
  
alter table agenda
  add constraint r_vacuna foreign key (codigo)
  references vacuna (codigo);
  