-- SCHEMA CRIADO POR WILLIAN VALENTIM: VEMSER_WILLIAN.VALENTIM;
-- FINALIZADO: 30 DE JUN/2022

CREATE TABLE VEMSER_WILLIAN.PAIS(
	ID_PAIS NUMBER(38) NOT NULL,
	NOME VARCHAR(50) NOT NULL,
	PRIMARY KEY(ID_PAIS)
)

CREATE SEQUENCE VEMSER_WILLIAN.SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

CREATE TABLE VEMSER_WILLIAN.ESTADO(
	ID_ESTADO NUMBER(38) NOT NULL,
	ID_PAIS NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY(ID_ESTADO),
	CONSTRAINT FK_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES PAIS (ID_PAIS)
)

CREATE SEQUENCE VEMSER_WILLIAN.SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

CREATE TABLE  VEMSER_WILLIAN.CIDADE(
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	PRIMARY KEY(ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO (ID_ESTADO)
)

CREATE SEQUENCE VEMSER_WILLIAN.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

CREATE TABLE VEMSER_WILLIAN.BAIRRO(
	ID_BAIRRO NUMBER(38) NOT NULL,
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL, 
	PRIMARY KEY(ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_ID_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
)

CREATE SEQUENCE VEMSER_WILLIAN.SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

CREATE TABLE VEMSER_WILLIAN.ENDERECO(
	ID_ENDERECO NUMBER(38) NOT NULL,
	ID_BAIRRO NUMBER(38) NOT NULL, 
	ID_CIDADE NUMBER(38) NOT NULL,
	LOGRADOURO VARCHAR2(255) NOT NULL,
	NUMERO NUMBER(38) NOT NULL,
	COMPLEMENTO VARCHAR2(100),
	CEP CHAR(9),
	PRIMARY KEY(ID_ENDERECO),
	CONSTRAINT FK_ID_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
)

CREATE SEQUENCE VEMSER_WILLIAN.SEQ_ENDERECO
 START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

-- INSERINDO REGISTROS NA TABELA PAIS;
INSERT INTO VEMSER_WILLIAN.PAIS (ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_PAIS.NEXTVAL, 'Brasil');
INSERT INTO VEMSER_WILLIAN.PAIS (ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_PAIS.NEXTVAL, 'Argentina');

-- INSERINDO REGISTROS NA TABELA ESTADO (2 ESTADOS - 1 PAIS);
INSERT INTO VEMSER_WILLIAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_ESTADO.NEXTVAL, 1, 'Ceará');
INSERT INTO VEMSER_WILLIAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_ESTADO.NEXTVAL, 1, 'São Paulo');


INSERT INTO VEMSER_WILLIAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_ESTADO.NEXTVAL, 2, 'Buenos Aires');
INSERT INTO VEMSER_WILLIAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (VEMSER_WILLIAN.SEQ_ESTADO.NEXTVAL, 2, 'La Plata');

-- SELECIONANDO OS REGISTROS PARA OS ESTADOS;
SELECT * FROM VEMSER_WILLIAN.ESTADO;


--INSERINDO REGISTROS DE CIDADES PARA ESTADOS (2 CIDADES - 1 ESTADO);
-- 2 CIDADES PARA O ESTADO CEARÁ;
INSERT INTO VEMSER_WILLIAN.CIDADE  (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 1, 'Fortaleza');
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 1, 'Maranguape');

--2 CIDADES PARA O ESTADO DA SÃO PAULO;
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 2, 'São José dos Campos');
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 2, 'Campinas');

--2 CIDADES PARA BUENOS AIRES;
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 3, 'Villa Maipú');
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 3, 'Merlo');

--2 CIDADES PARA LA PLATA;
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 4, 'Villa Elvira');
INSERT INTO VEMSER_WILLIAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_CIDADE.NEXTVAL, 4, 'Gambier');

-- SELECIONANDO OS REGISTRO PARA AS CIDADES;
SELECT * FROM VEMSER_WILLIAN.VEM_SER.CIDADE


-- INSERINDO REGISTRO DOS BAIRROS PARA AS CIDADES (2 BAIRROS - 1 CIDADE);
-- 2 BAIRROS FORTALEZA;
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 1, 1, 'Meireles');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 1, 1, 'Aldeota');

