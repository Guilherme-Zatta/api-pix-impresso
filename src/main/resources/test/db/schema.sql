ALTER TABLE IF EXISTS transacoes DROP CONSTRAINT transacoes_conta;
ALTER TABLE IF EXISTS transacoes DROP CONSTRAINT transacoes_caixa;

DROP TABLE IF EXISTS contas;
DROP TABLE IF EXISTS caixas;
DROP TABLE IF EXISTS transacoes;

CREATE TABLE contas (
  id SERIAL ,
  agencia INT,
  numero_conta INT,
  digito_verificador INT,
  nome VARCHAR,
  cpf VARCHAR,
  tipo_conta INT,
  numero_cartao VARCHAR,
  senha VARCHAR,
  saldo DOUBLE PRECISION,
  PRIMARY KEY (ID)
);

CREATE TABLE caixas (
  id SERIAL,
  localizacao VARCHAR,
  saldo DOUBLE PRECISION,
  PRIMARY KEY (ID)
);

CREATE TABLE transacoes (
  id SERIAL,
  conta_id INT,
  caixa_id INT,
  data_hora TIMESTAMP,
  tipo_transacao CHAR,
  valor DOUBLE PRECISION,
  latitude FLOAT8 NULL,
longitude FLOAT8 NULL,
  PRIMARY KEY (ID)
);

ALTER TABLE transacoes 
ADD CONSTRAINT transacoes_conta 
FOREIGN KEY (conta_id) 
REFERENCES contas (id);

ALTER TABLE transacoes 
ADD CONSTRAINT transacoes_caixa 
FOREIGN KEY (caixa_id) 
REFERENCES caixas (id);