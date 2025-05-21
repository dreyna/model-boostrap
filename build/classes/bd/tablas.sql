CREATE USER C##userlp1 IDENTIFIED BY 1234567;
ALTER USER C##userlp1 DEFAULT TABLESPACE users;
ALTER USER C##userlp1 TEMPORARY TABLESPACE temp;
ALTER USER C##userlp1 QUOTA UNLIMITED ON users;
GRANT DBA TO C##userlp1;


create table escuela(
    idescuela number GENERATED ALWAYS as identity primary key,
    nombre varchar2(100) not null
)
create table alumno(
 idalumno number GENERATED ALWAYS as identity primary key,
 nombres varchar2(45) not null,
 apellidos varchar2(45) not null,
 idescuela number not null,
 CONSTRAINT fk_escuela FOREIGN KEY (idescuela) references escuela(idescuela) 
)