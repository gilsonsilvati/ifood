-- public.prato definition

-- Drop table

-- DROP TABLE public.prato;

CREATE TABLE public.prato (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	descricao varchar(255) NULL,
	nome varchar(255) NULL,
	preco numeric(19,2) NULL,
	restaurante_id int8 NULL,
	CONSTRAINT prato_pkey PRIMARY KEY (id)
);


-- public.prato foreign keys

ALTER TABLE public.prato ADD CONSTRAINT fk43yo4ddilkvn6ebgfcx2vnqs7 FOREIGN KEY (restaurante_id) REFERENCES restaurante(id);