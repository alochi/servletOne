PGDMP
     '    0        
        v            StudentProgress    10.3    10.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
             postgres    false            �           0    0 
   SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
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
    mark integer DEFAULT 0,
    attendance boolean,
    exercises_id integer NOT NULL
);
    DROP TABLE public.progress;
       public         postgres    false    3            �            1259    32812    progress_id_seq    SEQUENCE     x   CREATE SEQUENCE public.progress_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.progress_id_seq;
       public       postgres    false    198    3            �           0    0    progress_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.progress_id_seq OWNED BY public.progress.id;
            public       postgres    false    201            �            1259    24579    students    TABLE        CREATE TABLE public.students (
    id integer NOT NULL,
    login character varying(200) NOT NULL,
    num integer DEFAULT 0
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
       public         postgres    false    3            �            1259    32815    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    login character varying NOT NULL,
    "passwordHash" character varying NOT NULL,
    role integer
);
    DROP TABLE public.users;
       public         postgres    false    3                        2604    32814    progress id    DEFAULT     j   ALTER TABLE ONLY public.progress ALTER COLUMN id SET DEFAULT nextval('public.progress_id_seq'::regclass);
 :   ALTER TABLE public.progress ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    198            �           2604    24582    students id    DEFAULT     j   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �          0    24660 	   exercises 
   TABLE DATA               D   COPY public.exercises (id, subjects_id, date, exercise) FROM stdin;
    public       postgres    false    200   �       �          0    24585    progress 
   TABLE DATA               S   COPY public.progress (id, students_id, mark, attendance, exercises_id) FROM stdin;
    public       postgres    false    198   B       �          0    24579    students 
   TABLE DATA               1   COPY public.students (id, login, num) FROM stdin;
    public       postgres    false    197   �       �          0    24652    subjects 
   TABLE DATA               /   COPY public.subjects (id, subject) FROM stdin;
    public       postgres    false    199   �       �          0    32815    users 
   TABLE DATA               @   COPY public.users (id, login, "passwordHash", role) FROM stdin;
    public       postgres    false    202           �           0    0    progress_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.progress_id_seq', 1, true);
            public       postgres    false    201            �           0    0    students_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.students_id_seq', 1, false);
            public       postgres    false    196                       2606    24667    exercises exercises_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.exercises
    ADD CONSTRAINT exercises_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.exercises DROP CONSTRAINT exercises_pkey;
       public         postgres    false    200                       2606    24589    progress progress_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.progress
    ADD CONSTRAINT progress_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.progress DROP CONSTRAINT progress_pkey;
       public         postgres    false    198                       2606    24584    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public         postgres    false    197                       2606    24659    subjects subjects_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT subjects_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.subjects DROP CONSTRAINT subjects_pkey;
       public         postgres    false    199            
           2606    32822    users user_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 9   ALTER TABLE ONLY public.users DROP CONSTRAINT user_pkey;
       public         postgres    false    202            �   ]   x�3�4�420��50�50�tO-*�KQ(�(J,N�2�4B����M��K,�/��N�2�4FHZp�Ugd�%�e�r� k��	J�-N�L����� ?�4      �   8   x�-��
  C�s;�]�1�?"z{��@��K9��j���s��i��K��<��
�      �   Q   x�3��/�/KTp�I�K�456�2��.*-�yeŌM�9=����@PĘˈ3 ��(☗R�Z	3����� ��      �   %   x�3�t�K��,��2��M,��2�)*M����� y�k      �   $   x�3�,-N-�\���)��y��FƜ�\1z\\\ ��     