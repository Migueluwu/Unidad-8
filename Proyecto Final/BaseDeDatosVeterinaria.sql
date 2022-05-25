create database if not exists clinicasVet;
use clinicasVet;
create table if not exists mascota
	(
	codmas int NOT NULL AUTO_INCREMENT,nombre varchar(60), raza varchar(100),telefono varchar(15),descrip varchar(100),codcli int,
	constraint pk_mascota primary key (codmas),
    constraint fk_mascota_clinica foreign key (codcli)
        references clinica(codcli) on delete no action on update cascade
	);
create table if not exists veterinario
	(codvet int NOT NULL AUTO_INCREMENT,nombre varchar(60), apellido varchar(100),domicilio varchar(150),telefono varchar(15),nif varchar(10),codcli int,
    constraint pk_veterinario primary key (codvet),
    constraint fk_veterinario_clinica foreign key (codcli)
        references clinica(codcli) on delete no action on update cascade
    );
create table if not exists clinica
	(codcli int NOT NULL AUTO_INCREMENT,nombre varchar(100),direccion varchar(150), especialidad varchar (50),
    constraint pk_cli primary key (codcli)
    );
    
    
    
    insert into clinica (nombre,direccion,especialidad)
		values 
        ('Clinica veterinaria Mar de Alboran','C/ Alboran nº1', 'perros y gatos'),
        ('Clinica veterinaria Pepito','Av. andalucia nº55','pajaros');
        
        
    insert into veterinario(nombre,apellido,domicilio,telefono,nif,codcli)
		values
        ('Miguel','Martin','C/Huerta nnueva nº50','616499317','09079918',1),
        ('Pepito','Perez','C/Monterroso nº6','666666666','5151551515',2);
    
    insert into mascota (nombre,raza,telefono,descrip,codcli)
		values
        ('bobi','chucho','456789236','perro agresivo',1),
        ('coco','loro','124575675','le falta una pata',2);

    
    
    
    
    
    
    
    
    
    
    
insert into Clientes (nombre,apellido,domicilio,telefono)
	values
    ('Miguel','Martin','C/noseque nº7',616499317),
    ('Lorena', 'Olay','C/ Estoy cansao nº3', 123456789);
    
insert into Producto(descr,precio)
	values
    ('Batidora',24.3),
    ('Teclado mecanico',39.99),
    ('Base de datos de jesus',50);
    
insert into Factura(fecha, codcli, cantidad , codpro , iva)
	values
    ( curdate(),1,1,3,19.5),
    ('2022-5-6',2,3,2,10),
    ( '2021-12-22',1,1,1,21);
    