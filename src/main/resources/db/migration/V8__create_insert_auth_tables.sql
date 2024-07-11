CREATE TABLE `SystemRole` (
                              SystemRoleId TINYINT NOT NULL,
                              Name varchar(64) NOT NULL,
                              PRIMARY KEY (SystemRoleId)
);

INSERT INTO SystemRole(SystemRoleId, Name) VALUES (1, 'HR');
INSERT INTO SystemRole(SystemRoleId, Name) VALUES (2, 'Management');

CREATE TABLE `User` (
                        Username varchar(64) NOT NULL,
                        Password varchar(64) NOT NULL,
                        SystemRoleId TINYINT NOT NULL,
                        PRIMARY KEY (Username),
                        FOREIGN KEY (SystemRoleId) REFERENCES SystemRole(SystemRoleId)
);

INSERT INTO User(Username, Password, SystemRoleId) VALUES ('HR', 'HR', 1);
INSERT INTO User(Username, Password, SystemRoleId) VALUES ('Management', 'Management', 2);