--2 BAIRROS MARANGUAPE;
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 2, 1, 'Ladeira Grande');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 2, 1, 'Umarizeiras');

-- 2 BAIRROS PARA SÃO JOSÉ DOS CAMPOS;
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 3, 2, 'Jardim Aquarius');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 3, 2, 'Jardim Esplanada');

--2 BAIRROS PARA CAMPINAS
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 4, 2, 'Guanabara');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 4, 2, 'Alto Taquaral');

--2 BAIRROS PARA VILLA MAIPU
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 5, 3, 'Villa Parque São Lorenzo');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 5, 3, 'Villa Lavalle');

--2 BAIRROS PARA MERLO
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 6, 3, 'Lago del Bosque');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 6, 3, 'Barrio Argentino');

--2 BAIRROS PARA VILLA ELVIRA
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 7, 4, 'Barrio Monasterio');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 7, 4, 'Villa Progreso');

--2 BAIRROS PARA GAMBIER
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 8, 4, 'El Retiro');
INSERT INTO VEMSER_WILLIAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (VEMSER_WILLIAN.SEQ_BAIRRO.NEXTVAL, 8, 4, 'Los Hornos');

-- SELECIONANDO OS REGISTROS DOS BAIRROS;
SELECT * FROM VEMSER_WILLIAN.BAIRRO;


--INSERINDO REGISTROS DOS ENDEREÇOS (2 ENDEREÇOS - 1 BAIRRO);
--2 ENDERECOS PARA O BAIRRO MEIRELES;
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 1, 1, 'Rua Joaquim Nabuco', 201, 'Próximo ao Edifício Damasco', '60125-120');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 1, 1, 'Rua Nunes Valente', 123, 'Próximo ao Itaú', '60125-070');

--2 ENDERECOS PARA O BAIRRO ALDEOTA;
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 2, 1, 'Rua Barbosa de Freitas', 1455, 'Ao lado da Praça das Flores', '60170-021');
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 2, 1, 'Rua Tiburcio Cavalcante', 1253, 'Próximo ao Plaza Hotel', '60125-100');

--2 ENDERECOS PARA O BAIRRO DE LADEIRA GRANDE
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 3, 2, 'Rua Tomaz Flores', 10, 'Próximo a praça flores', '22135-010');
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 3, 2, 'Travessa Joaquim Távora', 121, 'Próximo ao Colégio central', '55123-222');

--2 ENDERECOS PARA O BAIRRO DE UMARIZEIRAS
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 4, 2, 'Rua Cavalcante José', 119, 'Em frente a pista', '51221-569');
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 4, 2, 'Rua Maria Bonita', 1210, 'Em a lagoa profunda', '52314-121');

--2 ENDERECOS PARA O BAIRRO JARDIM AQUARIUS
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 5, 3, 'Rua Peixe Escamado', 1037, 'Próximo ao coral', '91234-236');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 5, 3, 'Rua Coral Liso', 1451, 'Próximo ao Peixário', '12230-020');

--2 ENDERECOS PARA O BAIRRO JARDIM ESPLANADA
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 6, 3, 'Rua Flores Amarelas', 1110, 'Próximo as margaridas', '51351-920');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 6, 3, 'Rua Rosa Violeta', 662, 'Próximo ao rosário', '12350-308');

--2 ENDERECOS PARA O BAIRRO GUANABARA
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 7, 4, 'Rua Canindé', 1313, 'Próximo a estatua', '66620-912');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 7, 4, 'Rua Poço Caldas', 1350, 'Próximo a estação', '41411-551');

--2 ENDERECOS PARA O BAIRRO TAQUARAL
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 8, 4, 'Rua Traquilds', 6210, 'Próximo ao ventilador', '43321-131');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 8, 4, 'Travessa Via das Traquilds', 999, 'Próximo ao cruzamento', '22211-005');

--2 ENDERECOS PARA O BAIRRO PARQUE SÃO LORENZO
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 9, 5, 'Rua Lorenzo Plata', 631, 'Próximo a igreja', '66677-789');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 9, 5, 'Rua Lorenzo Cerbo', 1305, 'Próximo ao Lorenzo', '11120-101');

--2 ENDERECOS PARA O BAIRRO LAVALLE
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 10, 5, 'Rua Lavalle Rosas', 303, 'Próximo as rosas brancas', '66212-920');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 10, 5, 'Rua Lavalle Amarelo', 996, 'Próximo ao cortez', '88400-161');

