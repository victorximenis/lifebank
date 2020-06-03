/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : PostgreSQL
 Source Server Version : 110005
 Source Host           : localhost:5432
 Source Catalog        : lifebank
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110000
 File Encoding         : 65001

 Date: 03/06/2050 19:41:28
*/


-- ----------------------------
-- Sequence structure for boletos_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "boletos_id_seq";
CREATE SEQUENCE "boletos_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for emissores_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "emissores_id_seq";
CREATE SEQUENCE "emissores_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for enderecos_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "enderecos_id_seq";
CREATE SEQUENCE "enderecos_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for pessoas_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "pessoas_id_seq";
CREATE SEQUENCE "pessoas_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for boletos
-- ----------------------------
DROP TABLE IF EXISTS "boletos";
CREATE TABLE "boletos" (
  "id" int8 NOT NULL DEFAULT nextval('boletos_id_seq'::regclass),
  "descricao_1" varchar(255) COLLATE "pg_catalog"."default",
  "descricao_2" varchar(255) COLLATE "pg_catalog"."default",
  "descricao_3" varchar(255) COLLATE "pg_catalog"."default",
  "descricao_4" varchar(255) COLLATE "pg_catalog"."default",
  "descricao_5" varchar(255) COLLATE "pg_catalog"."default",
  "instrucao_1" varchar(255) COLLATE "pg_catalog"."default",
  "instrucao_2" varchar(255) COLLATE "pg_catalog"."default",
  "instrucao_3" varchar(255) COLLATE "pg_catalog"."default",
  "instrucao_4" varchar(255) COLLATE "pg_catalog"."default",
  "instrucao_5" varchar(255) COLLATE "pg_catalog"."default",
  "local_pagamento1" varchar(255) COLLATE "pg_catalog"."default",
  "local_pagamento2" varchar(255) COLLATE "pg_catalog"."default",
  "nosso_numero" int4,
  "valor" float8,
  "emissor_id" int8,
  "pessoa_id" int8
)
;

-- ----------------------------
-- Records of boletos
-- ----------------------------
BEGIN;
INSERT INTO "boletos" VALUES (1, NULL, NULL, NULL, NULL, NULL, 'PREENCHER O VALOR A SER PAGO NO CAMPO <VALOR DO DOCUMENTO>', 'FATURAS PAGAS APOS O VENCIMENTO TERÃO ACRESCIMO E ENCARGOS, CALCULADOS A PARTIR DA DATA DO VENCIMENTO', 'E INCLUIDOS NA SUA PROXIMA FATURA MENSAL. APOS 22/06/2020, PAGAR SOMENTE NAS AGENCIAS DO SANTANDER.', NULL, NULL, 'Pagável em qualquer agência ou casa lotérica', NULL, 12545266, 249.58, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for emissores
-- ----------------------------
DROP TABLE IF EXISTS "emissores";
CREATE TABLE "emissores" (
  "id" int8 NOT NULL DEFAULT nextval('emissores_id_seq'::regclass),
  "agencia" int4,
  "agencia_digito" varchar(255) COLLATE "pg_catalog"."default",
  "carteira" int4,
  "cedente" varchar(255) COLLATE "pg_catalog"."default",
  "conta" int4,
  "convenio" int4,
  "digito_conta" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of emissores
-- ----------------------------
BEGIN;
INSERT INTO "emissores" VALUES (1, 1824, '4', 18, 'Conductor Tecnologia em Meios de Pagamento', 76000, 1207113, '5');
COMMIT;

-- ----------------------------
-- Table structure for enderecos
-- ----------------------------
DROP TABLE IF EXISTS "enderecos";
CREATE TABLE "enderecos" (
  "id" int8 NOT NULL DEFAULT nextval('enderecos_id_seq'::regclass),
  "bairro" varchar(255) COLLATE "pg_catalog"."default",
  "cep" varchar(255) COLLATE "pg_catalog"."default",
  "cidade" varchar(255) COLLATE "pg_catalog"."default",
  "logradouro" varchar(255) COLLATE "pg_catalog"."default",
  "uf" varchar(255) COLLATE "pg_catalog"."default",
  "pessoa_id" int8
)
;

-- ----------------------------
-- Records of enderecos
-- ----------------------------
BEGIN;
INSERT INTO "enderecos" VALUES (1, 'Pedro Gondim', '58031106', 'João Pessoa', 'Antônio Régis de Brito, 15', 'PB', 1);
COMMIT;

-- ----------------------------
-- Table structure for pessoas
-- ----------------------------
DROP TABLE IF EXISTS "pessoas";
CREATE TABLE "pessoas" (
  "id" int8 NOT NULL DEFAULT nextval('pessoas_id_seq'::regclass),
  "cpf" varchar(255) COLLATE "pg_catalog"."default",
  "nome" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of pessoas
-- ----------------------------
BEGIN;
INSERT INTO "pessoas" VALUES (1, '08277568444', 'Victor Hugo da Silva Ximenis');
COMMIT;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "boletos_id_seq"
OWNED BY "boletos"."id";
SELECT setval('"boletos_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "emissores_id_seq"
OWNED BY "emissores"."id";
SELECT setval('"emissores_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "enderecos_id_seq"
OWNED BY "enderecos"."id";
SELECT setval('"enderecos_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "pessoas_id_seq"
OWNED BY "pessoas"."id";
SELECT setval('"pessoas_id_seq"', 2, true);

-- ----------------------------
-- Primary Key structure for table boletos
-- ----------------------------
ALTER TABLE "boletos" ADD CONSTRAINT "boletos_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table emissores
-- ----------------------------
ALTER TABLE "emissores" ADD CONSTRAINT "emissores_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table enderecos
-- ----------------------------
ALTER TABLE "enderecos" ADD CONSTRAINT "enderecos_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table pessoas
-- ----------------------------
ALTER TABLE "pessoas" ADD CONSTRAINT "pessoas_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table boletos
-- ----------------------------
ALTER TABLE "boletos" ADD CONSTRAINT "fk2um94rdo4b2o0dniplnpobolv" FOREIGN KEY ("emissor_id") REFERENCES "emissores" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "boletos" ADD CONSTRAINT "fkcsglb46gkib3ytigqfws71v5c" FOREIGN KEY ("pessoa_id") REFERENCES "pessoas" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table enderecos
-- ----------------------------
ALTER TABLE "enderecos" ADD CONSTRAINT "fk4uegllbf38r29n8a1h5m9ev7q" FOREIGN KEY ("pessoa_id") REFERENCES "pessoas" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
