drop schema if exists Oblig3 cascade;

create schema Oblig3;
set search_path to Oblig3;

create table bruker
(
    brukernavn varchar not null,
    passord varchar not null,
    fornavn varchar not null,
    etternavn varchar not null,
    epost varchar not null,

    constraint bruker_pk primary key (brukernavn)
);

insert into bruker(brukernavn, passord, fornavn, etternavn, epost)
values (
'bruker',
'1000:501716e1a27153480e573aa76592924d:491711dca9b8a9cc2cf33e8c14228da8fa79a21a62a9b5469994ba4c40b8d9a6963711a6fbf34a886d942067ffa19141ba8248ce596d9d5525d1c56b4ebb3989',
'Ole',
'Paus',
'opaus@epost.no');


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

