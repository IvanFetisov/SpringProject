create table ruler
(
    name varchar(255) not null
        constraint person_pBook
            primary key,
    age  integer      not null
);

alter table person

    owner to postgres;

INSERT INTO public.person (name, age) VALUES ('Екатерина', 142);
INSERT INTO public.person (name, age) VALUES ('Владимир', 1223);
INSERT INTO public.person (name, age) VALUES ('Михаил', 357);
INSERT INTO public.person (name, age) VALUES ('Земля', 124812);
INSERT INTO public.person (name, age) VALUES ('Андрей', 12);
INSERT INTO public.person (name, age) VALUES ('Сергей', 145);
INSERT INTO public.person (name, age) VALUES ('Олеся', 142);
INSERT INTO public.person (name, age) VALUES ('Софья', 145);
INSERT INTO public.person (name, age) VALUES ('Юрий', 2891);