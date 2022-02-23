create table planet
(
    name       varchar(255) not null
        constraint book_pkey
            primary key,
    ruler_name varchar(255)
        constraint fkijuo7lw6k0lrl70p5nuk3wigm
            references person
);

alter table book
    owner to postgres;

INSERT INTO public.book (name, ruler_name) VALUES ('Земля', 'Владимир');
INSERT INTO public.book (name, ruler_name) VALUES ('Венера', 'Владимир');
INSERT INTO public.book (name, ruler_name) VALUES ('Сатурн', 'Екатерина');
INSERT INTO public.book (name, ruler_name) VALUES ('Меркурий', 'Михаил');
INSERT INTO public.book (name, ruler_name) VALUES ('Марс', 'Земля');
INSERT INTO public.book (name, ruler_name) VALUES ('Уран', 'Андрей');
INSERT INTO public.book (name, ruler_name) VALUES ('Плутон', 'Андрей');
INSERT INTO public.book (name, ruler_name) VALUES ('Kepler-186 f', null);