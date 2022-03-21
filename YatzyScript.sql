drop schema if exists Oblig3 cascade;

create schema Oblig3;
set search_path to Oblig3;

create table bruker
(
    brukernavn varchar not null,
    passord varchar not null,
    fornavn varchar not null,
    etternavn varchar not null,
    email varchar not null,

    constraint bruker_pk primary key (brukernavn)
);

insert into bruker(brukernavn, passord, fornavn, etternavn, email)
values ('tester', 'tester123', 'teste', 'testesen', 't.testesen@gmail.com');