CREATE TYPE public.employee_rank AS ENUM ('worker', 'manager');
ALTER TYPE public.employee_rank
 OWNER TO postgres;

CREATE TABLE public.user
(
 username character varying(80) NOT NULL,
 password character varying(80) NOT NULL,
 rank public.employee_rank NOT NULL,
 enabled boolean NOT NULL,
 CONSTRAINT user_pkey PRIMARY KEY (username)
)
WITH (
 OIDS=FALSE
);
ALTER TABLE public.user
 OWNER TO postgres;

CREATE TABLE public.employee
(
 username character varying(80) NOT NULL,
 email character varying(80),
 name character varying(80),
 CONSTRAINT employee_pkey PRIMARY KEY (username),
 CONSTRAINT employee_user_fkey FOREIGN KEY (username)
      REFERENCES public.user (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
 )
WITH (
 OIDS=FALSE
);
ALTER TABLE public.employee
 OWNER TO postgres;

 CREATE TABLE public.store_section
 (
  id bigint NOT NULL,
  name character varying(80) NOT NULL,
  CONSTRAINT store_section_pkey PRIMARY KEY (id)
  )
 WITH (
  OIDS=FALSE
 );
 ALTER TABLE public.store_section
  OWNER TO postgres;

CREATE TYPE public.task_status AS ENUM ('new', 'in-progress', 'done');
ALTER TYPE public.task_status
 OWNER TO postgres;

CREATE TABLE public.task
(
 id bigint NOT NULL,
 name character varying(80) NOT NULL,
 description character varying(600),
 status public.task_status NOT NULL,
 urgent boolean NOT NULL,
 appeal boolean NOT NULL,
 template boolean NOT NULL,
 section_id bigint,
 creation_time timestamp NOT NULL,
 dueTime timestamp,
 creator_username character varying(80),
 CONSTRAINT task_pkey PRIMARY KEY (id),
 CONSTRAINT task_section_fkey FOREIGN KEY (section_id)
      REFERENCES public.store_section (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT task_user_fkey FOREIGN KEY (creator_username)
      REFERENCES public.user (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
 )
WITH (
 OIDS=FALSE
);
ALTER TABLE public.task
 OWNER TO postgres;

CREATE TABLE public.task_employee
(
 task_id bigint NOT NULL,
 username character varying(80) NOT NULL,
 CONSTRAINT task_employee_task_fkey FOREIGN KEY (task_id)
     REFERENCES public.task (id) MATCH SIMPLE
     ON UPDATE NO ACTION ON DELETE NO ACTION,
 CONSTRAINT task_employee_employee_fkey FOREIGN KEY (username)
     REFERENCES public.employee (username) MATCH SIMPLE
     ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
 OIDS=FALSE
);
ALTER TABLE public.task_employee
 OWNER TO postgres;