--2 ENDERECOS PARA O BAIRRO DE LAGO DEL BOSQUE
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 11, 6, 'Rua Bosque Dourado', 777, 'Próximo ao Azul', '33311-559');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 11, 6, 'Rua Bosque Rozo', 333, 'Próximo ao Verde', '22211-444');

--2 ENDERECOS PARA O BAIRRO BARRIO ARGENTINO
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 12, 6, 'Rua Barrio Seco', 7143, 'Atravessando o Bosque', '77722-555');
INSERT INTO VEMSER_WILLIAN.ENDERECO  (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 12, 6, 'Rua Barrio Brasileiro', 101, 'Próximo ao Brasil', '49285-222');

--2 ENDERECOS PARA O BAIRRO BARRIO MONASTERIO
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 13, 7, 'Rua Cervejero Monarca', 556, 'Próximo ao castelo', '25987-800');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 13, 7, 'Rua Benedict Barrio', 7812, 'Próximo ao Barrio', '99821-168');

--2 ENDERECOS PARA O BAIRRO VILLA PROGRESO
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 14, 7, 'Rua Retrogrado', 987, 'Próximo ao avanzo', '86491-900');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 14, 7, 'Rua Progreso 2', 2018, 'Próximo ao posto', '31700-198');

--2 ENDERECOS PARA O BAIRRO EL RETIRO
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 15, 8, 'Rua Botando Corda', 561, 'Próximo ao Poste', '77214-911');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 15, 8, 'Travessa Retiro Tudo', 8863, 'Próximo ao Floreto', '99553-331');

--2 ENDERECOS PARA O BAIRRO LOS HORNOS
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 16, 8, 'Rua Los Hermanos', 14528, 'Próximo aos Primos', '51721-009');
INSERT INTO VEMSER_WILLIAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(VEMSER_WILLIAN.SEQ_ENDERECO.NEXTVAL, 16, 8, 'Rua Hornos Agrados', 9541, 'Próximo ao Leste', '00021-762');

-- SELECIONANDO OS REGISTROS DOS ENDEREÇOS;
SELECT * FROM VEMSER_WILLIAN.ENDERECO;

-- RESOLUÇÃO PARA O HOMEWORK2

-- 1) SELECIONAR TODOS OS PAÍSES E ORDENÁ-LOS POR NOME DECRESCENTE;
SELECT * FROM VEMSER_WILLIAN.PAIS ORDER BY NOME DESC;

-- 2) SELECIONAR LOGRADOUROS E CEPS SOMENTE COM OS LOGRADOUROS QUE COMECEM COM 'A' OU 'a';
SELECT LOGRADOURO, CEP FROM VEMSER_WILLIAN.ENDERECO WHERE UPPER(LOGRADOURO) LIKE 'A%';
-- LEMBRETE 'A%' - COMEÇA, '%A' - TERMINA;

-- 3) SELECIONAR TODOS OS ENDEREÇOS QUE TENHAM CEP COM FINAL '0';
SELECT * FROM VEMSER_WILLIAN.ENDERECO WHERE TRIM(CEP) LIKE '%0';

-- 4) SELECIONAR TODOS OS ENDEREÇOS QUE TENHAM NÚMEROS ENTRE 1 E 100;
SELECT * FROM VEMSER_WILLIAN.ENDERECO WHERE NUMERO BETWEEN 1 AND 100;

-- 5) SELECIONAR TODOS OS ENDEREÇOS QUE COMECEM POR 'RUA' E ORDENAR PELO CEP DECRESCENTE;
SELECT * FROM VEMSER_WILLIAN.ENDERECO WHERE LOGRADOURO LIKE 'Rua%' ORDER BY CEP DESC;

-- 6) SELECIONAR A QUANTIDADE DE ENDEREÇOS CADASTRADOS NA TABELA;
SELECT COUNT(ID_ENDERECO) FROM VEMSER_WILLIAN.ENDERECO;

-- 7) SELECIONAR A QUANTIDADE DE ENDEREÇOS CADASTRADOS AGRUPADOS PELO ID DA CIDADE;
SELECT COUNT(ID_ENDERECO) FROM VEMSER_WILLIAN.ENDERECO GROUP BY ID_CIDADE;

