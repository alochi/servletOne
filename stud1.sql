PGDMP         -                v            StudentProgress    10.3    10.3 *    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
    subjects_id integer NOT NULL,
    date character varying NOT NULL,
    exercise character varying,
    id integer NOT NULL
);
    DROP TABLE public.exercises;
       public         postgres    false    3            �            1259    32869    exercises_id_seq    SEQUENCE     y   CREATE SEQUENCE public.exercises_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.exercises_id_seq;
       public       postgres    false    3            �            1259    32871    exercises_id_seq1    SEQUENCE     �   CREATE SEQUENCE public.exercises_id_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.exercises_id_seq1;
       public       postgres    false    3    199            �           0    0    exercises_id_seq1    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.exercises_id_seq1 OWNED BY public.exercises.id;
            public       postgres    false    204            �            1259    24585    progress    TABLE     �   CREATE TABLE public.progress (
    students_id integer NOT NULL,
    mark integer DEFAULT 0,
    attendance boolean,
    exercises_id integer NOT NULL,
    id integer NOT NULL
);
    DROP TABLE public.progress;
       public         postgres    false    3            �            1259    32886    progress_id_seq    SEQUENCE     �   CREATE SEQUENCE public.progress_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.progress_id_seq;
       public       postgres    false    3    197            �           0    0    progress_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.progress_id_seq OWNED BY public.progress.id;
            public       postgres    false    205            �            1259    24579    students    TABLE     �   CREATE TABLE public.students (
    name character varying(200) NOT NULL,
    passwordhash character varying DEFAULT 123 NOT NULL,
    id integer NOT NULL,
    role integer DEFAULT 2 NOT NULL,
    login character varying DEFAULT 0 NOT NULL
);
    DROP TABLE public.students;
       public         postgres    false    3            �            1259    32851    students_id_seq    SEQUENCE     x   CREATE SEQUENCE public.students_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.students_id_seq;
       public       postgres    false    3            �            1259    32853    students_id_seq1    SEQUENCE     �   CREATE SEQUENCE public.students_id_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.students_id_seq1;
       public       postgres    false    196    3            �           0    0    students_id_seq1    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.students_id_seq1 OWNED BY public.students.id;
            public       postgres    false    202            �            1259    24652    subjects    TABLE     b   CREATE TABLE public.subjects (
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
       public         postgres    false    3            
           2604    32873    exercises id    DEFAULT     m   ALTER TABLE ONLY public.exercises ALTER COLUMN id SET DEFAULT nextval('public.exercises_id_seq1'::regclass);
 ;   ALTER TABLE public.exercises ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    199            	           2604    32888    progress id    DEFAULT     j   ALTER TABLE ONLY public.progress ALTER COLUMN id SET DEFAULT nextval('public.progress_id_seq'::regclass);
 :   ALTER TABLE public.progress ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    197                       2604    32855    students id    DEFAULT     k   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq1'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    196            �          0    24660 	   exercises 
   TABLE DATA               D   COPY public.exercises (subjects_id, date, exercise, id) FROM stdin;
    public       postgres    false    199   �)       �          0    24585    progress 
   TABLE DATA               S   COPY public.progress (students_id, mark, attendance, exercises_id, id) FROM stdin;
    public       postgres    false    197   B*       �          0    24579    students 
   TABLE DATA               G   COPY public.students (name, passwordhash, id, role, login) FROM stdin;
    public       postgres    false    196   �*       �          0    24652    subjects 
   TABLE DATA               /   COPY public.subjects (id, subject) FROM stdin;
    public       postgres    false    198   �+       �          0    32815    users 
   TABLE DATA               @   COPY public.users (id, login, "passwordHash", role) FROM stdin;
    public       postgres    false    200   ,       �           0    0    exercises_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.exercises_id_seq', 1, false);
            public       postgres    false    203            �           0    0    exercises_id_seq1    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.exercises_id_seq1', 8, true);
            public       postgres    false    204            �           0    0    progress_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.progress_id_seq', 13, true);
            public       postgres    false    205            �           0    0    students_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.students_id_seq', 1, false);
            public       postgres    false    201            �           0    0    students_id_seq1    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.students_id_seq1', 15, true);
            public       postgres    false    202                       2606    32882    exercises exercises_id_pk 
   CONSTRAINT     W   ALTER TABLE ONLY public.exercises
    ADD CONSTRAINT exercises_id_pk PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.exercises DROP CONSTRAINT exercises_id_pk;
       public         postgres    false    199                       2606    32894    progress progress_id_pk 
   CONSTRAINT     U   ALTER TABLE ONLY public.progress
    ADD CONSTRAINT progress_id_pk PRIMARY KEY (id);
 A   ALTER TABLE ONLY public.progress DROP CONSTRAINT progress_id_pk;
       public         postgres    false    197                       2606    32861    students students_id_pk 
   CONSTRAINT     U   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_id_pk PRIMARY KEY (id);
 A   ALTER TABLE ONLY public.students DROP CONSTRAINT students_id_pk;
       public         postgres    false    196                       2606    24659    subjects subjects_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.subjects
    ADD CONSTRAINT subjects_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.subjects DROP CONSTRAINT subjects_pkey;
       public         postgres    false    198                       2606    32822    users user_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);
 9   ALTER TABLE ONLY public.users DROP CONSTRAINT user_pkey;
       public         postgres    false    200                       1259    32880    exercises_id_uindex    INDEX     N   CREATE UNIQUE INDEX exercises_id_uindex ON public.exercises USING btree (id);
 '   DROP INDEX public.exercises_id_uindex;
       public         postgres    false    199                       1259    32892    progress_id_uindex    INDEX     L   CREATE UNIQUE INDEX progress_id_uindex ON public.progress USING btree (id);
 &   DROP INDEX public.progress_id_uindex;
       public         postgres    false    197                       1259    32859    students_id_uindex    INDEX     L   CREATE UNIQUE INDEX students_id_uindex ON public.students USING btree (id);
 &   DROP INDEX public.students_id_uindex;
       public         postgres    false    196            �   �   x�M���0F��>/�i�\]�'��p�%�����d����˩P(��ε��{���?S'��1o�}XQ��Ž�i��Q����O�:^}�/��2��}���

���EBtC6��A��~e�|g��	�E�T��}t8��@D_�2�      �   O   x�%���0�PLd�룘�S��W��7a�@U�\gw>N���&��E5�����|�K�=���u��;'�      �     x�=��j�0��ڧ��?�9�4��L{�e[omY*�-�<}W[���������kH�)�W��T�J���1,!aq�֣2mUp�y̚��_�)�����H���Q,���t'��v�-�c�[�ebJ�h��'�D��d�:L�Q�_�X��sg���8C\h�V�^��cy,^)xۇ���V��ˇ�����mp�H��{�9H{�����*��砍��h	�*�_��1_���b]��Eե�f��s� ����)���Y����x�?I�r�      �   6   x�3�t�K��,��2��M,��2�)*M�2�(�,�O�/KMI��L����� ?�q      �      x�3�,IML�H-�442�4����� =��     