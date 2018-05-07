PGDMP     6    .                v            StudentProgress    10.3    10.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    24576    StudentProgress    DATABASE     �   CREATE DATABASE "StudentProgress" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
 !   DROP DATABASE "StudentProgress";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12278    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24660 	   exercises    TABLE     �   CREATE TABLE public.exercises (
    id integer NOT NULL,
    subjects_id integer NOT NULL,
    date date NOT NULL,
    exercise character varying
);
    DROP TABLE public.exercises;
       public         postgres    false    3            �            1259    24585    progress    TABLE     �   CREATE TABLE public.progress (
    id integer NOT NULL,
    students_id integer NOT NULL,
    mark integer,
    attendance boolean,
    exercises_id integer NOT NULL
);
    DROP TABLE public.progress;
       public         postgres    false    3            �            1259    24579    students    TABLE     d   CREATE TABLE public.students (
    id integer NOT NULL,
    name character varying(200) NOT NULL
);
    DROP TABLE public.students;
       public         postgres    false    3            �            1259    24577    students_id_seq    SEQUENCE     �   CREATE SEQUENCE public.students_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.students_id_seq;
       public       postgres    false    197    3            �           0    0    students_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.students_id_seq OWNED BY public.students.id;
            public       postgres    false    196            �            1259    24652    subjects    TABLE     b   CREATE TABLE public.subjects (
    id integer NOT NULL,
    subject character varying NOT NULL
);
    DROP TABLE public.subjects;
       public         postgres    false    3            �           2604    24582    students id    DEFAULT     j   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            |          0    24660 	   exercises 
   TABLE DATA               D   COPY public.exercises (id, subjects_id, date, exercise) FROM stdin;
    public       postgres    false    200   �       z          0    24585    progress 
   TABLE DATA               S   COPY public.progress (id, students_id, mark, attendance, exercises_id) FROM stdin;
    public       postgres    false    198   �       y          0    24579    students 
   TABLE DATA               ,   COPY public.students (id, name) FROM stdin;
    public       postgres    false    197   �       {          0    24652    subjects 
   TABLE DATA               /   COPY public.subjects (id, subject) FROM stdin;
    public       postgres    false    199   E       �           0    0    students_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.students_id_seq', 1, false);
            public       postgres    false    196            �           2606    24667    exercises exercises_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.exercises
    ADD CONSTRAINT exercises_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.exercises DROP CONSTRAINT exercises_pkey;
       public         postgres    false    200            �           2606    24589    progress progress_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.progress
    ADD CONSTRAINT progress_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.progress DROP CONSTRAINT progress_pkey;
       public         postgres    false    198            �           2606    24584    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public         postgres    false    197            �           2606    24659    subjects subjects_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT subjects_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.subjects DROP CONSTRAINT subjects_pkey;
       public         postgres    false    199            |   (   x�3�4�4�47�50"N�ԢҼ������T�=... ��%      z      x�3�4�4�,�4����� �      y   C   x�3��,K��/S Q\F��%E@�c^JQj%�1�wQiI~Y��gQf^"�	g@~�뚓
���qqq ù\      {      x�3�t�K��,������� !��     