DROP TABLE IF EXISTS COMPUTER;
DROP TABLE IF EXISTS COMPANY;

CREATE TABLE COMPANY( 
IDCOMPANY INT NOT NULL AUTO_INCREMENT, 
NAMECOMPANY VARCHAR(255),
PRIMARY KEY (IDCOMPANY)
);

CREATE TABLE COMPUTER( 
ID INT NOT NULL AUTO_INCREMENT, 
NAME VARCHAR(255),
INTRODUCED DATE,
DISCONTINUED DATE,
IDCOMPANY INT,
PRIMARY KEY (ID),
FOREIGN KEY(IDCOMPANY) REFERENCES COMPANY(IDCOMPANY)
);

INSERT INTO COMPANY (NAMECOMPANY) VALUES('Apple Inc.');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('Thinking Machines');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('Netronics');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('RCA');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('Tandy Corporation');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('Commodore International');
INSERT INTO COMPANY (NAMECOMPANY) VALUES('ASUS');

INSERT INTO COMPUTER (NAME,INTRODUCED,DISCONTINUED,IDCOMPANY) VALUES ('Mac Book Air','2001-05-05','2005-05-05',1);
INSERT INTO COMPUTER (NAME,INTRODUCED,DISCONTINUED,IDCOMPANY) VALUES ('Mac Book Retina','null','null',1);