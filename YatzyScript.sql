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

create table yatzyspill
(
    spillid serial not null,
    admin varchar not null,

    constraint yatzyspill_pk primary key (spillid),

    constraint bruker_fk foreign key (admin)
    references Oblig3.bruker (brukernavn) match simple
);

create table spilldeltakelse
(
    spillid serial not null,
    spillerid varchar not null,

    constraint spilldeltakelse_pk primary key (spillid, spillerid),

    constraint spillid_fk foreign key (spillid)
    references Oblig3.yatzyspill (spillid) match simple,

    constraint bruker_fk foreign key (spillerid)
    references Oblig3.bruker (brukernavn) match simple
);

create table rundeoversikt
(
    rundenr smallint not null,
    spillid serial not null,
    spiller1score smallint,
    spiller2score smallint,
    spiller3score smallint,
    spiller4score smallint,
    spiller5score smallint,
    spiller6score smallint,

    constraint rundeoversikt_pk primary key (spillid, rundenr),

    constraint spillid_fk foreign key (spillid)
    references Oblig3.yatzyspill (spillid) match simple
);

