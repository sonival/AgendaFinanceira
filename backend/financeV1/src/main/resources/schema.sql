DROP TABLE IF EXISTS AGENDAMENTO_TRANSFERENCIA;
CREATE TABLE AGENDAMENTO_TRANSFERENCIA
(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contaorigem DOUBLE DEFAULT NULL,
    contadestino DOUBLE DEFAULT NULL,
    taxa DOUBLE DEFAULT NULL,
    dataagendamento DATE NULL, 
    datatransferencia DATE NULL
)