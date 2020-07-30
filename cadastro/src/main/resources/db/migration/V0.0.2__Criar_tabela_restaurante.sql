-- public.restaurante definition

-- Drop table

-- DROP TABLE public.restaurante;

CREATE TABLE public.restaurante (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	atualizacao timestamp NULL,
	cnpj varchar(255) NULL,
	criacao timestamp NULL,
	nome varchar(255) NULL,
	proprietario varchar(255) NULL,
	localizacao_id int8 NULL,
	CONSTRAINT restaurante_pkey PRIMARY KEY (id)
);


-- public.restaurante foreign keys

ALTER TABLE public.restaurante ADD CONSTRAINT fkdfbggt9ievc4ev74wl3tdnscl FOREIGN KEY (localizacao_id) REFERENCES localizacao(id);